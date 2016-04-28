<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>客户关系管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body style="border-bottom:solid 1px #666;">

<TABLE style="width:100%;">
<tr >
	<td ><img src="images/logo.jpg" /></td>
	<td style="font-family:黑体;font-size:33px;font-weight:bold;"> 客户关系管理系统</td>	
	<td width="25%" align="right" style="font-size:12px;" valign="bottom">当前用户：
	<c:if test="${loginViewObject!=null}">
		${loginViewObject.usrName}（${loginViewObject.roleName}）&nbsp;&nbsp; <a href="sysUserAction.do?method=bakeSystem" target="_top">退出系统 </a>
	</c:if>
	<c:if test="${loginViewObject==null}">
		 <a href="login.jsp" target="_top" >请您登陆 </a></td>
	</c:if>
	</td>
</tr>
</table>
</body>
</html>
