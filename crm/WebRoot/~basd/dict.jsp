<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
</head>
<body>

<div class="page_title">数据字典管理</div>
<html:form action="basDictAction.do?method=toBasDictList">
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="to('basDictAction.do?method=toDictAdd');">新建</button>
	<button class="common_button" onclick="submit()">查询</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>类别</th>
		<td><html:text property="dictType"></html:text></td>
		<th>条目</th>
		<td><html:text property="dictItem"></html:text></td>
		<th>值</th>
		<td><html:text property="dictValue"></html:text></td>
	</tr>
</table>
<br />
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>类别</th>
		<th>条目</th>
		<th>值</th>
		<th>是否可编辑</th>
		<th>操作</th>
	</tr>
<logic:iterate id="basDict" collection="${basDictForm.pageModel.resultList}">
	<tr>
		<td class="list_data_number">${basDict.dictId}</td>
		<td class="list_data_ltext">${basDict.dictType}</td>
		<td class="list_data_text">${basDict.dictItem}</td>
		<td class="list_data_text">${basDict.dictValue}</td>
		<td class="list_data_text">
		<c:if test="${basDict.dictIsEditable eq 'true'}">
			是
		</c:if>
		<c:if test="${basDict.dictIsEditable eq 'false'}">
			否
		</c:if>
		</td>
		<td class="list_data_op">
		<c:if test="${basDict.dictIsEditable}">
				<img onclick="to('basDictAction.do?method=toDictEdit&dictId=${basDict.dictId}');" title="编辑" src="images/bt_edit.gif" class="op_button" />
		</c:if>
		<img onclick="del(${basDict.dictId});" title="删除" src="images/bt_del.gif" class="op_button" />
		</td>
	</tr>
</logic:iterate>
	
		<th colspan="6" class="pager">
<div class="pager">
	共${basDictForm.pageModel.allRecord}条记录 
	每页
	<html:text property="pageModel.maxRecord" size="2" onchange="change()"></html:text>条
	第${basDictForm.pageModel.currPage}页/共${basDictForm.pageModel.allPage}页
						<c:if test="${basDictForm.pageModel.currPage<=1}">
							<input type="button" value=" 首页  " >
							<input type="button" value="上一页">
						</c:if>
						<c:if test="${basDictForm.pageModel.currPage >1 }">
							<input type="button" value=" 首页  " onclick="topPage()">
							<input type="button" value="上一页" onclick="previousPage()">
						</c:if>
						<c:if test="${basDictForm.pageModel.currPage >= basDictForm.pageModel.allPage}">
							<input type="button" value="下一页" >
							<input type="button" value=" 尾页   " >
						</c:if>
						<c:if test="${basDictForm.pageModel.currPage < basDictForm.pageModel.allPage}">
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
<script type="text/javascript">
				function del(chcId){
					if(confirm("确定要删除？")){
						location.href="sysRoleAction.do?method=toDeleteSysRole&roleId="+chcId;
					}
				}
				
				function topPage() {
				var url = "basDictAction.do?method=toBasDictList"
				document.getElementById("currPage").value="${basDictForm.pageModel.fristPageNo}";
				//window.self.location = url
				document.forms[0].action=url;
				document.forms[0].submit();
			}
		
			function previousPage() {				
				var url = "basDictAction.do?method=toBasDictList"
				document.getElementById("currPage").value="${basDictForm.pageModel.previosPageNo}";
				//window.self.location = url
				document.forms[0].action=url;
				document.forms[0].submit();
			}
		
			function nextPage() {  
				
				var url = "basDictAction.do?method=toBasDictList";
				document.getElementById("currPage").value="${basDictForm.pageModel.nextPageNo}";
				//window.self.location = url
				document.forms[0].action=url;
				document.forms[0].submit();
			}
		
			function bottomPage() {

				
				var url = "basDictAction.do?method=toBasDictList";
				document.getElementById("currPage").value="${basDictForm.pageModel.bottomPageNo}";
				//window.self.location = url
				document.forms[0].action=url;
				document.forms[0].submit();
			}
			function change(){
			document.getElementById("currPage").value=1;
			}
			</script>
