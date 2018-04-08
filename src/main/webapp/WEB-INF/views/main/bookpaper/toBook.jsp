<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
	<link rel="stylesheet" href="${pageContext.request.contextPath}css/base.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/js/base.js" />
	<body>
		<div style="height: 80px;background-color:rgba(102, 153, 204, 1);">
			<div style="float: left;position: fixed;">
				<img src="${pageContext.request.contextPath}img/back.png" width="25px" height="25px" style="margin-top: 28px;margin-left: 6px;" />
				<img src="${pageContext.request.contextPath}img/close.png" height="25px" style="margin-top: 28px;margin-left: 4px;" />
			</div>
			<div><span style="color: white;font-size: 22px;line-height: 80px;font-weight: bold;display: block;text-align: center;">去订纸¸</span></div>
		</div>
		<div>
			<div style="text-align: center;padding: 10px;">
				--<span style="color: rgba(102, 153, 204, 1);">配送信息</span>--
			</div>
			<div class="card">
				<div style="float:left;">
					<img src="${pageContext.request.contextPath}img/u223.png" width="30px" style="padding: 30px;padding-right: 10px;padding-left: 25px;"/>
				</div>
				<div style="padding-bottom: 20px;padding-left: 80px;">
					<br/><span style="font-size: 16px;line-height: 20px;">王XX</span><br />
					<span>13438977867</span><br />
					<span>上海市浦东新区张扬路</span><br />
				</div>
			</div>
			<div style="text-align: center;padding: 10px;">
				--<span style="color: rgba(102, 153, 204, 1);">订纸信息</span>--
			</div>
			<div style="background-color: white;margin-top: 10px;">
				<div style="padding: 20px;overflow: hidden;border-bottom: solid #cccccc 1px;">
					<span style="float: left;">申请门店:</span>
					<span style="float: right">coco都可</span>
				</div>
				<div style="padding: 20px;overflow: hidden;border-bottom: solid #cccccc 1px;">
					<span style="float: left;">订纸数量:</span>
					<span style="float: right">30卷</span>
				</div>
				<div style="padding: 20px;overflow: hidden;border-bottom: solid #cccccc 1px;">
					<span style="float: left;">预计使用期限:</span>
					<span style="float: right">自申请之日起30天</span>
				</div>
			</div>
			<div style="text-align: center;margin-top: 20px;"><span style="display: block;color: rgba(102, 153, 204, 1);padding:10px 20px;border-radius: 30px;border: solid rgba(102, 153, 204, 1) 1px;width: 230px;margin:auto;">确定申请订纸</span></div>
		</div>
	</body>
</html>
