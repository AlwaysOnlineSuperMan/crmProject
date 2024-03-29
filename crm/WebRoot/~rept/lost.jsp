<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
</head>
<body>

<div class="page_title">客户流失分析</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="reload();">查询</button> 
	</div>
	<table class="query_form_table" border="0" cellPadding="3" cellSpacing="0">
			<tr>
					<th>客户名称</th>
	<td><input type="text" name="item.lstCustName" value=""></td>
					<th>客户经理</th>

	<td><input type="text" name="item.lstCustManagerName" value=""></td>
					
			</tr>
		</table><br />
<table class="data_list_table">


	<tr>
		<th height="28">编号</th>
		<th height="28">年份</th>
		<th height="28">客户</th>
		<th height="28">客户经理</th>
		<th height="28">流失原因</th>
	</tr>
	<c:forEach items="${cstLostObjectList}" var="cstLost" varStatus="v">
	<tr>
		<td class="list_data_number">${cstLost.lstId}</td>
		<td class="list_data_text">${cstLost.lstLostDate}</td>
		<td class="list_data_text">${cstLost.lstCustName}</td>
		<td class="list_data_text">${cstLost.lstCustManagerName}</td>
		<td class="list_data_ltext">${cstLost.lstReason}</td>
		</tr>
</c:forEach>
	
	<tr>
		<th colspan="7" class="pager">
<div class="pager">
	共59条记录 每页<input value="10" size="2" />条
	第<input value="1" size="2"/>页/共5页
	<a href="#">第一页</a>
	<a href="#">上一页</a>
	<a href="#">下一页</a>
	<a href="#">最后一页</a>
	转到<input value="1" size="2" />页
	<button width="20" onclick="reload();">GO</button>
</div>
		</th>
	</tr>

	</table>
</body>
</html>
