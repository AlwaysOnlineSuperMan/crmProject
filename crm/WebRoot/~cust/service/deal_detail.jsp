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
<form action="cstServiceAction.do?method=edit" method="post">
<div class="page_title">客户服务管理 &gt; 服务处理</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button> 
	<!--<button class="common_button" onclick="submit()">保存</button>  
-->
	<input type="submit" value="保存" class="common_button"/>"
</div>
<table class="query_form_table">
<input type="hidden" name="fid" value="${fid.svrId}"/>
	<tr>
		<th>编号</th>
		<td>${fid.svrId}<input type="hidden" name="svrId" value="${fid.svrId}"/> </td>
		<th>服务类型</th>
		<td>
			${fid.svrType }
			
			</td>
	</tr>
	<tr>
		<th>概要</th>
		<td colspan="3">${fid.svrTitle }</td>
	</tr>	
	<tr>
		<th>客户</th>
		<td>${fid.svrCustName}</td>
		<th>状态</th>
		<td>${fid.svrStatus }</td>
	</tr>	
	<tr>
		<th>服务请求</th>
		<td colspan="3">${fid.svrRequest }<br>
　</td>
	</tr>
	<tr>
		<th>创建人</th>
		<td>${fid.svrCreateBy }</td>
		<th>创建时间</th>
		<td>${fid.svrCreateDate }</td>
	</tr>
	</table>
<br />
<table class="query_form_table" id="table3">
	<tr>
		<th>分配给</th>
		<td>
			${fid.svrDueTo }</td>
		<th>分配时间</th>
		<td>${fid.svrDueDate }</td>
	</tr>
</table>
<br />	
<table class="query_form_table" id="table1">
	<tr>
		<th>服务处理</th>
		<td colspan="3"><textarea rows="6" cols="50" name="svrDeal"></textarea><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>处理人</th>
		<td><input name="svrCreateBy" value="${fid.svrCreateBy }" readonly size="20" /><input type="hidden" name="svrCreateId" value="${fid.svrId}"/><span class="red_star">*</span></td>
		<th>处理时间</th>
		<td><input id="t3" name="svrDealDate" readonly size="20" /><span class="red_star">*</span></td>
	</tr>
</table>
<br />
<table disabled class="query_form_table" id="table2">
	<tr>
		<th>处理结果</th>
		<td><input name="T10" size="20" /><span class="red_star">*</span></td>
		<th>满意度</th>
		<td>
			<select name="D1">
				<option>请选择...</option>
				<option>☆☆☆☆☆</option>
				<option>☆☆☆☆</option>
				<option>☆☆☆</option>
				<option>☆☆</option>
				<option>☆</option>
			</select><span class="red_star">*</span></td>
	</tr>
</table>
</form>
<script>
	setCurTime('t3');
</script>
</body>
</html>
