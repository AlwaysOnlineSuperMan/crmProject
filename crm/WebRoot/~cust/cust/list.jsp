<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
	function del(custNo){
		if(confirm("确定要删除？")){
		var path="cstCustomerAction.do?method=delByNo&custNo="+custNo;
		alter(path);
			location.href=path;
		}
	}
</script>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
</head>

<body>

<html:form action="cstCustomerAction.do?method=getdBytext">
<div class="page_title">客户信息管理</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="to('cstCustomerAction.do?method=One');">查询</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>客户编号</th>
		<td><input /></td>
		<th>名称</th>
		<td><input /></td>
		<th>地区</th>
		<td>
			<html:select property="custRegion">
				<html:optionsCollection property="dictList" name="cstCustForm" label="dictItem" value="dictItem"/>
			</html:select>
		</td>
	</tr>
	<tr>
		<th>客户经理</th>
		<td><input /></td>
		<th>客户等级</th>
		<td>
			<html:select property="custLevelLabel">
				<html:optionsCollection property="basdictList" name="cstCustForm" label="dictItem" value="dictItem"/>
			</html:select>
		</td>
		<th>　</th>
		<td>　</td>
	</tr>
</table>
<br />
<table class="data_list_table">
	<tr>
		<th>序号</th>
		<th>客户编号</th>
		<th>名称</th>
		<th>地区</th>
		<th>客户经理</th>
		<th>客户等级</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${list}" var="customer" varStatus="v">
	
	<tr>
		<td class="list_data_number">${v.index+1 }</td>
		<td class="list_data_text">${customer.custNo}</td>
		<td class="list_data_ltext">${customer.custName}</td>
		<td class="list_data_text">${customer.custRegion }</td>
		<td class="list_data_text">${customer.custManagerName}</td>
		<td class="list_data_text">${customer.custLevelLabel }</td>
		<td class="list_data_op">
			<img onclick="to('cstCustomerAction.do?method=updByno&custNo=${customer.custNo}');" title="编辑" src="images/bt_edit.gif" class="op_button" />
			<img onclick="to('cstLinkmanAction.do?method=getByNo&custName=${customer.custName}&custNo=${customer.custNo}');" title="联系人" src="images/bt_linkman.gif" class="op_button" />
			<img onclick="to('cstActivityAction.do?method=getByNo&custNo=${customer.custNo}');" title="交往记录" src="images/bt_acti.gif" class="op_button" />
			<img onclick="to('ordersAction.do?method=getByName&custName=${customer.custName}&custNo=${customer.custNo}');" title="历史订单" src="images/bt_orders.gif" class="op_button" />
			<c:if test="${customer.custStatus==1}">
				<img onclick="del(${customer.custNo});" title="删除" src="images/bt_del.gif" class="op_button" />
			</c:if>
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
</html:form>
</body>

</html>
