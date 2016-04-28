<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<div class="page_title">客户服务管理 &gt; 服务归档</div>
<form action="cstServiceAction.do?method=selByService3" method="post">
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="submit()">查询</button>  
</div>
<table class="query_form_table">
	<tr>
		<th height="28">客户</th>
		<td><input name="svrCustName"/></td>
		<th height="28">概要</th>
		<td><input name="svrTitle"/></td>
		<th height="28">服务类型</th>
		<td>
			<select name="svrType">
				
				<option value="null">全部</option>
				<option value="建议">建议</option>
					<option value="咨询">咨询</option>
					<option value="头像">qq头像</option>
			</select>
		</td>
	</tr>
	<tr>
		<th height="32">创建日期</th>
		<td colspan="3">
			<input name="svrCreateDate1" size="10" /> - <input name="svrCreateDate2" size="10" /></td>
		<th height="32">状态</th>
		<td>
			<select name="svrStatus">
				<option value="已处理">已处理</option>
			</select>
		</td>
	</tr>
</table>
</form>
<br />
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>客户</th>
		<th>概要</th>
		<th>服务类型</th>
		<th>创建人</th>
		<th>创建日期</th>
		<th>状态</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${list }" var="v">
	<tr>
		<td class="list_data_number">${v.svrId }</td>
		<td class="list_data_text">${v.svrCustName }</td>
		<td class="list_data_ltext">${v.svrTitle }</td>
		<td class="list_data_text">${v.svrType }</td>
		<td class="list_data_text">${v.svrCreateBy }</td>
		<td class="list_data_text">${v.svrCreateDate }</td>
		<td class="list_data_text">
		<c:if test="${v.svrStatus eq '已归档'}">
		已归档
		</c:if>
		
		</td>
		<td class="list_data_op">
						
			<img onclick="to('cstServiceAction.do?method=FindByDetail&id=${v.svrId}');" title="查看" src="images/bt_detail.gif" class="op_button" /></td>
	</tr>
	</c:forEach>
	<tr>
		<th colspan="8" class="pager">
<div class="pager">
	共2条记录 每页<input value="10" size="2" />条
	第<input value="1" size="2"/>页/共5页
	<a >第一页</a>
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
