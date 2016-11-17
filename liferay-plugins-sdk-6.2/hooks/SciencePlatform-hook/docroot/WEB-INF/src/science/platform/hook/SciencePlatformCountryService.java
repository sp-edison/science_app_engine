package science.platform.hook;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import science.platform.model.SpAffiliation;
import science.platform.service.SpAffiliationLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Country;
import com.liferay.portal.service.CountryService;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.CountryServiceWrapper;

public class SciencePlatformCountryService extends CountryServiceWrapper {
	/* (non-Java-doc)
	 * @see com.liferay.portal.service.CountryServiceWrapper#CountryServiceWrapper(CountryService countryService)
	 */
	public SciencePlatformCountryService(CountryService countryService) {
		super(countryService);
	}

	public static List<String[]> getSciencePlatformRegionCodes(String countryCode){
		List<String[]> regionList = new ArrayList<String[]>();
		
		return regionList;
	}
	
	public static List<String[]> getSciencePlatformAffiliationStringList(String countryCode, Locale locale) throws SystemException{
		List<SpAffiliation> affiliationList = null;
		List<String[]> affiliationStringList = new ArrayList<String[]>();
		Country country = CountryServiceUtil.fetchCountryByA2(countryCode);
		
		affiliationList = SpAffiliationLocalServiceUtil.getSpAffiliationListByRegionId(country.getPrimaryKey());
		
		for(SpAffiliation affiliation : affiliationList){
			String[] affiliationStr = new String[2];
			affiliationStr[0] = Long.toString(affiliation.getPrimaryKey());
			affiliationStr[1] = affiliation.getSpAffiliationName(locale);
			
			affiliationStringList.add(affiliationStr);
		}
		
		return affiliationStringList;
	}
	
	public static List<String[]> getSciencePlatformAffiliationStringList(Locale locale) throws SystemException{
		List<SpAffiliation> affiliationList = null;
		List<String[]> affiliationStringList = new ArrayList<String[]>();
		
		affiliationList = SpAffiliationLocalServiceUtil.getAll();
		
		for(SpAffiliation affiliation : affiliationList){
			String[] affiliationStr = new String[2];
			affiliationStr[0] = Long.toString(affiliation.getPrimaryKey());
			affiliationStr[1] = affiliation.getSpAffiliationName(locale);
			
			affiliationStringList.add(affiliationStr);
		}
		
		return affiliationStringList;
	}
}