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
</head>
<body>

<div class="page_title">数据字典管理 > 编辑数据字典条目</div>
<html:form action="basDictAction.do?method=doDictEdit">
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
	<button class="common_button" onclick="submit();">保存</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td>${basDictForm.dictId}
		<html:hidden property="dictId"/>
		</td>
		<th>类别</th>
		<td><html:text property="dictType"></html:text><span class="red_star">*</span><br />（需要使用Ajax实现自动补全功能）</td>
	</tr>
	<tr>
		<th>条目</th>
		<td>
		<html:text property="dictItem"></html:text>
		<span class="red_star">*</span></td>
		<th>值</th>
		<td>
		<html:text property="dictValue"></html:text>
		<span class="red_star">*</span></td>
	</tr>	
	<tr>
		<th>是否可编辑</th>
		<td>
	
		<html:checkbox property="dictIsEditable" ></html:checkbox>
		
		</td>
		<th>&nbsp;</th>
		<td>&nbsp;</td>
	</tr>
</table>
</html:form>
</body>
</html>
