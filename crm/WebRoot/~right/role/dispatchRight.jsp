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
		<script src="<%=path %>/script/validate.js"></script>
	</head>
  
  <body>
    <div class="page_title">
		权限管理 > 角色管理 > 分配权限 
	</div>
	<html:form action="sysRoleAction.do" method="post">
		<html:hidden property="method" value="toDispatchRightList"/>
			<div class="button_bar">
				<button class="common_button" onclick="help('');">
					帮助
				</button>
				<button class="common_button" onclick="back();">
					返回
				</button>
				<button class="common_button" onclick="add();">
					查询
				</button>
			</div>
			<table class="query_form_table">
				<tr>
					<th>
						角色名
					</th>
					<td>
						<html:text property="roleName" size="20"></html:text>
					</td>
					<th>角色描述</th>
					<td>
						<html:text property="roleDesc" size="20"></html:text>
					</td>
					<th>
						是否禁用
					</th>
					<td>
						<html:select property="roleFlag">
							<html:option value="0">全部</html:option>
							<html:option value="1">正常</html:option>
							<html:option value="2">禁用</html:option>
						</html:select>
					</td>
				</tr>
			</table>
			<br />
			<table class="data_list_table">
				<tr>
					<th>
						编号
					</th>
					<th>
						角色名
					</th>
					<th>
						角色描述
					</th>
					<th>
						状态
					</th>
					<th>
						操作
					</th>
				</tr>
				<logic:iterate id="role" name="sysRoleObjectList">
					<tr>
						<td class="list_data_text">
							${role.roleId}
						</td>
						<td class="list_data_text">
							${role.roleName}
						</td>
						<td>
							${role.roleDesc }
						</td>
						<td class="list_data_text">
							<c:if test="${role.roleFlag==1}">
	   					正常
	   				</c:if>
							<c:if test="${role.roleFlag==2}">
	   					禁用
	   				</c:if>
						</td>
						<td class="list_data_op">
							<button onclick="to('role.do?o=toDispatchRight&roleId=${role.roleId }')">分配权限</button>
						</td>
					</tr>
				</logic:iterate>
				<tr>
					<th colspan="7" class="pager">
						<div class="pager">
							
						</div>
					</th>
				</tr>
			</table>
	</html:form>
  </body>
</html>
