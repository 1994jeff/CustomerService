<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>易佰客服后台管理系统</title>
	</head>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css" />
	<style>
		.div-body{
			padding: 10px;
			width: 60%;
			margin:30px auto;
		}
		.div-body span{
			background-color: #555555;
			display: block;
			text-align: center;
			padding: 50px 60px;
			font-size: 20px;
			font-weight: bold;
			margin: 30px;
			border-radius: 10px;
			color: white;
		}
		.div-body span:hover{
			background-color: cornflowerblue;
		}
		
	</style>
	<body>
		<div class="div-body">
			<a href="${pageContext.request.contextPath }/keyWord/toBook.do"><span>订纸申请</span></a>
			<a href="${pageContext.request.contextPath }/keyWord/toException.do"><span>异常申请</span></a>
			<a href="${pageContext.request.contextPath }/keyWord/toRepair.do"><span>报修申请</span></a>
			<a href="${pageContext.request.contextPath }/keyWord/toKeyWord.do"><span>关键词回复</span></a>
		</div>
	</body>
</html>