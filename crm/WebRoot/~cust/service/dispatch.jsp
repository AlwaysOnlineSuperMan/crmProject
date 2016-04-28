<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript">
	function reload()
	{
		if(checksel()){
			var form=document.getElementById("form1").submit();	
		}
	}
	//服务高级查询
	function checksel(){
		var reg=/^\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;
		if(document.getElementById("svrCreateDate").value !="" && reg.test(document.getElementById("svrCreateDate").value)==false){
			alert("开始日期格式不正确");
			return false;
		}else if(document.getElementById("svrCreateDate1").value !="" && reg.test(document.getElementById("svrCreateDate1").value)==false){
			alert("结束日期格式不正确");
			return false;
		}
		return true;
	}
</script>
<script type="text/javascript">
		function del(svrId){
			if(confirm("确定要删除？")){
					location.href="cstServiceAction.do?method=delService&svrId="+svrId;
				}
			}
</script>
</head>
<body>
<form action="cstServiceAction.do?method=selByService2" styleId="form1" method="post" onsubmit="return checksel()">
<div class="page_title">客户服务管理 > 服务分配</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="submit()">查询</button>  
</div>
<table class="query_form_table" height="53">
	<tr>
		<th height="28">客户</th>
		<td>
					<input type="text" name="svrCustName"/>
				</td>
		<td><input type="hidden" name="uri" value="/cstServiceAction.do?method=listAll&svrStatus=0&uri=/html/~cust/service/dispatch.jsp"/></td>
				<th height="28">
					概要
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
		<th height="22">创建日期</th>
		<td colspan="3">
			<input name="svrCreateDate1" size="10"/>
			 - <input name="svrCreateDate2" size="10"/></td>
		<th height="22">状态</th>
		<td>
			<select name="csvrStatus">
				<option value="新创建">新创建</option>
			</select>
		</td>
	</tr>
</table>
</form>
<br />
<html:form action="cstServiceAction.do?method=updateDispatch" >
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>客户</th>
		<th>概要</th>
		<th>服务类型</th>
		<th>创建人</th>
		<th>创建日期</th>
		<th>分配给</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${list}" var="v">
	<tr>
		<td class="list_data_number">${v.svrId }</td>
		<td class="list_data_text">${v.svrCustName }</td>
		<td class="list_data_ltext">${v.svrTitle }</td>
		<td class="list_data_text">${v.svrType }</td>
		<td class="list_data_text">${v.svrCreateBy }</td>
		<td class="list_data_text">${v.svrCreateDate }</td>
		<td class="list_data_text">
			<select name="service.svrDueId">
				<option>请选择...</option>
				<c:forEach items="${sysUser }" var="u">
					<option value="${u.usrId }">${u.usrName }</option>
					 <html:hidden property="cstServiceService.svrDueTo" value="${u.usrName }"/>
				</c:forEach>
			</select>
			<html:hidden property="svrId" value="${v.svrId }"/>
			<button class="common_button" onclick="submit()">分配</button> 
		</td>
		</form>
		<td class="list_data_op">
			<img onclick="del('${v.svrId }');" title="删除" src="images/bt_del.gif" class="op_button" />  
		</td>
	</tr>
	</c:forEach>
	<tr>
		<th colspan="8" class="pager">
<div class="pager">
	共5条记录 每页<input value="10" size="2" />条
	第<input value="1" size="2"/>页/共5页
	第一页
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
</html:form>
</html>
