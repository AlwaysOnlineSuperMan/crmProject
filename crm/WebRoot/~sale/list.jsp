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
<script type="text/javascript">
				function del(chcId){
					if(confirm("确定要删除？")){
						location.href="salChanceAction.do?method=salPlaneDelete&chcId="+chcId;
					}
				}
			</script>
</head>
<body>

<div class="page_title">销售机会管理</div>
	<html:form action="salChanceAction.do?method=salChanceaManageList">
<div class="button_bar">
	<button class="common_button" onclick="help('请您联系宁思。。');">帮助</button>
	<button class="common_button" onclick="to('salChanceAction.do?method=toSalPlanAdd');">新建</button>  
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
		<th>操作</th>
	</tr>
	
	<c:forEach items="${salPlansObjectList}" var="salPlans">

	<tr>
		<td class="list_data_number">${salPlans.chcId}</td>
		<td class="list_data_text">${salPlans.chcCustName}</td>
		<td class="list_data_ltext">${salPlans.chcTitle}</td>
		<td class="list_data_text">${salPlans.chcLinkman}</td>
		<td class="list_data_text">${salPlans.chcTel}</td>
		<td class="list_data_text">${salPlans.chcCreateDate}</td>
		<td class="list_data_op">
		<!--
		//销售经理usrRoleId=2指派给客服经理usrRoleId=3
				-->
				<c:if test="${loginViewObject.usrRoleId==2}">
				<img onclick="to('salChanceAction.do?method=toDispatch&chcId=${salPlans.chcId}');" title="指派" src="images/bt_linkman.gif" class="op_button" />
				</c:if>
			<img onclick="to('salChanceAction.do?method=toSalPlaneEdit&chcId=${salPlans.chcId}');"  title="编辑" src="images/bt_edit.gif" class="op_button" />
			<img onclick="del(${salPlans.chcId})" title="删除" src="images/bt_del.gif" class="op_button" />
			
		</td>
	
	</tr>
		</c:forEach>
	<tr>
		<th colspan="7" class="pager">

<div class="pager">
	共${count}条记录 每页<html:text property="pageSize"   size="2"></html:text>条
	第${curPage}页/共${totalPage}页
					<c:if test="${curPage <= 1 }">
						首页 上页
					</c:if>
					
					<c:if test="${curPage > 1 }">
					<a href="salChanceAction.do?method=salChanceaManageList&page=1">首页</a>
					<a href="salChanceAction.do?method=salChanceaManageList&page=${curPage-1 }">上页</a>
					</c:if>
					<c:if test="${curPage >= totalPage }">
						下页 末页
					</c:if>
					<c:if test="${curPage < totalPage }">
						<a href="salChanceAction.do?method=salChanceaManageList&page=${curPage+1 }">下页</a>
						<a href="salChanceAction.do?method=salChanceaManageList&page=${totalPage }">未页</a>
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
