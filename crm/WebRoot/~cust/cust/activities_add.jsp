<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
</head>
<body>
<html:form action="cstActivityAction.do">
<input type="hidden" name="method" value="addActivity"/>
<input type="hidden" name="custNo" value="${custNo}"/>
<div class="page_title">客户信息管理 > 客户信息 > 交往记录 > 新建交往记录</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
	<input type="submit" value="保存" class="common_button">
</div>
<table class="query_form_table">
	<tr>
		<th>时间</th>
		<td><html:text property="atvDate" readonly="true"></html:text><span class="red_star">*</span></td>
		<th>地点</th>
		<td>
			<html:text property="atvPlace"></html:text><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>概要</th>
		<td><html:text property="atvTitle"></html:text><span class="red_star">*</span></td>
		<th>备注</th>
		<td><html:text property="atvTitle"></html:text></td>
	</tr>	
	<tr>
		<th>详细信息</th>
		<td colspan="3">
			<html:textarea property="atvDesc"></html:textarea>
		</td>
	</tr>
</table>
</html:form>
</body>
</html>
