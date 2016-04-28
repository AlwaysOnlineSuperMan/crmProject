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
<html:form action="salChanceAction.do?method=doDispatch">
<html:hidden property="chcUpdateDatetime"/>
<div class="page_title">销售机会管理&nbsp; &gt; 指派销售机会</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
	<!--<button class="common_button" >保存</button>  
-->
<input type="submit">
</div>

<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td>${salChanceForm.chcId}
			<html:hidden property="chcId"/>
		</td>
		<th>机会来源</th>
		<td>
			${salChanceForm.chcSource}
			<html:hidden property="chcSource"/>
			　</td>
	</tr>
	<tr>
		<th>客户名称</th>
		<td>
		${salChanceForm.chcCustName}
			<html:hidden property="chcCustName"/>
		</td>
		<th>成功机率（%）</th>
		<td>&nbsp;
		${salChanceForm.chcRate}
			<html:hidden property="chcRate"/>
		</td>
	</tr>	
	<tr>
		<th>概要</th>
		<td colspan="3">
			${salChanceForm.chcTitle}
			<html:hidden property="chcTitle"/>
		</td>
	</tr>
	<tr>
		<th>联系人</th>
		<td>
		${salChanceForm.chcLinkman}
			<html:hidden property="chcLinkman"/>
		</td>
		<th>联系人电话</th>
		<td>
			${salChanceForm.chcTel}
			<html:hidden property="chcTel"/>
		
		</td>
	</tr>
	<tr>
		<th>机会描述</th>
		<td colspan="3">
		${salChanceForm.chcDesc}
			<html:hidden property="chcDesc"/>
		</td>
	</tr>
	<tr>
		<th>创建人</th>
		<td>
			${salChanceForm.chcCreateBy}
			<html:hidden property="chcCreateBy"/>
		
		</td>
		<th>创建时间</th>
		<td>
		${salChanceForm.chcCreateDate}
			<html:hidden property="chcCreateDate"/>
	</td>
	</tr>
</table>
<br />
<table class="query_form_table" id="table1">
	<tr>
		<th>指派给</th>
		<td>
		
		
		<html:select property="chcDueId" onchange="changeChcDueName()" styleId="c">
			<html:optionsCollection property="sysUserList" name="salChanceForm" label="usrName" value="usrId"/>
		</html:select>
			 <span class="red_star">*</span></td>
		<th>指派时间</th>
		<td>
			<html:text property="chcDueDate" styleId="t2" size="20" readonly="true" styleClass="T20"></html:text>
			<span class="red_star">*</span></td>
	</tr>
</table>
</html:form>
<script>

	/*function changeChcDueName(){
	var chcDueName = document.getElementById("c").childNodes[0].innerHTML;
	alert(chcDueName);
	}*/
	setCurTime('t2');
</script>
</body>
</html>
