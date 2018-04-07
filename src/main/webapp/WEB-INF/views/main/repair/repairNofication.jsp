<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/base.css" />
<body>
	<div style="height: 80px; background-color: rgba(102, 153, 204, 1);">
		<div style="float: left; position: fixed;">
			<img src="${pageContext.request.contextPath}/img/back.png"
				width="25px" height="25px"
				style="margin-top: 28px; margin-left: 6px;" /> <img
				src="${pageContext.request.contextPath}/img/close.png" height="25px"
				style="margin-top: 28px; margin-left: 4px;" />
		</div>
		<div>
			<span
				style="color: white; font-size: 22px; line-height: 80px; text-align: center; display: block; font-weight: bold;">进度提示</span>
		</div>
	</div>
	<div
		style="background: rgba(0, 204, 204, 1); border-top: solid white 1px; padding: 30px 10px; overflow: overlay;">
		<img src="${pageContext.request.contextPath}/img/u245.png"
			width="40px" style="float: left;" />
		<div
			style="float: left; margin-top: 8px; font-size: 20px; margin-left: 10px;">
			<span style="color: white;">待电话回访</span>
		</div>
	</div>
	<div style="background-color: white;">
		<div class="times">
			<ul>
				<li><b></b><span>待电话回访</span>
				<p>请务必保证联系电话准确通畅，我们的工程师会尽快与您取得联系</p></li>
				<!--b标签不输入内容，span标签内输入时间不限制格式，p标签内输入介绍内容。注意，标签内不能使用div分割-->
				<li><b></b><span>2011-01-01 12:32:32</span>
				<p>提交申请</p></li>
			</ul>
		</div>
	</div>
</body>
</html>
