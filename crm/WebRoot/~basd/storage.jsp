<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
</head>
<body>

<div class="page_title">产品查询</div>
<html:form action="storageAction.do?method=toStorageListForPage">
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="submit()">查询</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>产品</th>
		<td><html:text property="stkProductName"></html:text></td>
		<th>仓库</th>
		<td><html:text property="stkWarehouse"></html:text></td>
		<th>&nbsp;</th>
		<td>&nbsp;</td>
	</tr>
</table>
<br />
<table class="data_list_table">
	<tr>
		<th>序号</th>
		<th>产品</th>
		<th>仓库</th>
		<th>货位</th>
		<th>件数</th>
		<th>备注</th>
	</tr>
	<logic:empty name="storageForm" property="pageModel.resultList">
		<th colspan="6">没有数据</th>
	</logic:empty>
	<logic:notEmpty name="storageForm" property="pageModel.resultList">
		<logic:iterate id="storage"  name="storageForm" property="pageModel.resultList"  >
		<tr>
		<td class="list_data_number">${storage.stkId}</td>
		<td class="list_data_ltext">${storage.stkProductName}</td>
		<td class="list_data_ltext">${storage.stkWarehouse}</td>
		<td class="list_data_text">${storage.stkWare}</td>
		<td class="list_data_number">${storage.stkCount}</td>
		<td class="list_data_ltext">${storage.stkMemo}&nbsp;</td>		
	</tr>
		
		</logic:iterate>
	</logic:notEmpty>
	<!--<c:forEach items="${storageForm.storageList}" var="storage">
	
	<tr>
		<td class="list_data_number">${storage.stkId}</td>
		<td class="list_data_ltext">${storage.stkProductName}</td>
		<td class="list_data_ltext">${storage.stkWarehouse}</td>
		<td class="list_data_text">${storage.stkWare}</td>
		<td class="list_data_number">${storage.stkCount}</td>
		<td class="list_data_ltext">${storage.stkMemo}&nbsp;</td>		
	</tr>
	
	</c:forEach>
	-->
	<tr>
		<th colspan="100" class="pager">
<div class="pager">
	共${storageForm.pageModel.allRecord}条记录 
	每页
	<html:text property="pageModel.maxRecord" size="2" onchange="change()"></html:text>条
	第${storageForm.pageModel.currPage}页/共${storageForm.pageModel.allPage}页
						<c:if test="${storageForm.pageModel.currPage<=1}">
							<input type="button" value=" 已是首页  " disabled="disabled"/>
							<input type="button" value="上一页" disabled="disabled"/>
						</c:if>
						<c:if test="${storageForm.pageModel.currPage >1 }">
							<input type="button" value=" 首页  " onclick="topPage()"/>
							<input type="button" value="上一页" onclick="previousPage()"/>
						</c:if>
						<c:if test="${storageForm.pageModel.currPage >= storageForm.pageModel.allPage}">
							<input type="button" value="下一页" disabled="disabled"/>
							<input type="button" value=" 已是尾页  " disabled="disabled"/>
						</c:if>
						<c:if test="${storageForm.pageModel.currPage < storageForm.pageModel.allPage}"  >
							<input type="button" value="下一页" onclick="nextPage()" />
							<input type="button" value=" 尾页    " onclick="bottomPage()" />
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
				var url = "storageAction.do?method=toStorageListForPage"
				document.getElementById("currPage").value="${storageForm.pageModel.fristPageNo}";
				//window.self.location = url
				document.forms[0].action=url;
				document.forms[0].submit();
			}
		
			function previousPage() {				
				var url = "storageAction.do?method=toStorageListForPage"
				document.getElementById("currPage").value="${storageForm.pageModel.previosPageNo}";
				//window.self.location = url
				document.forms[0].action=url;
				document.forms[0].submit();
			}
		
			function nextPage() {  
				
				var url = "storageAction.do?method=toStorageListForPage";
				document.getElementById("currPage").value="${storageForm.pageModel.nextPageNo}";
				//window.self.location = url
				document.forms[0].action=url;
				document.forms[0].submit();
			}
		
			function bottomPage() {

				
				var url = "storageAction.do?method=toStorageListForPage";
				document.getElementById("currPage").value="${storageForm.pageModel.bottomPageNo}";
				//window.self.location = url
				document.forms[0].action=url;
				document.forms[0].submit();
			}
			function change(){
			document.getElementById("currPage").value=1;
			}
</script>
