package science.platform.hook.actions;

import java.io.PrintWriter;
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
import science.platform.service.SpAffiliationLocalServiceUtil;
import science.platform.service.SpDomainLocalServiceUtil;
import science.platform.service.SpRegionLocalServiceUtil;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

public class SciencePlatformEditUserAction extends BaseStrutsPortletAction {
	Log _log = LogFactoryUtil.getLog(SciencePlatformEditUserAction.class);

	@Override
	public void processAction(
			StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, 
			ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {
		
		_log.debug("processAction()");

		originalStrutsPortletAction.processAction(portletConfig, actionRequest, actionResponse);
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(	WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		_log.debug("COMMAND: "+cmd);

		if (cmd.equals(Constants.ADD)) {
			String screenName = ParamUtil.getString(actionRequest, "screenName");
			User user = UserLocalServiceUtil.getUserByScreenName(companyId, screenName);
			this.addSpUser(actionRequest, user.getUserId());
		}
		else if ( cmd.equals(Constants.DELETE) ){
			this.deleteSpUsers(actionRequest);
		}
		else if (cmd.equals(Constants.UPDATE)) {
			User user = PortalUtil.getSelectedUser(actionRequest);
			this.updateSpUser(actionRequest, actionResponse, user.getUserId());
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
		
		User user = PortalUtil.getSelectedUser(renderRequest);
		if(user != null){
			ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(	WebKeys.THEME_DISPLAY);
			JSONObject userInfo = SpUserLocalServiceUtil.getUserInfo(user.getUserId(), themeDisplay.getLocale());
			_log.debug("UserInfo: "+userInfo.toString());
			renderRequest.setAttribute("userInfo", userInfo.toString());
		}
		
		return originalStrutsPortletAction.render(portletConfig, renderRequest,
				renderResponse);
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
		
        super.serveResource(originalStrutsPortletAction, portletConfig, resourceRequest, resourceResponse);
		//originalStrutsPortletAction.serveResource(portletConfig, resourceRequest, resourceResponse);
	}


	protected SpUser addSpUser(ActionRequest actionRequest, long userId) {
		long countryId = ParamUtil.getLong(actionRequest, "countryId");
		long regionId = ParamUtil.getLong(actionRequest, "regionId");
		long affiliationId = ParamUtil.getLong(actionRequest, "affiliationId");
		long[] domainIds = ParamUtil.getLongValues(actionRequest, "domainIds");
		Map<Locale, String> firstNameMap = LocalizationUtil.getLocalizationMap(actionRequest, "firstName");
		
		SpUser spUser = SpUserLocalServiceUtil.createSpUser(userId);
		spUser.setSpUserFullNameMap(firstNameMap);
		spUser.setSpCountryId(countryId);
		spUser.setSpRegionId(regionId);
		spUser.setSpAffiliationId(affiliationId);
		
		try {
			spUser = SpUserLocalServiceUtil.addSpUser(spUser, domainIds);
		} catch (SystemException e) {
			_log.error("adding SpUser-"+userId);
			try {
				UserLocalServiceUtil.deleteUser(userId);
			} catch (PortalException | SystemException e1) {
				_log.error("deleteUser()- while adding SpUser-"+userId);
			}
		}

		return spUser;
	}

	protected void deleteSpUsers(ActionRequest actionRequest) {
		long[] deleteUserIds = StringUtil.split(
			ParamUtil.getString(actionRequest, "deleteUserIds"), 0L);

		for (long deleteUserId : deleteUserIds) {
			try {
				SpUserLocalServiceUtil.deleteSpUser(deleteUserId);
			} catch (PortalException | SystemException e) {
				_log.error("deleting SpUser-"+deleteUserId);
			}
		}
	}

	protected void updateSpUser(ActionRequest actionRequest, ActionResponse actionResponse, long userId) {

		SpUser spUser = null;
		try {
			spUser = SpUserLocalServiceUtil.getSpUser(userId);
		} catch (PortalException | SystemException e) {
			_log.error("getSpUser while update user-"+userId);
		}
		
		long countryId = ParamUtil.getLong(actionRequest, "countryId");
		long regionId = ParamUtil.getLong(actionRequest, "regionId");
		long affiliationId = ParamUtil.getLong(actionRequest, "affiliationId");
		long[] domainIds = ParamUtil.getLongValues(actionRequest, "domainIds");
		Map<Locale,String> firstNameMap = LocalizationUtil.getLocalizationMap(actionRequest, "firstName");
		
		spUser.setSpUserFullNameMap(firstNameMap);
		spUser.setSpCountryId(countryId);
		spUser.setSpRegionId(regionId);
		spUser.setSpAffiliationId(affiliationId);
		
		try {
			SpUserLocalServiceUtil.updateSpUser(spUser, domainIds);
		} catch (SystemException e) {
			_log.error("updateSpUser()-while update SpUser");
		}
	}
}
