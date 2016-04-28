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
<html:form action="salPlanAction.do?method=doDev_plan">
<div class="page_title">客户开发计划 &gt; 制定计划</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="to('salPlanAction.do?method=toDev_execute&chcId=${salPlanForm.salChance.chcId}');">执行计划</button>
	<button class="common_button" onclick="back();">返回</button>
</div>
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td>${salPlanForm.salChance.chcId}
		<html:hidden property="chcId"/>
		</td>
		<th>机会来源</th>
		<td>
		${salPlanForm.salChance.chcSource}
		
			　</td>
	</tr>
	<tr>
		<th>客户名称</th>
		<td>${salPlanForm.salChance.chcCustName}</td>
		<th>成功机率（%）</th>
		<td>&nbsp;${salPlanForm.salChance.chcRate}</td>
	</tr>	
	<tr>
		<th>概要</th>
		<td colspan="3">${salPlanForm.salChance.chcTitle}</td>
	
	</tr>
	<tr>
		<th>联系人</th>
		<td>${salPlanForm.salChance.chcLinkman}</td>
		<th>联系人电话</th>
		<td>${salPlanForm.salChance.chcTel}</td>
	</tr>
	<tr>
		<th>机会描述</th>
		<td colspan="3">${salPlanForm.salChance.chcDesc}</td>
	</tr>
	<tr>
		<th>创建人</th>
		<td>${salPlanForm.salChance.chcCreateBy}</td>
		<th>创建时间</th>
		<td>${salPlanForm.salChance.chcCreateDate}</td>
	</tr>
	<tr>
		<th>指派给</th>
		<td>
			${salPlanForm.salChance.chcDueTo}</td>
		<th>指派时间：</th>
		<td>
			${salPlanForm.salChance.chcDueDate}
		</td>
	</tr>
</table>
<br />
<table class="data_list_table" id="table1">
	<tr>
		<th width="150px">日期</th>
		<th height="31">计划项</th>
	</tr>
	<c:forEach items="${salPlanList}" var="salPlan">
	<tr>
		<td class="list_data_text" height="24">${salPlan.plaDate}</td>
		<td class="list_data_ltext" height="24"><input size="50" value="${salPlan.plaTodo}" />
		<button class="common_button" onclick="save('dev_plan.jsp');">保存</button>
		<button class="common_button" onclick="del('');">删除</button>
		</td>
	</tr>
	</c:forEach>
	
</table>
<div class="button_bar">
	<html:submit styleClass="common_button">保存</html:submit>
	</div>

	<table class="query_form_table" id="table2">
		<tr>
			<th>日期</th>
			<td>
			<html:text property="plaDate" readonly="true"></html:text>
			<span class="red_star">*</span></td>
			<th>计划项</th>
			<td>
				<html:text property="plaTodo" size="50"></html:text>
				<span class="red_star">*</span>
			</td>
		</tr>
	</table>
</html:form>
</body>
</html>
