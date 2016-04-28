<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
</head>
<body>
<html:form action="cstServiceAction.do?method=updateFeedBack&id=${byid.svrId }">
<div class="page_title">客户服务管理 &gt; 服务处理</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button> 
	<button class="common_button" onclick="submit();">保存</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td>${byid.svrId }</td>
		<th>服务类型</th>
		<td>
			${byid.svrType }</td>
	</tr>
	<tr>
		<th>概要</th>
		<td colspan="3">${byid.svrTitle }</td>
	</tr>	
	<tr>
		<th>客户</th>
		<td>${byid.svrCustName }</td>
		<th>状态</th>
		<td>${byid.svrStatus }</td>
	</tr>	
	<tr>
		<th>服务请求</th>
		<td colspan="3">${byid.svrRequest }<br>
　</td>
	</tr>
	<tr>
		<th>创建人</th>
		<td>${byid.svrCreateBy }</td>
		<th>创建时间</th>
		<td>${byid.svrCreateDate }</td>
	</tr>
	</table>
<br />
<table class="query_form_table" id="table3">
	<tr>
		<th>分配给</th>
		<td>
			${byid.svrDueTo }</td>
		<th>分配时间</th>
		<td>${byid.svrDueDate }</td>
	</tr>
</table>
<br />	
<table class="query_form_table" id="table1">
	<tr>
		<th>服务处理</th>
		<td colspan="3">${byid.svrDeal }</td>
	</tr>
	<tr>
		<th>处理人</th>
		<td>${byid.svrCreateBy }</td>
		<th>处理时间</th>
		<td>${byid.svrDealDate }</td>
	</tr>
</table>
<br />
<table class="query_form_table" id="table2">
	<tr>
		<th>处理结果</th>
		<td><input name="cstServiceService.svrResult" size="20" /><span class="red_star">*</span></td>
		<th>满意度</th>
		<td>
			<select name="cstServiceService.svrSatisfy">
				<option value="3">请选择...</option>
				<option value="5">☆☆☆☆☆</option>
				<option value="4">☆☆☆☆</option>
				<option value="3">☆☆☆</option>
				<option value="2">☆☆</option>
				<option value="1">☆</option>
			</select><span class="red_star">*</span></td>
	</tr>
</table>
</html:form>
</body>
</html>
