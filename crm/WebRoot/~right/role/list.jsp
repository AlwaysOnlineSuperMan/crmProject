<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>jb-aptech毕业设计项目</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link href="css/style.css" rel="stylesheet" type="text/css">
		<script src="<%=path%>/script/common.js"></script>
		<script src="<%=path %>/script/validate.js"></script>
	</head>

	<body>
		<div class="page_title">
			权限管理 > 用户管理 > 系统角色管理
		</div>
		<html:form action="sysRoleAction.do?method=toRoleAllList" >
			
			<div class="button_bar">
				<button class="common_button" onclick="help('');">
					帮助
				</button>
				<button class="common_button"
					onclick="to('~right/role/add.jsp');">
					新建
				</button>
				<button class="common_button" onclick="submit()">
					查询
				</button>
			</div>
			<table class="query_form_table">
				<tr>
					<th>
						角色名
					</th>
					<td>
						<html:text property="roleName" size="20"></html:text>
					</td>
					<th>角色描述</th>
					<td>
						<html:text property="roleDesc" size="20"></html:text>
					</td>
					<th>
						是否禁用
					</th>
					<td>
						<html:select property="roleFlag">
							<html:option value="0">全部</html:option>
							<html:option value="1">正常</html:option>
							<html:option value="2">禁用</html:option>
						</html:select>
					</td>
				</tr>
			</table>
			<br />
			<table class="data_list_table">
				<tr>
					<th>
						编号
					</th>
					<th>
						角色名
					</th>
					<th>
						角色描述
					</th>
					<th>
						状态
					</th>
					<th>
						操作
					</th>
				</tr>
				<logic:iterate id="role"  collection="${sysRoleForm.pageModel.resultList}">
					<tr>
						<td class="list_data_text">
							${role.roleId}
						</td>
						<td class="list_data_text">
							${role.roleName}
						</td>
						<td>
							${role.roleDesc }
						</td>
						<td class="list_data_text">
							<c:if test="${role.roleFlag==1}">
	   							正常
	   						</c:if>
							<c:if test="${role.roleFlag==2}">
	   							禁用
	   						</c:if>
						</td>
						<td class="list_data_op">
						<img onclick="to('sysRoleAction.do?method=toEditSysRole&roleId=${role.roleId}');"
								title="编辑" src="images/bt_edit.gif" class="op_button" />
						<c:if test="${role.roleFlag==1}">
							
							<img onclick="to('sysRoleAction.do?method=toDispatchRight&roleId=${role.roleId }')" 
							    title="分配权限" src="images/bt_linkman.gif" class="op_button" />
						</c:if>
							<img onclick="to('sysRoleAction.do?method=toDetailSysRole&roleId=${role.roleId}');"
								title="查看" src="images/bt_deal.gif" class="op_button" />
								<img
								onclick="del(${role.roleId})"
								title="删除" src="images/bt_del.gif" class="op_button" />
						
						</td>
					</tr>
				</logic:iterate>
				<tr>
					<th colspan="7" class="pager">
						<div class="pager">
	共${sysRoleForm.pageModel.allRecord}条记录 
	每页
	<html:text property="pageModel.maxRecord" size="2" onchange="change()"></html:text>条
	第${sysRoleForm.pageModel.currPage}页/共${sysRoleForm.pageModel.allPage}页
						<c:if test="${sysRoleForm.pageModel.currPage<=1}">
							<input type="button" value=" 首页  " >
							<input type="button" value="上一页">
						</c:if>
						<c:if test="${sysRoleForm.pageModel.currPage >1 }">
							<input type="button" value=" 首页  " onclick="topPage()">
							<input type="button" value="上一页" onclick="previousPage()">
						</c:if>
						<c:if test="${sysRoleForm.pageModel.currPage >= sysRoleForm.pageModel.allPage}">
							<input type="button" value="下一页" >
							<input type="button" value=" 尾页   " >
						</c:if>
						<c:if test="${sysRoleForm.pageModel.currPage < sysRoleForm.pageModel.allPage}">
							<input type="button" value="下一页" onclick="nextPage()">
							<input type="button" value=" 尾页   " onclick="bottomPage()">
						</c:if>
	转到
	<html:text property="pageModel.currPage" styleId="currPage" size="2"></html:text>页
	<button width="20" onclick="submit()">GO</button>
</div>
					</th>
				</tr>
			</table>
		</html:form>
	</body>
</html>
${msg}
<script type="text/javascript">
				function del(chcId){
					if(confirm("确定要删除？")){
						location.href="sysRoleAction.do?method=toDeleteSysRole&roleId="+chcId;
					}
				}
				
				function topPage() {
				var url = "sysRoleAction.do?method=toRoleAllList"
				document.getElementById("currPage").value="${sysRoleForm.pageModel.fristPageNo}";
				//window.self.location = url
				document.forms[0].action=url;
				document.forms[0].submit();
			}
		
			function previousPage() {				
				var url = "sysRoleAction.do?method=toRoleAllList"
				document.getElementById("currPage").value="${sysRoleForm.pageModel.previosPageNo}";
				//window.self.location = url
				document.forms[0].action=url;
				document.forms[0].submit();
			}
		
			function nextPage() {  
				
				var url = "sysRoleAction.do?method=toRoleAllList";
				document.getElementById("currPage").value="${sysRoleForm.pageModel.nextPageNo}";
				//window.self.location = url
				document.forms[0].action=url;
				document.forms[0].submit();
			}
		
			function bottomPage() {

				
				var url = "sysRoleAction.do?method=toRoleAllList";
				document.getElementById("currPage").value="${sysRoleForm.pageModel.bottomPageNo}";
				//window.self.location = url
				document.forms[0].action=url;
				document.forms[0].submit();
			}
			function change(){
			document.getElementById("currPage").value=1;
			}
			</script>
