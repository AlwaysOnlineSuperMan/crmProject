<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript">
	window.onload = function(){
		var sex = document.getElementById("sex").Value;
		if(sex=="男"){
			document.all("lkmSex")[0].checked=true;
		}else{
			document.all("lkmSex")[1].checked=true;
		}
	}
</script>
</head>
<body>

<html:form action="cstLinkmanAction.do">
<input type="hidden" name="method" value="updLinkman"/>
<html:hidden property="lkmId"  value="${linkman.lkmId}"/>
<html:hidden property="lkmCustName"  value="${linkman.lkmCustName}"/>
<html:hidden property="lkmUpdateDatetime"  value="${linkman.lkmUpdateDatetime}"/>
<input type="hidden" name="custNo" value="${custNo}"/>
<div class="page_title">客户信息管理 > 客户信息 > 联系人 > 编辑联系人</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
	<input type="submit" value="保存" class="common_button">
</div>
<table class="query_form_table" id="table1">
	<tr>
		<th>姓名</th>
		<td><html:text property="lkmName"  value="${linkman.lkmName}" readonly="true" ></html:text><span class="red_star">*</span></td>
		<th>性别</th>
		<td>
			<input type="hidden" id="sex" value="${lkmSex}"/>
			<html:radio property="lkmSex" value="${linkman.lkmSex}">男</html:radio>
			<html:radio property="lkmSex" value="${linkman.lkmSex}">女</html:radio>
		</td>
	</tr>
	<tr>
		<th>职位</th>
		<td><html:text property="lkmPostion" value="${linkman.lkmPostion}"></html:text><span class="red_star">*</span></td>
		<th>办公电话</th>
		<td><html:text property="lkmTel" value="${linkman.lkmTel}"></html:text><span class="red_star">*</span></td>
	</tr>	 
	<tr>
		<th>手机</th>
		<td><html:text property="lkmMobile" value="${linkman.lkmMobile}"></html:text></td>
		<th>备注</th>
		<td><html:textarea property="lkmMemo" value="${linkman.lkmMemo}"></html:textarea></td>
	</tr>
</table>
</html:form>
</body>
</html>
