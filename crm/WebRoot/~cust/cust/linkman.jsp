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
				function del(lkmId){
					if(confirm("确定要删除？")){
					var path="cstLinkmanAction.do?method=delById&lkmId="+lkmId+"&custName=${custName}&custNo=${custNo}";
						location.href=path;
					}
				}
</script>
<body>

<div class="page_title">客户信息管理 > 客户信息 > 联系人 </div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="to('cstLinkmanAction.do?method=New&custNo=${custNo}');">新建</button>  
	<button class="common_button" onclick="back();">返回</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>客户编号</th>
		<td>${custNo}</td>
		<th>客户名称</th>
		<td>${linkman.custName}</td>
	</tr>
	</table>
<br />
<table class="data_list_table">
	<tr>
		<th>姓名</th>
		<th>性别</th>
		<th>职位</th>
		<th>办公电话</th>
		<th>手机</th>
		<th>备注</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${list}" var="v">
	<tr>
		<td class="list_data_text">${v.lkmName}</td>
		<td class="list_data_ltext">${v.lkmSex}</td>
		<td class="list_data_text">${v.lkmPostion}</td>
		<td class="list_data_text">${v.lkmTel}</td>
		<td class="list_data_text">${v.lkmMobile}</td>
		<td class="list_data_op">${v.lkmMemo}</td>
		<td class="list_data_op">
			<img onclick="to('cstLinkmanAction.do?method=getById&lkId=${v.lkmId}&custNo=${custNo}');" title="编辑" src="images/bt_edit.gif" class="op_button" />
			<img onclick="del(${v.lkmId});" title="删除" src="images/bt_del.gif" class="op_button" />	
		</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>
