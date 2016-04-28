<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
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
<html:form action="productAction.do?method=toProductLsitForPage" >
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="submit();">查询</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>名称</th>
		<td>
		<html:text property="prodName"></html:text>
		</td>
		<th>型号</th>
		<td><html:text property="prodType"></html:text></td>
		<th>批次</th>
		<td><html:text property="prodBatch"></html:text></td>
	</tr>
</table>
<br />
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>名称</th>
		<th>型号</th>
		<th>等级/批次</th>
		<th>单位</th>
		<th>单价（元）</th>
		<th>备注</th>
	</tr>
	<!--
		<c:forEach items="${productForm.productList}" var="product" >
			<tr>
				<td class="list_data_number">${product.prodId}</td>
				<td class="list_data_ltext">${product.prodName}</td>
				<td class="list_data_text">${product.prodType}</td>
				<td class="list_data_text">${product.prodBatch}</td>
				<td class="list_data_text">${product.prodUnit}</td>
				<td class="list_data_number">${product.prodPrice}</td>
				<td class="list_data_ltext">${product.prodMemo}&nbsp;</td>		
			</tr>
		</c:forEach>
	-->
	<logic:empty name="productForm" property="pageModel.resultList" >
    		<tr>	   
    			<th colspan="7" > no data </th>
    		</tr>
    	</logic:empty>
    	<logic:notEmpty name="productForm" property="pageModel.resultList">
    		<logic:iterate id="product" name="productForm" property="pageModel.resultList">
    			<tr>
			      	<td class="list_data_number">${product.prodId}</td>
					<td class="list_data_ltext">${product.prodName}</td>
					<td class="list_data_text">${product.prodType}</td>
					<td class="list_data_text">${product.prodBatch}</td>
					<td class="list_data_text">${product.prodUnit}</td>
					<td class="list_data_number">${product.prodPrice}</td>
					<td class="list_data_ltext">${product.prodMemo}&nbsp;</td>					
    			</tr>
    		</logic:iterate>
    	</logic:notEmpty>
	
	<tr>
		<th colspan="100" class="pager">
<div class="pager">
	共${productForm.pageModel.allRecord}条记录 
	每页
	<html:text property="pageModel.maxRecord" size="2" onchange="change()"></html:text>条
	第${productForm.pageModel.currPage}页/共${productForm.pageModel.allPage}页
						<c:if test="${productForm.pageModel.currPage<=1}">
							<input type="button" value=" 已是首页  " disabled="disabled" size="3"/>
							<input type="button" value="上一页" disabled="disabled" size="3" />
						</c:if>
						<c:if test="${productForm.pageModel.currPage >1 }">
							<input type="button" value=" 首页  " onclick="topPage()"/>
							<input type="button" value="上一页" onclick="previousPage()"/>
						</c:if>
						<c:if test="${productForm.pageModel.currPage >= productForm.pageModel.allPage}">
							<input type="button" value="下一页" disabled="disabled"/>
							<input type="button" value=" 已是尾页  " disabled="disabled"/>
						</c:if>
						<c:if test="${productForm.pageModel.currPage < productForm.pageModel.allPage}"  >
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
				document.getElementById("currPage").value="${productForm.pageModel.fristPageNo}";
				document.forms[0].submit();
			}
		
			function previousPage() {				
				document.getElementById("currPage").value="${productForm.pageModel.previosPageNo}";
				document.forms[0].submit();
			}
		
			function nextPage() {  
				document.getElementById("currPage").value="${productForm.pageModel.nextPageNo}";
				document.forms[0].submit();
			}
		
			function bottomPage() {
				document.getElementById("currPage").value="${productForm.pageModel.bottomPageNo}";
				document.forms[0].submit();
			}
			function change(){
			document.getElementById("currPage").value=1;
			}
</script>