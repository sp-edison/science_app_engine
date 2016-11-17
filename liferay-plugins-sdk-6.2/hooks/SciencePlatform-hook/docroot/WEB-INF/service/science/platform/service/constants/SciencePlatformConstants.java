package science.platform.service.constants;

import com.liferay.portal.kernel.workflow.WorkflowConstants;

public class SciencePlatformConstants {
	
	public final static String SCIENCE_PLATFORM_STATUS_ACTIVE="ACTIVE";
	public final static String SCIENCE_PLATFORM_STATUS_INACTIVE="INACTIVE";

	public final static String SCIENCEPLATFORM_IPC_NAMESPACE="http://edison.re.kr/events";
	public final static String SCIENCEPLATFORM_IPC_EVENT_SCIENCEAPP_ADDED="ipc.scienceapp_added";
	
	public final static String SCIENCE_APP_BASE_DIR="SCIENCE_APP_BASE_DIR";
	public final static String SCIENCE_PLATFORM_USER_BASE_DIR="SCIENCE_PLATFORM_USER_BASE_DIR";
	public final static String SCIENCE_PLATFORM_IB_URL="SCIENCE_PLATFORM_IB_URL";
	public final static String SCIENCE_PLATFORM_WORKFLOW_URL="SCIENCE_PLATFORM_WORKFLOW_URL";
	public final static String SCIENCE_PLATFORM_APP_TEST_URL="SCIENCE_PLATFORM_APP_TEST_URL";
	public final static String WORKFLOW_TEMPLATE_DIR="WORKFLOW_TEMPLATE_DIR";
	
	public final static String SCIENCE_PLATFORM_USER_GROUP_DEVELOPER="Developer Group";
	public final static String SCIENCE_PLATFORM_USER_GROUP_TUTOR="Tutor Group";
	public final static String SCIENCE_PLATFORM_USER_GROUP_STUDENT="Student Group";
	public final static String SCIENCE_PLATFORM_USER_GROUP_EDISON_PROJECT="EDISON Project Group";
	public final static String SCIENCE_PLATFORM_USER_GROUP_EDISON_PROJECT_LEADER="EDISON Project Leaders Group";
	public final static String SCIENCE_PLATFORM_USER_GROUP_EDISON_PROJECT_MANAGER="EDISON Project Managers Group";
	
	public final static String SCIENCE_PLATFORM_ROLE_SCIENCEAPP_OWNER="ScienceApp Owner";
	public final static String SCIENCE_PLATFORM_ROLE_SCIENCEAPP_MANAGER="ScienceApp MANAGER";
	public final static String SCIENCE_PLATFORM_ROLE_VIRTUALLAB_OWNER="Virtual Lab Owner";
	public final static String SCIENCE_PLATFORM_ROLE_VIRTUALLAB_MANAGER="Virtual Lab Manager";
	public final static String SCIENCE_PLATFORM_ROLE_VIRTUALCLASS_OWNER="Virtual Class Owner";
	public final static String SCIENCE_PLATFORM_ROLE_VIRTUALCLASS_MANAGER="Virtual Class Manager";
	public final static String SCIENCE_PLATFORM_ROLE_STUDENT="Student";
	public final static String SCIENCE_PLATFORM_ROLE_EDISON_PROJECT_RESEARCHER="EDISON Project Researcher";
	public final static String SCIENCE_PLATFORM_ROLE_EDISON_PROJECT_LEADER="EDISON Project Leader";
	public final static String SCIENCE_PLATFORM_ROLE_EDISON_PROJECT_MANAGER="EDISON Project MANAGER";
	
	public final static String[] getSciencePlatformStatus(){
		String[] status = {
				SCIENCE_PLATFORM_STATUS_ACTIVE,
				SCIENCE_PLATFORM_STATUS_INACTIVE
		};
		
		return status;
	}
}
