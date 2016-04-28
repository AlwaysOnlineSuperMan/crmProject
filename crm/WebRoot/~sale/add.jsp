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

<div class="page_title">销售机会管理&nbsp; &gt; 新建销售机会</div>
<html:form action="salChanceAction.do?method=doSalPlanAdd">
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
	<!--<button class="common_button" onclick="add('list.jsp');">保存</button>  
-->
	<input type="submit" value="保存">
</div>
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td><input readonly /></td>
		<th>机会来源</th>
		<td>
		<html:text property="chcSource"></html:text>
			</td>
	</tr>
	<tr>
		<th>客户名称</th>
		<td>
			<html:text property="chcCustName"></html:text>
		<span class="red_star">*</span></td>
		<th>成功机率</th>
		<td>
		<html:text property="chcRate"></html:text>
		<span class="red_star">*</span></td>
	</tr>	
	<tr>
		<th>概要</th>
		<td colspan="3">
			<html:text property="chcTitle" size="52"  ></html:text>
		<span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>联系人</th>
		<td>
		<html:text property="chcLinkman" size="20"  ></html:text>
		</td>
		<th>联系人电话</th>
		<td>
		<html:text property="chcTel" size="20"  ></html:text>
		
		</td>
	</tr>
	<tr>
		<th>机会描述</th>
		<td colspan="3">
		<html:textarea property="chcDesc" rows="6" cols="50"></html:textarea>
		<span class="red_star">*</span></td>
	</tr>
	<tr>
	<th>创建人</th>
		<td>
		<html:text property="chcCreateBy" value="${loginViewObject.usrName}" readonly="true" size="20"></html:text>
		<html:hidden property="chcCreateId"/>
		
		
		
		<span class="red_star">*</span></td>
		<th>创建时间</th>
		<td>
		
		<html:text property="chcCreateDate" readonly="true"  size="20" ></html:text>
		<span class="red_star">
		
		
		*</span></td>
	</tr>
</table>
<br />
<table disabled class="query_form_table" id="table1">
	<tr>
		<th>指派给</th>
		<td>
			<select name="D1">
				<option>请选择...</option>
				<option>小明</option>
				<option>旺财</option>
				<option>球球</option>
				<option>孙小美</option>
				<option>霞霞</option>
			</select> <span class="red_star">*</span></td>
		<th>指派时间</th>
		<td>
			
			<input id="t2" name="T20" readonly size="20" /><span class="red_star">*</span></td>
	</tr>
</table>
</html:form>
<script>
	setCurTime('t1');

	setCurTime('t2');
</script>
</body>
</html>
