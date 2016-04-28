<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
</head>
<body>
<html:form action="cstLostAction.do">
<input type="hidden" name="method" value="dorelay"/>
<html:hidden property="lstCustManagerId"/>
<html:hidden property="lstLostDate"/>
<html:hidden property="lstReason"/>
<html:hidden property="lstStatus"/>
<html:hidden property="lstUpdateDatetime"/>
<div class="page_title">客户流失管理 &gt; 确认流失</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	
	<button class="common_button" onclick="back();">返回</button>
	<input type="submit" value="保存" class="common_button">
</div>
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td><html:text property="lstId"></html:text></td>
		<th>客户</th>
		<td><html:text property="lstCustName"></html:text></td>
	</tr>
	<tr>
		<th>客户经理</th>
		<td>
			<html:text property="lstCustManagerName"></html:text></td>
		<th>上次下单时间</th>
		<td>
			<html:text property="lstLastOrderDate"></html:text></td>
	</tr>	
	<tr>
		<th>暂缓措施</th>
		<td colspan="3">
			<html:text property="lstDelay"></html:text></td>
	</tr>
	<tr>
		<th>流失原因</th>
		<td colspan="3">
			<html:textarea property="lstReason"></html:textarea>
			<span class="red_star">*</span>
		</td>
	</tr>
</table>
</html:form>
<br />
</body>
</html>