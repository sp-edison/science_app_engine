<%@page import="com.liferay.portal.kernel.util.LocalizationUtil"%>
<%@page import="com.liferay.portal.service.persistence.PortletUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@page import="com.kisti.science.platform.app.model.ScienceApp"%>
<%@ include file="/html/common/init.jsp" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="javax.portlet.*" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.kisti.science.platform.app.model.CommonLibrary" %>
<%@ page import="com.kisti.science.platform.app.model.CommonPackage" %>
<portlet:defineObjects />

<portlet:renderURL var="viewURL">
	<portlet:param name="reqLibName" value="" />
</portlet:renderURL>

<portlet:actionURL var="retrieveAllLibActionURL" name="retrieveAllLibAction">
</portlet:actionURL> 

<portlet:actionURL var="retrieveLibActionURL" name="retrieveLibAction">
</portlet:actionURL> 

<portlet:actionURL var="installLibActionURL" name="installLibAction">
</portlet:actionURL> 

<portlet:actionURL var="retrieveAllModActionURL" name="retrieveAllModAction">
</portlet:actionURL> 

<portlet:actionURL var="retrieveModActionURL" name="retrieveModAction">
</portlet:actionURL> 

<portlet:actionURL var="loadModActionURL" name="loadModAction">
</portlet:actionURL> 

<portlet:actionURL var="unloadModActionURL" name="unloadModAction">
</portlet:actionURL> 

<portlet:actionURL var="unloadAllModActionURL" name="unloadAllModAction">
</portlet:actionURL> 

<portlet:actionURL var="registerInstPkgInfoActionURL" name="registerPkgAction">
</portlet:actionURL> 

<portlet:actionURL var="testSciAppActionURL" name="testSciAppAction">
<portlet:param name="testSciAppName" value="" />
<portlet:param name="testSciAppFileName" value="" />
</portlet:actionURL> 

<portlet:actionURL var="unzipSciAppFileActionURL" name="unzipSciAppFileAction">
<portlet:param name="zipRootDirName" value="" />
<portlet:param name="zipFileName" value="" />
</portlet:actionURL> 

This is the <b>Science App Engine</b> portlet in View mode.

This is the new portlet for testing your science app.

<!-- <form action='<%= registerInstPkgInfoActionURL %>' method="post">
	<font>* Register the Information of an Installed Package.</font>
	<input type="submit" value="Register">
</form>-->

<form action='<%= retrieveAllLibActionURL %>' method="post">
	<font>* All Installed Libraries</font>
	<input type="submit" value="Search">
</form>

<form action='<%= retrieveLibActionURL %>' method="post">
	<font>*  Installed Library Search:</font>
	<input type="text" name="<portlet:namespace />reqLibName" value="" size=30 maxlength=30>
	<input type="submit" value="Search"><input type="reset"  value="Reset">
</form>

<form action='<%= installLibActionURL %>' enctype="multipart/form-data" method="post">
	<font>*  Upload an RPM-based library to be installed:</font>
	<input type="file" name="<portlet:namespace />testLibFileName" size="40">
	<input type="submit" value="Install a Library">
</form>

<form action='<%= retrieveAllModActionURL %>' method="post">
	<font>* Retrieve All Modules</font>
	<input type="submit" value="Search">
</form>

<form action='<%= retrieveModActionURL %>' method="post">
	<font>*  Locate a Module:</font>
	<input type="text" name="<portlet:namespace />reqModName" value="" size=30 maxlength=30>
	<input type="submit" value="Search"><input type="reset"  value="Reset">
</form>

<!-- 
<form action='unloadModActionURL %>' method="post">
	<font>-  Unload a Module:</font>
	<input type="text" name="<portlet:namespace />reqModName" value="" size=30 maxlength=30>
	<input type="submit" value="Load"><input type="reset"  value="Reset">
</form>

<form action='unloadAllModActionURL %>' method="post">
	<font>- Unload All Modules:</font>
	<input type="submit" value="Unload All">
</form>
-->

<!-- <form action='<%= loadModActionURL %>' method="post">
	<font>8) Load a Module:</font>
	<input type="text" name="<portlet:namespace />reqModName" value="" size=30 maxlength=30>
	<input type="submit" value="Load"><input type="reset"  value="Reset">
</form>-->

<form action='<%= testSciAppActionURL %>' enctype="multipart/form-data" method="post">
	<font>* Upload a Sci App to be tested.</font>
	<p>
		<!-- Science App Test Dest Dir: <input type="text" name="<portlet:namespace />testSciAppDir" size="200"><br>-->
		Science App Name: <input type="text" name="<portlet:namespace />testSciAppName" size="40"><br>
		Science App Version: <input type="text" name="<portlet:namespace />testSciAppVersion" size="10"><br>
		Science App File: <input type="file" name="<portlet:namespace />testSciAppFileName" size="40"><br>
		<input type="submit" value="App Test">
	</p>
</form>

<form action='<%= unzipSciAppFileActionURL %>' enctype="multipart/form-data" method="post">
	<font>* Unzip a tar ball:</font>
	<p>
		<!-- Science App Test Dest Dir: <input type="text" name="<portlet:namespace />testSciAppDir" size="200"><br>-->
		Science App Name: <input type="text" name="<portlet:namespace />sciAppName" size="40"><br>
		Science App Version: <input type="text" name="<portlet:namespace />sciAppVersion" size="10"><br>
		<!-- Science App Zip File Name: <input type="text" name="<portlet:namespace />zipFileName" size="20"><br>-->
		Upload a Science App Zip File: <input type="file" name="<portlet:namespace />zipFile" size="40"><br>
		Zip root directory name: <input type="text" name="<portlet:namespace />zipRootDirName" size="40"><br>
		<input type="submit" value="Zip File Upload">
	</p>

</form>
