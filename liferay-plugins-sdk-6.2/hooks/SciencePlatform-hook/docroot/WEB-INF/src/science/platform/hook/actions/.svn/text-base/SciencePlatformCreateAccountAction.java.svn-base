package science.platform.hook.actions;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import science.platform.model.SpAffiliation;
import science.platform.model.SpDomain;
import science.platform.model.SpUser;
import science.platform.model.SpUserDomain;
import science.platform.service.SpAffiliationLocalServiceUtil;
import science.platform.service.SpDomainLocalServiceUtil;
import science.platform.service.SpRegionLocalServiceUtil;
import science.platform.service.SpUserDomainLocalServiceUtil;
import science.platform.service.SpUserLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

public class SciencePlatformCreateAccountAction extends BaseStrutsPortletAction {
	protected static Log _log = LogFactoryUtil.getLog(SciencePlatformCreateAccountAction.class);
	
	@Override
	public void processAction( 	StrutsPortletAction originalStrutsPortletAction,
										PortletConfig portletConfig, 
										ActionRequest actionRequest,
										ActionResponse actionResponse) throws Exception {
		
		_log.info("processAction()");
		
		originalStrutsPortletAction.processAction(portletConfig, actionRequest, actionResponse);
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(	WebKeys.THEME_DISPLAY);

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		 if (cmd.equals(Constants.ADD)){
				_log.info("Add SpUser");
				Company company = themeDisplay.getCompany();
				String screenName = ParamUtil.getString(actionRequest, "screenName");
				User user = UserLocalServiceUtil.getUserByScreenName(company.getCompanyId(), screenName);
				_log.debug("New User ID: "+user.getUserId());
				
				this.addSpUser(actionRequest, actionResponse, user.getUserId());
				
				_log.info("Add created user to default site...");
				/*
				 * Even if a user is trying to create account through one of the child sites, the user registered as 
				 * a member of the topmost site.   
				 */
				Group currentSite = themeDisplay.getSiteGroup();
				_log.debug(themeDisplay.getSiteGroupName());
				long topmostSiteId = currentSite.getGroupId();
				long parentSiteId = currentSite.getParentGroupId();
				while(parentSiteId > 0){
					topmostSiteId = parentSiteId;
					Group group = GroupLocalServiceUtil.getGroup(parentSiteId);
					parentSiteId = group.getParentGroupId();
				}
				UserLocalServiceUtil.addGroupUser(topmostSiteId, user);
		}
		else  if (cmd.equals(Constants.UPDATE)) {
		}
	}
	

	/** 
	 * @param originalStrutsPortletAction
	 * @param portletConfig
	 * @param renderRequest
	 * @param renderResponse
	 * @return
	 * @throws Exception
	 * 
	 * Also see @see com.liferay.portal.kernel.struts.BaseStrutsPortletAction#render(com.liferay.portal.kernel.struts.StrutsPortletAction, javax.portlet.PortletConfig, javax.portlet.RenderRequest, javax.portlet.RenderResponse).
	 */
	@Override
	public String render(StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		return originalStrutsPortletAction.render(portletConfig, renderRequest, renderResponse);
	}

	protected SpUser addSpUser(ActionRequest actionRequest, ActionResponse actionResponse, long userId){
		long countryId = ParamUtil.getLong(actionRequest, "countryId");
		long regionId = ParamUtil.getLong(actionRequest, "regionId");
		long affiliationId = ParamUtil.getLong(actionRequest, "affiliationId");
		long[] domainIds = ParamUtil.getLongValues(actionRequest, "domainId");

		Map<Locale, String> firstNameMap = LocalizationUtil.getLocalizationMap(actionRequest, "firstName");
		
		SpUser spUser = SpUserLocalServiceUtil.createSpUser(userId);
		spUser.setSpCountryId(countryId);
		spUser.setSpRegionId(regionId);
		spUser.setSpAffiliationId(affiliationId);
		spUser.setSpUserFullNameMap(firstNameMap);
		
		List<SpUserDomain> userDomainList = new ArrayList<SpUserDomain>();
		for(long domainId : domainIds){
			SpUserDomain spUserDomain;
			try {
				spUserDomain = SpUserDomainLocalServiceUtil.createSpUserDomain(userId, domainId);
				SpUserDomainLocalServiceUtil.addSpUserDomain(spUserDomain);
				userDomainList.add(spUserDomain);
			} catch (SystemException e) {
				try {
					UserLocalServiceUtil.deleteUser(userId);
					for(SpUserDomain userDomain : userDomainList){
						SpUserDomainLocalServiceUtil.deleteSpUserDomain(userDomain);
					}
				} catch (PortalException | SystemException e1) {
					_log.error("ERROR: while deleting user or domains");
				}
				_log.error("ERROR: while create user domains");
			}
		}
		
		try {
			spUser = SpUserLocalServiceUtil.addSpUser(spUser);
		} catch (SystemException e) {
			_log.error("ERROR: while adding SpUser-"+userId);
		}

		return spUser;
	}

	@Override
	public void serveResource(StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws Exception {
		//System.out.println("########### AJAX CALL ##################" + ParamUtil.getString(resourceRequest, "method"));
		String method = ParamUtil.getString(resourceRequest, "method");
		long countryId = ParamUtil.getLong(resourceRequest, "countryId");
		
		_log.debug("Method: "+method+"\nCountry ID: "+countryId);

		resourceResponse.setContentType("text/html");
        PrintWriter writer = resourceResponse.getWriter();
		Locale locale = resourceRequest.getLocale();
		_log.debug("local: "+locale.getDisplayCountry());
		if(method.equalsIgnoreCase("getRegionStrList")){
			JSONArray regionList = SpRegionLocalServiceUtil.getRegionNames(countryId, locale);
			_log.debug("REGIONS: "+regionList.toString());
	        
			writer.print(regionList.toString());
		}
		else if(method.equalsIgnoreCase("getAffiliationStrList")){
			long regionId = ParamUtil.getLong(resourceRequest, "regionId");
			String target = ParamUtil.getString(resourceRequest, "target");
			
			JSONArray jsonAffiliations = JSONFactoryUtil.createJSONArray();
			List<SpAffiliation> affiliationList = null;
			if(target.equalsIgnoreCase("all")){
				affiliationList = SpAffiliationLocalServiceUtil.getAll();
			} 
			else if(target.equalsIgnoreCase("byCountry")){
				affiliationList = SpAffiliationLocalServiceUtil.getSpAffiliationListByCountryId(countryId);
			}
			else if(target.equalsIgnoreCase("byRegion")){
				affiliationList = SpAffiliationLocalServiceUtil.getSpAffiliationListByRegionId(regionId);
			}
			
			for(SpAffiliation affiliation : affiliationList){
				JSONObject jsonAffiliation = JSONFactoryUtil.createJSONObject();
				jsonAffiliation.put("affiliationId", affiliation.getSpAffiliationId());
				jsonAffiliation.put("affiliationName", affiliation.getSpAffiliationName(locale));
				jsonAffiliations.put(jsonAffiliation);
			}

			writer.print(jsonAffiliations.toString());
		}
		else if(method.equalsIgnoreCase("getDomainStrList")){
			JSONArray jsonDomains = JSONFactoryUtil.createJSONArray();
			List<SpDomain> domainList = SpDomainLocalServiceUtil.getAll();
			for(SpDomain domain : domainList){
				JSONObject jsonDomain = JSONFactoryUtil.createJSONObject();
				jsonDomain.put("domainId", domain.getSpDomainId());
				jsonDomain.put("domainName", domain.getSpDomainName(locale));
				jsonDomains.put(jsonDomain);
			}
			writer.print(jsonDomains.toString());
			_log.debug("Domains: "+ jsonDomains.toString());
		}
		
        writer.flush();
        writer.close();
		
		super.serveResource(originalStrutsPortletAction, portletConfig,
				resourceRequest, resourceResponse);
	}

	
}
