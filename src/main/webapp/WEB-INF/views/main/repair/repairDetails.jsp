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
	<body>
		<div style="height: 80px;background-color:rgba(102, 153, 204, 1);">
			<div style="float: left;position:fixed;">
				<img src="${pageContext.request.contextPath}/img/back.png" width="25px" height="25px" style="margin-top: 28px;margin-left: 6px;" />
				<img src="${pageContext.request.contextPath}/img/close.png" height="25px" style="margin-top: 28px;margin-left: 4px;" />
			</div>
			<div><span style="color: white;font-size: 22px;line-height: 80px;text-align: center;display: block;font-weight: bold;">报修申请详情</span></div>
		</div>
		<div style="margin-top: 10px;background-color: white;">
			<div>
				<div style="padding: 20px;overflow: hidden;border-bottom: solid #cccccc 1px;">
					<span style="float: left;">申请单号:</span>
					<span style="float: right">17932932</span>
				</div>
				<div style="padding: 20px;overflow: hidden;border-bottom: solid #cccccc 1px;">
					<span style="float: left;">申请门店:</span>
					<span style="float: right">coco都可</span>
				</div>
				<div style="padding: 20px;overflow: hidden;border-bottom: solid #cccccc 1px;">
					<span style="float: left;">申请卷纸数量:</span>
					<span style="float: right">30</span>
				</div>
				<div style="padding: 20px;overflow: hidden;border-bottom: solid #cccccc 1px;">
					<span style="float: left;">报修原因:</span>
					<span style="float: right">死机</span>
				</div>
			</div>
		</div>
	</body>
</html>
