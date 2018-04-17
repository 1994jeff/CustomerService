<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css" />
	<style>
		.inText {
	padding: 10px;
	background-color: white;
	border: 0px;
	font-size: 18px;
	padding-right: 20px;
}
	</style>
	<body>
		<div style="height: 80px;background-color:rgba(102, 153, 204, 1);">
			<div style="float: left;position: fixed;">
				<img src="${pageContext.request.contextPath}/img/back.png" width="25px" height="25px" style="margin-top: 28px;margin-left: 6px;" />
				<img src="${pageContext.request.contextPath}/img/close.png" height="25px" style="margin-top: 28px;margin-left: 4px;" />
			</div>
			<div><span style="margin-left:10px;color: white;font-size: 22px;line-height: 80px;text-align: center;display: block;">小E出错啦</span></div>
		</div>
		<div style="margin-top: 10px;background-color: white;overflow: hidden;padding: 20px;text-align: left;">
			<span>出错了哟!${errorMsg}</span>
		</div>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
	</body>
</html>
