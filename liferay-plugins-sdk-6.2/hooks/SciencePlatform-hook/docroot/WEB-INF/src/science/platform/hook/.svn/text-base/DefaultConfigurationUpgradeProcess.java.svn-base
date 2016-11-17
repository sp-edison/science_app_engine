/**
 * Copyright (c) 2015-present KISTI. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package science.platform.hook;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import science.platform.model.SpAffiliation;
import science.platform.model.SpDomain;
import science.platform.model.SpRegion;
import science.platform.model.SystemProperties;
import science.platform.service.SpAffiliationLocalServiceUtil;
import science.platform.service.SpDomainLocalServiceUtil;
import science.platform.service.SpRegionLocalServiceUtil;
import science.platform.service.SystemPropertiesLocalServiceUtil;
import science.platform.service.constants.SciencePlatformConstants;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.Region;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.RegionServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserGroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * @author Jerry H. Seo
 */
public class DefaultConfigurationUpgradeProcess extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		
		System.out.println("SciencePlatform Upgrade processes are started now!");
		
		long companyId = PortalUtil.getDefaultCompanyId();

		long defaultUserId = UserLocalServiceUtil.getDefaultUserId(
			companyId);
		
		this.setSciencePlatformRoles(companyId, defaultUserId);
		
		this.doInsertKoreaRegion();
		this.doInsertAffiliations();
		this.doInsertSpDomains();
		this.configureSystemProperties();
	}

	protected void setSciencePlatformUserGroups(long companyId, long defaultUserId) throws SystemException{
		String[][] userGroupString = {
				{"Developer Group", "User group which contains users who have ScienceApp Owner or ScienceApp Manager role", ""},
				{"Tutor Group", "User group which contains users who have VirtualLab Owner, VirtualLab Manager, VirtualClass Owner, VirtualClass Manager role", ""},
				{"Student Group", "User group which contains users who are participating at least 1 virtual class", "" },
				{"EDISON Project Group", "User group consists of who are participants in EDISON Project", ""},
				{"EDISON Project Leaders Group", "User group consists of who are leaders of EDISON Project", "EDISON Project Managers Group"},
				{"EDISON Project Managers Group", "User group consists of who are managers of EDISON Project", "EDISON Project Group"}
		};
		
		for(int i=0; i<userGroupString.length; i++){
			UserGroup userGroup = null;
			long userGroupId = CounterLocalServiceUtil.increment(UserGroup.class.getName());
			userGroup = UserGroupLocalServiceUtil.createUserGroup(userGroupId);
			
			userGroup.setCompanyId(companyId);
			userGroup.setUserId(defaultUserId);
			userGroup.setName(userGroupString[i][0]);
			userGroup.setDescription(userGroupString[i][1]);
			
			Date date = new Date();
			userGroup.setCreateDate(date);
			userGroup.setModifiedDate(date);
			
			if(!userGroupString[i][2].isEmpty()){
				UserGroup parentUserGroup = UserGroupLocalServiceUtil.fetchUserGroup(companyId, userGroupString[i][2]);
				userGroup.setParentUserGroupId(parentUserGroup.getUserGroupId());
			}
			
			UserGroupLocalServiceUtil.addUserGroup(userGroup);
		}
	}
	
	protected void setSciencePlatformRoles(long companyId, long defaultUserId) throws Exception{
		String[][] roleString = {
				{
					"ScienceApp Owner",
					"사이언스앱 소유자",
					"Who has registered at least 1 ScienceApp reserves this role.",
					"1개 이상의 사이언스앱을 등록한 사용자가 보유하는 권한."
				},
				{
					"ScienceApp Manager",
					"사이언스앱 관리자",
					"Who manages at least 1 ScienceApp reserves this role.",
					"1개 이상의 사이언스앱을 관리하는 사용자가 보유하는 권한."
				},
				{
					"VirtualLab Owner",
					"가상실험실 소유자",
					"Who has registered at least 1 VirtualLab reserves this role.",
					"1개 이상의 가상실험실을 등록한 사용자가 보유하는 권한."
				},
				{
					"VirtualLab Manager",
					"가상실험실 관리자",
					"Who manages at least 1 VirtualLab reserves this role.",
					"1개 이상의 가상실험실을 관리하는 사용자가 보유하는 권한."
				},
				{
					"VirtualClass Owner",
					"가상클래스 소유자",
					"Who has registered at least 1 VirtualClass reserves this role.",
					"1개 이상의 가상클래스를 등록한 사용자가 보유하는 권한."
				},
				{
					"VirtualClass Manager",
					"가상클래스 관리자",
					"Who manages at least 1 VirtualClass reserves this role.",
					"1개 이상의 가상클레스를 관리하는 사용자가 보유하는 권한."
				},
				{
					"Student",
					"수강생",
					"Who participates at least 1 VirtualClass reserves this role. Applied only for limited users",
					"1개 이상의 가상클레스를 관리하는 사용자가 보유하는 권한. 임시 회원에만 적용"
				},
				{
					"EDISON Project Researcher",
					"에디슨 프로젝트 연구자",
					"Who participates in EDISON Project as a researcher reserves this role.",
					"에디슨 프로젝트에 연구원이 보유하는 권한."
				},
				{
					"EDISON Project Leader",
					"에디슨 프로젝트 책임자",
					"Who participates in EDISON Project as a project leader reserves this role.",
					"에디슨 프로젝트의 연구책임자가 보유하는 권한."
				},
				{
					"EDISON Project Manager",
					"에디슨 프로젝트 관리자",
					"Who participates in EDISON Project as a project manager reserves this role.",
					"에디슨 프로젝트의 관리자가 보유하는 권한."
				}
		};
		
		for(int i=0; i<roleString.length; i++){
			Map<Locale, String> descriptionMap = new HashMap<Locale, String>();
			Map<Locale, String> titleMap = new HashMap<Locale, String>();
	
			titleMap.put(Locale.US, roleString[i][0]);
			titleMap.put(Locale.KOREA, roleString[i][1]);
			descriptionMap.put(Locale.US, roleString[i][2]);
			descriptionMap.put(Locale.KOREA, roleString[i][3]);

			this.addRole(defaultUserId, companyId, roleString[i][0], titleMap, descriptionMap, RoleConstants.TYPE_REGULAR);
		}
		
/*
		setRolePermissions(	role, "science-app-manager",
			new String[] {"UPDATE", "DELETE", "DEACTIVATE", "ACTIVATE"});
*/
	}
	
	protected Role addRole(long userId, long companyId, String roleName, Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, int roleType) throws SystemException{
		Role role = RoleLocalServiceUtil.fetchRole(companyId, roleName);
		if(role != null){
			System.out.println("Role duplicated: " + roleName);
			return role;
		}
		
		long roleId = CounterLocalServiceUtil.increment(Role.class.getName());
		role = RoleLocalServiceUtil.createRole(roleId);

		role.setClassNameId(ClassNameLocalServiceUtil.getClassNameId(Role.class));
		role.setClassPK(roleId);
		role.setUserId(userId);
		role.setCompanyId(companyId);
		role.setName(roleName);
		role.setTitleMap(titleMap);
		role.setDescriptionMap(descriptionMap);
		role.setType(roleType);
		
		Date date = new Date();
		role.setCreateDate(date);
		role.setModifiedDate(date);
		
		return RoleLocalServiceUtil.addRole(role);
	}
	
	protected void doInsertKoreaRegion(){
		String[][] regions = { {"KR","강원도","Gangwon-Do","GWD"},
								   {"KR","경기도","Gyeonggi-Do","GGD"},
								   {"KR","경상남도","Gyeongsangnam-Do","GSND"},
								   {"KR","경상북도","Gyeongsangbuk-Do","GSBD"},
								   {"KR","광주광역시","Gwangju","GJC"},
								   {"KR","대구광역시","Daegu","DGC"},
								   {"KR","대전광역시","Daejeon","DJC"},
								   {"KR","부산광역시","Busan","BSC"},
								   {"KR","서울특별시","Seoul","SUC"},
								   {"KR","세종특별자치시","Sejong","SJC"},
								   {"KR","울산광역시","Ulsan","USC"},
								   {"KR","인천광역시","Incheon","ICC"},
								   {"KR","전라남도","Jeollanam-Do","JLND"},
								   {"KR","전라북도","Jeollabuk-Do","JLBD"},
								   {"KR","제주특별자치도","Jeju-Do","JJD"},
								   {"KR","충청남도","Chungcheongnam-Do","CCND"},
								   {"KR","충청북도","Chungcheongbuk-Do","CCBD"}};
		
		System.out.println("Start Insert Korean Regions");
		for(int i = 0; i < regions.length; i++){
			String[] regionInfo = regions[i];
			Country country = null;
			try {
				country = CountryServiceUtil.getCountryByA2(regionInfo[0]);
			} catch (PortalException | SystemException e1) {
				System.out.println("Couldn't get Country Object: "+regionInfo[0]);
			}
			
			try {
				if(SpRegionLocalServiceUtil.isExist(country.getCountryId(), regionInfo[3])){
					System.out.println(regionInfo.toString() + " already exist: SKIPPED");
					continue;
				}
			} catch (SystemException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			SpRegion region = null;
			try {
				region = SpRegionLocalServiceUtil.createSpRegion(country.getCountryId(), regionInfo[3]);
			} catch (SystemException e) {
				System.out.println("ERROR: New Region Creation FAILED");
				return;
			}
			
			if(region == null)	return;
			
			region.setSpRegionName(regionInfo[1], Locale.KOREA);
			region.setSpRegionName(regionInfo[2], Locale.US);
			region.setSpActive(true);
			
			try {
				SpRegionLocalServiceUtil.addSpRegion(region);
			} catch (SystemException e) {
				System.out.println("ERROR: While insert korean region");
				System.out.println(region.toString());
			}
		}
		System.out.println("Finish Insert Korean Regions");
	}
	
	protected void doInsertAffiliations(){
		String[][] affiliations = {
				{"KR","한국과학기술원","KAIST","KAIST","DJC"},
				{"KR","성균관대학교(인문사회과학캠퍼스)","Sungkyunkwan University(Humanities and Social Sciences Campus)","SKKU","SUC"},
				{"KR","성균관대학교(자연과학캠퍼스)","Sungkyunkwan University(Natural Sciences Campus)","SKKU-S","GGD"},
				{"KR","숙명여자대학교","Sookmyung Women's University","SMWU","SUC"},
				{"KR","세종대학교","Sejong University","SJU","SUC"},
				{"KR","충남대학교","Chungnam National University","CNNU","DJC"},
				{"KR","서울대학교","Seoul National University","SUNU","SUC"},
				{"KR","고려대학교","Korea University","KRU","SUC"},
				{"KR","고려대학교(세종캠퍼스)","Korea University(Sejong Campus)","KRU-S","SJC"},
				{"KR","광운대학교","Kwangwoon University","KWU","SUC"},
				{"KR","경북대학교","Kyungpook National University","KBNU","DGC"},
				{"KR","부산대학교","Pusan National University","PSNU","BSC"},
				{"KR","서강대학교","Sogang University","SGU","SUC"},
				{"KR","연세대학교","Yonsei University","YSU","SUC"},
				{"KR","연세대학교(원주)","Yonsei University(Wonju)","YSU-W","GWD"},
				{"KR","포항공과대학교","POSTECH","POSTECH","GSBD"},
				{"KR","전남대학교","Chonnam National University","CNNU","JLND"},
				{"KR","광주과학기술원","Gwangju Institute of Science and Technology","GIST","GJC"},
				{"KR","울산과학기술대학교","ULSAN National Institute of Science and Technology","UNIST","USC"},
				{"KR","아주대학교","AJOU University","AJU","GSBD"},
				{"KR","한국과학기술정보연구원","KISTI","KISTI","DJC"},
				{"KR","강원대학교","Kangwon National University","KWNU","GWD"},
				{"KR","한국방송통신대학교","Korea National Open University","KNOU","SUC"},
				{"KR","한국외국어대학교","Hankuk University of Foreign Studies","HUFS","SUC"},
				{"KR","한국외국어대학교(글로벌캠퍼스)","Hankuk University of Foreign Studies(Global Campus)","HUFS-G","GGD"},
				{"KR","서울과학기술대학교","Seoul National University of Science and Technology","SNUST","SUC"},
				{"KR","건국대학교","Konkuk University","KKU","SUC"},
				{"KR","건국대학교(글로벌캠퍼스)","Konkuk University(Global Campus)","KKU-G","CCBD"},
				{"KR","경상대학교","Gyeongsang National University","GSNU","GSND"},
				{"KR","경희대학교","Kyung Hee University","KHU","SUC"},
				{"KR","경희대학교(국제캠퍼스)","Kyung Hee University(Global Campus)","KHU-G","GGD"},
				{"KR","경희대학교(광릉캠퍼스)","Kyung Hee University(Gwangneung Campus)","KHU-W","GGD"},
				{"KR","서울시립대학교","University Of Seoul","UOSU","SUC"},
				{"KR","숭실대학교","Soongsil University","SSU","SUC"},
				{"KR","안동대학교","Andong National University","ADNU","GSBD"},
				{"KR","울산대학교","University Of Ulsan","UUS","USC"},
				{"KR","전북대학교","Chonbuk National University","JBNU","JLBD"},
				{"KR","충북대학교","Chungbuk National University","CBNU","CCBD"},
				{"KR","조선대학교","Chosun University","CSU","GJC"},
				{"KR","한서대학교","Hanseo University","HSU","CCND"},
				{"KR","한양대학교","Hanyang University","HYU","SUC"},
				{"KR","한양대학교(ERICA 캠퍼스)","Hanyang University(ERICA Campus)","HYU-E","GGD"},
				{"KR","항공대학교","Korea Aerospace University","KAU","GGD"},
				{"KR","홍익대학교","Hongik University","HIU","SUC"},
				{"KR","홍익대학교(세종캠퍼스)","Hongik University(Sejong Campus)","HIU-S","SJC"},
				{"US","버지니아 폴리테크닉 주립 대학교","Virginia Polytechnic Institute and State University","VPISU","VA"}};

		for(int i=0; i<affiliations.length; i++){
			String[] affiliationInfo = affiliations[i];
			Country country = null;
			try {
				country = CountryServiceUtil.getCountryByA2(affiliationInfo[0]);
			} catch (PortalException e2) {
				System.out.println("[PortalException]Couldn't get Country Object: "+affiliationInfo[0]);
			} catch (SystemException e2) {
				System.out.println("[SystemException]Couldn't get Country Object: "+affiliationInfo[0]);
			} finally{
				if(country == null){
					System.out.println("Country is not found: "+affiliationInfo[0]);
					continue;
				}
				else
					System.out.println("Country ID: " + country.getCountryId());
			}
			
			SpRegion spRegion = null;
			long regionId = 0;
			try {
				spRegion = SpRegionLocalServiceUtil.fetchSpRegion(country.getCountryId(), affiliationInfo[4]);
				if(spRegion == null){
					System.out.println("spRegion is null");
					Region region = RegionServiceUtil.fetchRegion(country.getCountryId(), affiliationInfo[4]);
					if(region == null){
						System.out.println("region is also null");
						continue;
					}
					else regionId = region.getRegionId();
				}
				else
					regionId = spRegion.getSpRegionId();
			} catch (SystemException e2) {
				System.out.println("[SystemException]Couldn't get SpRegion Object: "+affiliationInfo[4]);
			} finally{
				System.out.println("Region ID: "+regionId);
			}
			
			try {
				if(SpAffiliationLocalServiceUtil.isExist(regionId, affiliationInfo[3])){
					System.out.println("SKIPPED-Affiliation already exist: "+affiliationInfo[0]+", "+affiliationInfo[4]+", "+affiliationInfo[3]);
					continue;
				};
			} catch (SystemException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			SpAffiliation affiliation = null;
			try {
				affiliation = SpAffiliationLocalServiceUtil.createSpAffiliation(country.getCountryId(), regionId, affiliationInfo[3]);
			} catch (SystemException e1) {
				System.out.println("Create a new SpAffiliation FAILED: "+affiliationInfo[0]+", "+affiliationInfo[4]+", "+affiliationInfo[3]);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				if(affiliation==null)	{
					System.out.println("Affiliation is null;");
					continue;
				}
			}
			
			affiliation.setSpAffiliationName(affiliationInfo[1], Locale.KOREA);
			affiliation.setSpAffiliationName(affiliationInfo[2], Locale.US);
			affiliation.setSpActive(true);
			
			try {
				SpAffiliationLocalServiceUtil.addSpAffiliation(affiliation);
			} catch (SystemException e) {
				System.out.println("ERROR: While insert affiliations");
				System.out.println(affiliation.toString());
			}
		}
	}
	
	protected void doInsertSpDomains(){
		String[][] domains = { {"CFD","전산열유체","Computational Fluid Dynamics"},
								   {"NANO","나노물리","Nano-Physics"},
								   {"CHEM","계산화학","Computational Chemistry"},
								   {"CSD","구조동력학","Computational Structure Dynamics"},
								   {"DESIGN","전산설계","Computer Aided Optimal Design"}};
		
		for(int i = 0; i < domains.length; i++){
			String[] domainInfo = domains[i];
			try {
				if(SpDomainLocalServiceUtil.isExist(domainInfo[0])){
					System.out.println(domainInfo[0] + " already exist: SKIPPED");
					continue;
				}
			} catch (SystemException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			SpDomain domain = null;
			try {
				domain = SpDomainLocalServiceUtil.createSpDomain(domainInfo[0]);
			} catch (SystemException e) {
				System.out.println("ERROR: New SpDomain Creation FAILED - "+domainInfo[0]);
				return;
			}
			
			if(domain == null)	return;
			
			domain.setSpDomainName(domainInfo[1], Locale.KOREA);
			domain.setSpDomainName(domainInfo[2], Locale.US);
			domain.setSpActive(true);
			
			try {
				SpDomainLocalServiceUtil.addSpDomain(domain);
			} catch (SystemException e) {
				System.out.println("ERROR: While insert SpDomains");
				System.out.println(domain.toString());
			}
		}
	}
	
	protected void configureSystemProperties() throws SystemException{
		String[][] propertiesData = { 
				{SciencePlatformConstants.SCIENCE_APP_BASE_DIR, "/sp/scienceapp"},
				{SciencePlatformConstants.SCIENCE_PLATFORM_USER_BASE_DIR,"/sp/user"},
				{SciencePlatformConstants.SCIENCE_PLATFORM_IB_URL, "/localhost"},
				{SciencePlatformConstants.SCIENCE_PLATFORM_WORKFLOW_URL, "/localhost"},
				{SciencePlatformConstants.SCIENCE_PLATFORM_APP_TEST_URL, "/localhost"},
				{SciencePlatformConstants.WORKFLOW_TEMPLATE_DIR, "/sp/workflow/template"}
		};
		
		for(int i=0; i<propertiesData.length; i++){
			System.out.println("Properties: "+propertiesData[i][0]);
			if(SystemPropertiesLocalServiceUtil.exist(propertiesData[i][0]))	{
				System.out.println("SKIPPED: " + propertiesData[i][0] + " exist.");
				continue;
			}
			SystemProperties property = SystemPropertiesLocalServiceUtil.createSystemProperties(propertiesData[i][0]);
			property.setPropertyValue(propertiesData[i][1]);
			property.setActive(true);
			
			try {
				SystemPropertiesLocalServiceUtil.addSystemProperties(property);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		//SystemPropertiesLocalServiceUtil.createSystemProperties(propertyName);
	}
	
	protected void setRolePermissions(Role role, String name, String[] actionIds) throws Exception {
		long roleId = role.getRoleId();
		long companyId = role.getCompanyId();
		int scope = ResourceConstants.SCOPE_COMPANY;
		String primKey = String.valueOf(companyId);

		ResourcePermissionLocalServiceUtil.setResourcePermissions(companyId,
				name, scope, primKey, roleId, actionIds);
	}
}
