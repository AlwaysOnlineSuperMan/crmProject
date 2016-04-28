<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
 <base href="<%=basePath%>">
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="<%=path %>/script/common.js"></script>
<script src="<%=path %>/script/validate.js"></script>
<script type="text/javascript">
				function del(chcId){
					if(confirm("确定要删除？")){
						location.href="sysUserAction.do?method=toDelete&userId="+chcId;
					}
				}
				
				function topPage() {
				var url = "sysUserAction.do?method=toUserListForPage"
				document.getElementById("currPage").value="${sysUserForm.pageModel.fristPageNo}";
				//window.self.location = url
				document.forms[0].action=url;
				document.forms[0].submit();
			}
		
			function previousPage() {				
				var url = "sysUserAction.do?method=toUserListForPage"
				document.getElementById("currPage").value="${sysUserForm.pageModel.previosPageNo}";
				//window.self.location = url
				document.forms[0].action=url;
				document.forms[0].submit();
			}
		
			function nextPage() {  
				
				var url = "sysUserAction.do?method=toUserListForPage";
				document.getElementById("currPage").value="${sysUserForm.pageModel.nextPageNo}";
				//window.self.location = url
				document.forms[0].action=url;
				document.forms[0].submit();
			}
		
			function bottomPage() {

				
				var url = "sysUserAction.do?method=toUserListForPage";
				document.getElementById("currPage").value="${sysUserForm.pageModel.bottomPageNo}";
				//window.self.location = url
				document.forms[0].action=url;
				document.forms[0].submit();
			}
			function change(){
			document.getElementById("currPage").value=1;
			}
			</script>
			
</head>
  
  <body>
    <div class="page_title">权限管理 > 用户管理 > 系统用户管理</div>
    <html:form action="sysUserAction.do?method=toUserListForPage" >
    
    	<div class="button_bar">
	   		<button class="common_button" onclick="help('');">帮助</button>
	   		<button class="common_button" onclick="to('sysUserAction.do?method=toUserAdd');">新建</button>
			<button class="common_button" onclick="submit();">查询</button>
	   	</div>
	   	<table class="query_form_table">
	   		<tr>
	   			<th>
	   				用户名
	   			</th>
	   			<td>
	   				<html:text property="usrName" size="20"></html:text>
	   			</td>
	   			<th>
	   				是否禁用
	   			</th>
	   			<td>					  
	   				<html:select property="usrFlag">
	   					<html:option value="0">全部</html:option>
	   					<html:option value="1">正常</html:option>
	   					<html:option value="2">禁用</html:option>
	   				</html:select>
	   			</td>
	   		</tr>
	   	</table>
	   	<br/>
	   	<table class="data_list_table">
	   		<tr>
	   			<th>编号</th>
	   			<th>用户名</th>
	   			<th>角色</th>
	   			<th>状态</th>
	   			<th>操作</th>
	   		</tr>
	   		<logic:iterate id="sysUser"   collection="${sysUserForm.pageModel.resultList}">
	   		<tr>
	   			<td class="list_data_text">${sysUser.usrId}</td>
	   			<td class="list_data_text">${sysUser.usrName}</td>
	   			<td class="list_data_text">${sysUser.usrRoleName}</td>
	   			<td class="list_data_text">
	   				<c:if test="${sysUser.usrFlag==1}">
	   					正常
	   				</c:if>
	   				<c:if test="${sysUser.usrFlag==2}">
	   					禁用
	   				</c:if>
	   			</td>
	   			<td class="list_data_op">
	   				<c:if test="${sysUser.usrFlag==1}">
	   					<img onclick="to('sysUserAction.do?method=toUserEdit&userId=${sysUser.usrId}');" title="编辑" src="images/bt_edit.gif" class="op_button" />
	   					<img onclick="to('sysUserAction.do?method=toDispatch&userId=${sysUser.usrId}');" title="指派" src="images/bt_linkman.gif" class="op_button" />
	   				</c:if>
	   				<img onclick="to('sysUserAction.do?method=toDetail&userId=${sysUser.usrId}');" title="查看" src="images/bt_deal.gif" class="op_button" />
	   				<c:if test="${sysUser.usrFlag==1}">
	   					<!--<img onclick="del('你确定要删除：${sysUser.usrName} ？','sysUserAction.do?method=toDelete&userId=${sysUser.usrId}');" title="删除" src="images/bt_del.gif" class="op_button" />
	   				--><img onclick="del(${sysUser.usrId})" title="删除" src="images/bt_del.gif" class="op_button" />
	   				</c:if>
	   			</td>
	   		</tr>
	   		</logic:iterate>
	   		<tr>
		<th colspan="7" class="pager">
	
<div class="pager">
	共${sysUserForm.pageModel.allRecord}条记录 
	每页
	<html:text property="pageModel.maxRecord" size="2" onchange="change()"></html:text>条
	第${sysUserForm.pageModel.currPage}页/共${sysUserForm.pageModel.allPage}页
						<c:if test="${sysUserForm.pageModel.currPage<=1}">
							<input type="button" value=" 首页  " >
							<input type="button" value="上一页">
						</c:if>
						<c:if test="${sysUserForm.pageModel.currPage >1 }">
							<input type="button" value=" 首页  " onclick="topPage()">
							<input type="button" value="上一页" onclick="previousPage()">
						</c:if>
						<c:if test="${sysUserForm.pageModel.currPage >= sysUserForm.pageModel.allPage}">
							<input type="button" value="下一页" >
							<input type="button" value=" 尾页   " >
						</c:if>
						<c:if test="${sysUserForm.pageModel.currPage < sysUserForm.pageModel.allPage}">
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