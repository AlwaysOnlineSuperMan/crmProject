<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
</head>
<body>

<div class="page_title">客户信息管理 > 客户信息</div>
<html:form action="cstCustomerAction.do?method=doUpdByno">
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="to('cstLinkmanAction.do?method=getByNo&custName=${cstCustForm.custName }&custNo=${cstCustForm.custNo}');">联系人</button>
	<button class="common_button" onclick="to('cstActivityAction.do?method=getByNo&custName=${cstCustForm.custName }&custNo=${cstCustForm.custNo}');">交往记录</button>
	<button class="common_button" onclick="to('ordersAction.do?method=getByName&custName=${cstCustForm.custName }&custNo=${cstCustForm.custNo}');">历史订单</button>
	
	<button class="common_button" onclick="back();">返回</button>
	<input type="submit" value="修改"  class="common_button">
</div>
<table class="query_form_table">
	<tr>
		<th>客户编号</th>
		<td><html:text property="custNo" readonly="true"></html:text></td>
		<th>名称</th>
		<td>
		<html:text property="custName">
		</html:text><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>地区</th>
		<td>
			<html:select property="custRegion">
				<html:optionsCollection property="dictList" name="cstCustForm" label="dictItem" value="dictItem"/>
			</html:select>
			<span class="red_star">*</span></td>
		<th>客户经理</th>
		<td>
			<html:select property="custManagerName">
				<html:optionsCollection property="sysuserList" name="cstCustForm" label="usrName" value="usrName"/>
			</html:select>
			<span class="red_star">*</span>
		</td>
	</tr>	
	<tr>
		<th>客户等级</th>
		<td>
			<html:select property="custLevelLabel">
				<html:optionsCollection property="basdictList" name="cstCustForm" label="dictItem" value="dictItem"/>
			</html:select>
			<span class="red_star">*</span>
		</td>
		<th>　</th>
		<td>　</td>
	</tr>
	<tr>
		<th>客户满意度</th>
		<td>
			<select id="custSatisfy" name="custSatisfy">
					<option value="">未指定</option>
					<option value="5">☆☆☆☆☆</option>
					<option value="4">☆☆☆☆</option>
					<option value="3" selected="selected">☆☆☆</option>
					<option value="2">☆☆</option>
					<option value="1">☆</option>
			</select>	
			<span class="red_star">*</span>
		</td>
		<th>客户信用度</th>
		<td>
			<select  id="custCredit" name="custCredit">
					<option value="">未指定</option>
					<option value="5">☆☆☆☆☆</option>
					<option value="4">☆☆☆☆</option>
					<option value="3" selected="selected">☆☆☆</option>
					<option value="2">☆☆</option>
					<option value="1">☆</option>
			</select>
					<span class="red_star">*</span>
		</td>
	</tr>
</table>
<br />
<table class="query_form_table" id="table1">
	<tr>
		<th>地址</th>
		<td><html:text property="custAddr"></html:text><span class="red_star">*</span>
		</td>
		<th>邮政编码</th>
		<td><html:text property="custZip"></html:text><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>电话</th>
		<td>
			<html:text property="custTel"></html:text><span class="red_star">*</span></td>
		<th>传真</th>
		<td>
			<html:text property="custFax"></html:text><span class="red_star">*</span>
		</td>
	</tr>	
	<tr>
		<th>网址</th>
		<td>
			<html:text property="custWebsite"></html:text><span class="red_star">*</span>
		</td>
		<th>　</th>
		<td>　</td>
	</tr>
</table>
<br />
<table class="query_form_table" id="table2">
	<tr>
		<th>营业执照注册号</th>
		<td><html:text property="custLicenceNo"></html:text></td>
		<th>法人</th>
		<td><html:text property="custChieftain"></html:text><span class="red_star">*</span>
		</td>
	</tr>
	<tr>
		<th>注册资金（万元）</th>
		<td>
			<html:text property="custBankroll"></html:text></td>
		<th>年营业额</th>
		<td>
			<html:text property="custTurnover"></html:text>
		</td>
	</tr>	
	<tr>
		<th>开户银行</th>
		<td>
			<html:text property="custBank"></html:text><span class="red_star">*</span>
		</td>
		<th>银行帐号</th>
		<td><html:text property="custBankAccount"></html:text><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>地税登记号</th>
		<td>
			<html:text property="custLocalTaxNo"></html:text></td>
		<th>国税登记号</th>
		<td><html:text property="custNationalTaxNo"></html:text></td>
	</tr>
</table>
</html:form>
<p>　</p>
</body>
</html>
