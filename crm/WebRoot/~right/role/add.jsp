<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>jb-aptech毕业设计项目</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link href="css/style.css" rel="stylesheet" type="text/css">
		<script src="<%=path%>/script/common.js"></script>
		<script src="<%=path%>/script/validate.js"></script>
	</head>
	<body>
		<div class="page_title">
			权限管理 > 用户管理 > 系统角色管理 > 添加角色
		</div>
		<html:form action="sysRoleAction.do" method="post">
			<html:hidden property="method" value="doAddSysRole" />
			<div class="button_bar">
				<button class="common_button" onclick="help('');">
					帮助
				</button>
				<button class="common_button" onclick="back();">
					返回
				</button>
				<button class="common_button" onclick="submit();">
					保存
				</button>
			</div>
			<table class="query_form_table">
				<tr>
					<th>
						编号
					</th>
					<td>
						<input type="text" disabled="true" size="20">
					</td>
					<th>
						角色名
					</th>
					<td>
						<html:text property="roleName" size="20"></html:text>
					</td>
				</tr>
				<tr>
					<th>
						角色描述
					</th>
					<td>
						<html:text property="roleDesc" size="20"></html:text>
					</td>
					<th>
						状态
					</th>
					<td>
						正常
						<html:hidden property="roleFlag" value="1"/>
					</td>
				</tr>
			</table>
			<script>
				build_validate("roleName","角色名不能为空","Limit","1","50");
				build_validate("roleDesc","角色描述不能为空","Limit","1","50");
			</script>
		</html:form>
	</body>
</html>
