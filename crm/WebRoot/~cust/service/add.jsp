<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib  uri ="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript">
	if(checkForm1()){
		var form=document.getElementById("form1").submit();
	}	
	//服务高级查询
	function checkForm1()
	{
		var svrType = document.getElementById("svrType").value;
		
		var svrRequest = document.getElementsByName("svrRequest")[0].value;
		
		var svrTitle = document.getElementsByName("svrTitle")[0].value;
		
		var svrCustName = document.getElementsByName("svrCustName")[0].value;
		if(svrType ==""){
			var svrT=document.getElementById("svrType").value;
			alert("请选择服务类型");
			return false;
		}else if (svrRequest == "") {
			var svrReq = document.getElementById("svrRequest").value;
			alert("服务请求不能为空");
			return false;
		}else if (svrTitle == "") {
			var svrti = document.getElementById("svrTitle").value;
			alert("概要不能为空");
			return false;
		}else if (svrCustName == "") {
			var svrReq = document.getElementById("svrCustName").value;
			alert("客户名称不能为空");
			return false;
		}
		return true;
	}
</script>
<div clas
</head>
<body>
<html:form action="cstServiceAction.do?method=doCstServiceAdd" styleId="form1" method="post" onsubmit="return checkForm1()">
<div class="page_title">客户服务管理 > 服务创建</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<!--<button class="common_button" onclick="add('add.html');">保存</button>  
	--><input type="submit" value="保存" class="common_button">
</div>
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td><input readonly="readonly" /></td>
		<th>服务类型</th>
		<td>
		<html:select property="svrType">
			<html:option value="未选择">请选择</html:option>
			<html:optionsCollection property="basDictList" name="cstServiceForm" label="dictItem" value="dictValue"/>
		</html:select>
			<span class="red_star">*</span>
			<span id="svrType2"></span>
		</td>
	</tr>
	<tr>
		<th>概要</th>
		<td colspan="3">
		<html:text property="svrTitle"></html:text>
		<span class="red_star">*</span><span id="svrTitle"></span></td>
	</tr>	
	<tr>
		<th>客户</th>
		<td>
		<html:text property="svrCustName"></html:text>
		<span class="red_star">*</span></td>
		<th>状态</th>
		<td><html:text property="svrStatus" readonly="true"></html:text></td>
	</tr>	
	<tr>
		<th>服务请求</th>
		<td colspan="3">
		<html:textarea property="svrRequest" rows="6" cols="50"></html:textarea>
		<span class="red_star">*</span><span id="svrRequest"></span></td>
	</tr>
	<tr>
		<th>创建人</th>
		<td>
		<html:text property="svrCreateBy" readonly="true" size="20" ></html:text>
		<html:hidden property="svrCreateId"/>
		<span class="red_star">*</span></td>
		<th>创建时间</th>
		<td>
		<html:text property="svrCreateDate" readonly="true" size="20" ></html:text>
		<span class="red_star">*</span></td>
	</tr>
	</table>
<br />
<table disabled class="query_form_table" id="table3">
	<tr>
		<th>分配给</th>
		<td>
			<select>
				<option>请选择...</option>
				<option>小明</option>
				<option>旺财</option>
				<option>球球</option>
				<option>孙小美</option>
				<option>周洁轮</option>
			</select> <span class="red_star">*</span></td>
		<th>分配时间</th>
		<td><input id="t2" name="T18" readonly size="20" /><span class="red_star">*</span></td>
	</tr>
</table>
</html:form>
<br />	
<table disabled class="query_form_table" id="table1">
	<tr>
		<th>服务处理</th>
		<td colspan="3"><textarea rows="6" cols="50"></textarea><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>处理人</th>
		<td><input name="T17" value="刘颖" readonly size="20" /><span class="red_star">*</span></td>
		<th>处理时间</th>
		<td><input id="t3" name="T16" readonly size="20" /><span class="red_star">*</span></td>
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
<script>
	setCurTime('t1');
	setCurTime('t2');
	setCurTime('t3');
</script>
</body>
</html>