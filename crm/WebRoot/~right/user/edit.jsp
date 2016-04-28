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
<script src="<%=path%>/script/validate.js"></script>
</head>
  
  <body>
    <div class="page_title">权限管理 > 用户管理 > 系统用户</div>
    <html:form action="sysUserAction.do?method=doUserEdit" >
    	<div class="button_bar">
	   		<button class="common_button" onclick="help('');">帮助</button>
	   		<button class="common_button" onclick="back();">返回</button>
			<button class="common_button" onclick="submit();">保存</button>

	   	</div>
	   	<table class="query_form_table">
	   		<tr>
	   			<th>账号：</th>
	   			<td>
	   				<html:text property="usrNo"  size="20"></html:text>
					<html:hidden property="usrId" />  
	   			</td>
	   			<th>用户名</th>
	   			<td>
	   				<html:text property="usrName" size="20" ></html:text>
	   			</td>
	   		</tr>
	   		<tr>
	   			<th>密码</th>
	   			<td>
	   				<html:password property="usrPassword" ></html:password>
	   			</td>
	   			<th>角色</th>
	   			<td>
	   				<c:if test="${sysUser.sysRole==null}">
	   					未指派
	   				</c:if>
	   				<c:if test="${sysUser.sysRole!=null}">
	   					${sysUser.sysRole.roleName}
	   				</c:if>
	   				<html:hidden property="usrRoleId" ></html:hidden>
	   			</td>
	   		</tr>
	   		<tr>
	   			<th>状态</th>
	   			<td>
	   				<c:if test="${sysUser.usrFlag==1}">
	   					正常
	   				</c:if>
	   				<c:if test="${sysUser.usrFlag==2}">
	   					禁用
	   				</c:if>
	   				<html:hidden property="flag" value="${sysUser.usrFlag}"/>
	   			</td>
	   		</tr>
	   	</table>
	   	<script>
				build_validate("sysUser.usrName","用户名不能为空","Limit","1","50");
				build_validate("sysUser.usrPassword","密码不能为空","Limit","1","50");
		</script>
    </html:form>
  </body>
</html>
