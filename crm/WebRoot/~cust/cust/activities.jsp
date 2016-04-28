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
<script type="text/javascript">
				function del(atvId){
					if(confirm("确定要删除？")){
					var path="cstActivityAction.do?method=delById&atvId="+atvId+"&custNo=${custNo}";
						location.href=path;
					}
				}
</script>
<body>

<div class="page_title">客户信息管理 &gt; 客户信息 &gt; 交往记录</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="to('cstActivityAction.do?method=New&custNo=${custNo}');">新建</button>  
	<button class="common_button" onclick="back();">返回</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>客户编号</th>
		<td>${custNo }</td>
		<th>客户名称</th>
		<td>${cstCustomer.custName }</td>
	</tr>
	</table>
<br />
<table class="data_list_table">
	<tr>
		<th width="232">时间</th>
		<th>地点</th>
		<th>概要</th>
		<th>详细信息</th>
		<th>备注</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${list}" var="activity">
	<tr>
		<td class="list_data_text" width="230">${activity.atvDate }</td>
		<td class="list_data_text">${activity.atvPlace }</td>
		<td class="list_data_ltext">${activity.atvTitle }</td>
		<td class="list_data_ltext">${activity.atvTitle }</td>
		<td class="list_data_op">${activity.atvDesc}</td>
		<td class="list_data_op">
			<img onclick="to('cstActivityAction.do?method=toedit&atvId=${activity.atvId}&custNo=${custNo}');" title="编辑" src="images/bt_edit.gif" class="op_button" />
			<img onclick="del('${activity.atvId}');" title="删除" src="images/bt_del.gif" class="op_button" />
			
		</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>
