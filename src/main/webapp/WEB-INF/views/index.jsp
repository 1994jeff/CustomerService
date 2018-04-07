<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
	</head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css" />
	<body>
		<div style="width: 100%;height: 150px;background-color:rgba(102, 153, 204, 1);">
			<div style="float: left;">
				<img src="${pageContext.request.contextPath}/img/back.png" width="25px" height="25px" style="margin-top: 28px;margin-left: 6px;" />
				<img src="${pageContext.request.contextPath}/img/close.png" height="25px" style="margin-top: 28px;margin-left: 4px;" />
			</div>
			<div><span style="color: white;font-size: 22px;line-height: 80px;margin-left: 80px;">易佰客服</span><img src="img/u102.png" height="25px" style="margin-top: 28px;float: right;margin-right: 10px;" /></div>
			<div>
			</div>
			<div style="padding: 10px;color: white;font-size: 1.4em;">欢迎登录!</div>
		</div>
		<div style="width: 100%;padding: 20px;background-color: white;margin-top: 10px;">
			<div style="float: left;width: 100px;" onclick="${pageContext.request.contextPath}/repair/toRepair.do">
				<img src="${pageContext.request.contextPath}/img/u87.png" width="36px" style="margin-left: 13px;"><br />
				<span>报修申请</span>
			</div>
			<div onclick="${pageContext.request.contextPath}/book/toWantBook.do">
				<img src="${pageContext.request.contextPath}/img/u86.png" width="36px" style="margin-left: 13px;"><br />
				<span>订纸申请</span>
			</div>
		</div>
		<div style="width: 100%;height: 100%;background-color: white;margin-top: 10px;padding: 10px;overflow: hidden;border-bottom: solid #cccccc 1px;">
			<div><span style="float: left;">最新申请记录</span><span style="color: grey;float: right;margin-right: 10px;">查看更多></span></div>
		</div>
		<div style="width: 100%;height: 100%;background-color: white;padding: 10px;overflow: hidden;border-bottom: solid #cccccc 1px;">
			<div style="float: left;width: 70px;padding: 6px 0px;border-right: solid #cccccc 1px;">
				<img src="${pageContext.request.contextPath}/img/u86.png" width="36px" style="margin-left: 13px;"><br />
				<span style="margin-left: 16px;">订纸</span>
			</div>
			<div style="padding-top: 5px;padding-left: 80px;">
				<span>待处理</span><br/>
				<span>订纸数量:30卷</span><br/>
				<span style="color: gray;">预计可使用至2018-03-12</span>
			</div>
		</div>
		<div style="width: 100%;height: 100%;background-color: white;padding: 10px;overflow: hidden;">
			<div style="float: left;width: 70px;padding: 6px 0px;border-right: solid #cccccc 1px;">
				<img src="${pageContext.request.contextPath}/img/u87.png" width="36px" style="margin-left: 13px;"><br />
				<span style="margin-left: 16px;">报修</span>
			</div>
			<div style="padding-top: 6px;padding-left: 80px;">
				<span>已处理</span><br/>
				<span style="color: gray;">报修原因:机具突然死机无法打印小票</span>
			</div>
		</div>
	</body>
</html>
