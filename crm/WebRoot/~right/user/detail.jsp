<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
 <base href="<%=basePath%>">
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="<%=path %>/script/common.js"></script>
<script src="<%=path %>/script/validate.js"></script>
</head>
  
  <body>
    <div class="page_title">权限管理 > 用户管理 > 查看用户</div>
    <html:form action="sysUserAction.do?method=doDetail" >
    	<html:hidden property="o" value="toDetail"/>
    	<div class="button_bar">
	   		<button class="common_button" onclick="help('请您联系QQ:1150550809');">帮助</button>
	   		<button class="common_button" onclick="back();">返回</button>
	   	</div>
	   	<table class="query_form_table">
	   		<tr>
	   			<th>编号</th>
	   			<td>${sysUserForm.usrId}</td>
	   			<th>用户名</th>
	   			<td>${sysUserForm.usrName }</td>
	   		</tr>
	   		<tr>
	   			<th>角色</th>
	   			<td>
	   				<c:if test="${sysUserForm.usrRoleId==null}">
	   					未指派
	   				</c:if>
	   				<c:if test="${sysUserForm.usrRoleId!=null}">
	   					${sysUserForm.usrRoleName}
	   				</c:if>
	   			</td>
	   			<th>
	   				状态
	   			</th>
	   			<td>
	   				<c:if test="${sysUserForm.usrFlag==1}">
	   					正常
	   				</c:if>
	   				<c:if test="${sysUserForm.usrFlag==2}">
	   					禁用
	   				</c:if>
	   			</td>
	   		</tr>
	   	</table>
    </html:form>
  </body>
</html>
