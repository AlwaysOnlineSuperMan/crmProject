<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
</head>
<body>

<div class="page_title">客户信息管理 > 客户信息 > 历史订单 </div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>  
	<button class="common_button" onclick="back();">返回</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>客户编号</th>
		<td>${custNo }</td>
		<th>客户名称</th>
		<td>${custName }</td>
	</tr>
	</table>
<br />
<table class="data_list_table">
	<tr>
		<th>订单编号</th>
		<th>日期</th>
		<th>送货地址</th>
		<th>状态</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${list}" var="orders">
	<tr>
		<td class="list_data_text">${orders.odrId }</td>
		<td class="list_data_text">${orders.odrDate }</td>
		<td class="list_data_text">${orders.odrAddr }</td>
		<td class="list_data_text">${orders.odrStatus}</td>
		<td class="list_data_op">
			<img onclick="to('ordersLineAction.do?method=getByOrderId&odrId=${orders.odrId}');" title="查看明细" src="images/bt_detail.gif" class="op_button" />
			&nbsp;
		</td>
	</tr>
	</c:forEach>
		<tr>
		<th colspan="100" class="pager">
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
