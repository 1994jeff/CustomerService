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
			<div><span style="margin-left:10px;color: white;font-size: 22px;line-height: 80px;text-align: center;display: block;">门店绑定</span></div>
		</div>
		<div style="margin-top: 10px;background-color: white;overflow: hidden;">
			<div>
				<div style="padding: 10px;overflow: hidden;border-bottom: solid #cccccc 1px;">
					<span style="float: left;margin-left: 10px;"><img src="${pageContext.request.contextPath}/img/u135.png" width="40px"/></span>
					<span style="float: right"><input class="inText" placeholder="请输入您门店POS机终端号"/></span>
				</div>
			</div>
			<div>
				<div style="padding:10px;overflow: hidden;border-bottom: solid #cccccc 1px;">
					<span style="float: left;margin-left: 10px;"><img src="${pageContext.request.contextPath}/img/u144.png" width="40px"/></span>
					<span style="float: right"><input class="inText" placeholder="请输入操作员号"/></span>
				</div>
			</div>
			<div>
				<div style="padding:10px;overflow: hidden;border-bottom: solid #cccccc 1px;">
					<span style="float: left;margin-left: 10px;"><img src="${pageContext.request.contextPath}/img/u145.png" width="40px"/></span>
					<span style="float: right"><input class="inText" type="password" placeholder="请输入操作员密码"/></span>
				</div>
			</div>
		</div>
		<div style="text-align: center;margin-top: 20px;"><span style="display: block;color: cornflowerblue;padding:10px 20px;border-radius: 30px;border: solid cornflowerblue 1px;width: 230px;margin:auto;">下一步</span></div>
	</body>
</html>
