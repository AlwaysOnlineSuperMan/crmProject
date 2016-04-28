<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<div class="page_title">客户开发计划</div>
<html:form action="salPlanAction.do?method=planList">
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<!--
		<button class="common_button" onclick="reload();">查询</button> 
	-->
	<input type="submit" value="查询">
	</div>
<table class="query_form_table">
	<tr>
		<th>客户名称</th>
		<td><html:text property="chcCustName"/></td>
		<th>概要</th>
		<td><html:text property="chcTitle"/></td>
		<th>联系人</th>
		<td>
			<html:text property="chcLinkman" size="20"/>
		</td>
	</tr>
	</table>
<br />
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>客户名称</th>
		<th>概要</th>
		<th>联系人</th>
		<th>联系人电话</th>
		<th>创建时间</th>
		<th>状态</th>
		<th>操作</th>
	</tr><!--
	
	<tr>
		<td class="list_data_number">1</td>
		<td class="list_data_text">睿智数码</td>
		<td class="list_data_ltext">采购笔记本电脑意向</td>
		<td class="list_data_text">刘先生</td>
		<td class="list_data_text">13729239239</td>
		<td class="list_data_text">2007年12月06日</td>
		<td class="list_data_text">开发中</td>
		<td class="list_data_op">
			<img onclick="to('dev_plan.jsp');" title="制定计划" src="images/bt_plan.gif" class="op_button" />
			<img onclick="to('dev_execute.jsp');" title="执行计划" src="images/bt_feedback.gif" class="op_button" />
			<img onclick="alert('用户开发成功，已添加新客户记录。');" title="开发成功" src="images/bt_yes.gif" class="op_button" />
		</td>
	</tr>
	<tr>
		<td class="list_data_number">2</td>
		<td class="list_data_text">泰宝实业</td>
		<td class="list_data_ltext">采购笔记本电脑意向</td>
		<td class="list_data_text">马先生</td>
		<td class="list_data_text">13333239239</td>
		<td class="list_data_text">2007年11月16日</td>
		<td class="list_data_text">已归档</td>
		<td class="list_data_op">
			<img onclick="to('dev_detail.jsp');" title="查看" src="images/bt_detail.gif" class="op_button" />
		</td>
	</tr>
	-->
	<c:forEach items="${salPlansObjectList}" var="salPlans">
	<tr>
		<td class="list_data_number">${salPlans.chcId}</td>
		<td class="list_data_text">${salPlans.chcCustName}</td>
		<td class="list_data_ltext">${salPlans.chcTitle}</td>
		<td class="list_data_text">${salPlans.chcLinkman}</td>
		<td class="list_data_text">${salPlans.chcTel}</td>
		<td class="list_data_text">${salPlans.chcCreateDate}</td>
		<c:if test="${salPlans.chcStatus=='4' || salPlans.chcStatus=='3'}">
			<td class="list_data_text">已归档</td>
		<td class="list_data_op">
			<img onclick="to('salPlanAction.do?method=dev_detail&chcId=${salPlans.chcId}');" title="查看" src="images/bt_detail.gif" class="op_button" />
		</td>
		</c:if>
		<c:if test="${salPlans.chcStatus!=4 && salPlans.chcStatus!=3}">
			<td class="list_data_text">开发中</td>
			<td class="list_data_op">
			<img onclick="to('salPlanAction.do?method=toDev_plan&chcId=${salPlans.chcId}');" title="制定计划" src="images/bt_plan.gif" class="op_button" />
			<img onclick="to('salPlanAction.do?method=toDev_execute&chcId=${salPlans.chcId}');" title="执行计划" src="images/bt_feedback.gif" class="op_button" />
			<img onclick="to('cstCustomerAction.do?method=addCustomer&chcId=${salPlans.chcId}');" title="开发成功" src="images/bt_yes.gif" class="op_button" />
			</td>
		</c:if>
	</tr>
		</c:forEach>
	<tr>
		<th colspan="10" class="pager">
<div class="pager">
	共${count}条记录 每页<html:text property="pageSize"   size="2"></html:text>条
	第${curPage}页/共${totalPage}页
					<c:if test="${curPage <= 1 }">
						首页 上页
					</c:if>
					
					<c:if test="${curPage > 1 }">
					<a href="salPlanAction.do?method=planList&page=1">首页</a>
					<a href="salPlanAction.do?method=planList&page=${curPage-1 }">上页</a>
					</c:if>
					<c:if test="${curPage >= totalPage }">
						下页 末页
					</c:if>
					<c:if test="${curPage < totalPage }">
						<a href="salPlanAction.do?method=planList&page=${curPage+1 }">下页</a>
						<a href="salPlanAction.do?method=planList&page=${totalPage }">未页</a>
					</c:if> 
	转到<html:text property="transmitPage" size="1"  value="0"></html:text>页
	<!--<button width="20" onclick="reload();">GO</button>
-->
<input type="submit" value="GO">
</div>
		</th>
	</tr>
</table>
</html:form>
</body>
</html>
