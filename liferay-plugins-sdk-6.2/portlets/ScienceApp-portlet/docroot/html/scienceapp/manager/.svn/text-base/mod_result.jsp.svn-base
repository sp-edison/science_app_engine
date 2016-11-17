<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="javax.portlet.*" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.util.StringTokenizer" %>
<%@ page import="com.kisti.science.platform.app.model.CommonModule" %>
<%@page import="com.kisti.science.platform.app.service.constants.ScienceAppConstants"%>
<portlet:defineObjects />

<portlet:renderURL var="viewURL">
    <portlet:param name="jspPage" value="/html/scienceapp/manager/test.jsp" />
</portlet:renderURL>

<%
	List<CommonModule> cmList = (List<CommonModule>)renderRequest.getAttribute("foundModList");
	//if(clListStr != null){
	if(cmList == null){
%>
	<p>
		<%= ScienceAppConstants.AUTH_FAILURE %>! Please make sure your authentication is correct.
	</p>
<%		
	}
	else if(cmList != null){
		if(cmList.size() == 0){
%>
			<p><%= ScienceAppConstants.NO_MODULE_UPLOAD %>. Please load a module.</p>
<%
		}
		else{
%>
		<table>
			<tr>
				<th>Module Name</th>
				<th>Module Path</th>
				<!-- <th>Loaded</th>-->
			</tr>
		<%
			for(int i=0;i<cmList.size();i++){
				String modName = (cmList.get(i)).getModuleName();
				String modPath = (cmList.get(i)).getModuleRootDir();
				/* boolean isAvail = (cmList.get(i)).getIsLoaded();
				String status ="";
				if(!isAvail){
					status = "Unloaded/Available";
				}else{
					status = "Loaded";
				} */
		%>
				<tr>
					<td><%= modName %></td>
					<td><%= modPath %></td>
					<!--<td>status></td>-->
				</tr>
			<%
			}
			%>
		</table>
	<%
		}
	}
	%>
<p><a href="<%= viewURL %>">Back</a></p>