<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title></title>
</head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/base.css" />
<body>
	<div
		style="width: 100%; height: 150px; background-color: rgba(102, 153, 204, 1);">
		<div style="float: left;">
			<img src="${pageContext.request.contextPath}/img/back.png"
				width="25px" height="25px"
				style="margin-top: 28px; margin-left: 6px;" /> <img
				src="${pageContext.request.contextPath}/img/close.png" height="25px"
				style="margin-top: 28px; margin-left: 4px;" />
		</div>
		<div>
			<span
				style="color: white; font-size: 22px; line-height: 80px; margin-left: 80px;">易佰客服</span><img
				src="${pageContext.request.contextPath}/img/u102.png" height="25px"
				style="margin-top: 28px; float: right; margin-right: 10px;" />
		</div>
		<div></div>
		<div style="padding: 10px; color: white; font-size: 1.4em;">欢迎登录!</div>
	</div>
	<div
		style="width: 100%; padding: 20px; background-color: white; margin-top: 10px;">
		<a href="${pageContext.request.contextPath}/repair/toRepair.do?userNo=${user.userNo}">
			<div style="float: left; width: 100px;">
				<img src="${pageContext.request.contextPath}/img/u87.png"
					width="36px" style="margin-left: 13px;"><br /> <span>报修申请</span>
			</div>
		</a>
		<a href="${pageContext.request.contextPath}/book/toWantBook.do?userNo=${user.userNo}">
			<div>
				<img src="${pageContext.request.contextPath}/img/u86.png"
					width="36px" style="margin-left: 13px;"><br /> <span>订纸申请</span>
			</div>
		</a>
	</div>
	<div
		style="width: 100%; height: 100%; background-color: white; margin-top: 10px; padding: 10px; overflow: hidden; border-bottom: solid #cccccc 1px;">
		<div>
			<span style="float: left;">最新申请记录</span><span
				style="color: grey; float: right; margin-right: 10px;"><a href="${pageContext.request.contextPath}/repair/toMoreRecord.do?userNo=${user.userNo}">查看更多></a></span>
		</div>
	</div>
	<c:forEach begin="0" end="1" items="${records}" var="record">
		<c:if test="${ record.type==0 }">
			<div
				style="width: 100%; height: 100%; background-color: white; padding: 10px; overflow: hidden;border-bottom: solid #ccc 1px;">
				<div
					style="float: left; width: 70px; padding: 6px 0px; border-right: solid #cccccc 1px;">
					<img src="${pageContext.request.contextPath}/img/u87.png"
						width="36px" style="margin-left: 13px;"><br /> <span
						style="margin-left: 16px;">报修</span>
				</div>
				<div style="padding-top: 6px; padding-left: 80px;">
					<c:if test="${ record.status==0 }">
						<span>待处理</span>
						<br />
					</c:if>
					<c:if test="${ record.status==1 }">
						<span>已处理</span>
						<br />
					</c:if>
					<span style="color: gray;">报修原因:${record.reason }</span>
				</div>
			</div>
		</c:if>
		<c:if test="${ record.type==1 }">
			<div
				style="width: 100%; height: 100%; background-color: white; padding: 10px; overflow: hidden; border-bottom: solid #cccccc 1px;">
				<div
					style="float: left; width: 70px; padding: 6px 0px; border-right: solid #cccccc 1px;">
					<img src="${pageContext.request.contextPath}/img/u86.png"
						width="36px" style="margin-left: 13px;"><br /> <span
						style="margin-left: 16px;">订纸</span>
				</div>
				<div style="padding-top: 5px; padding-left: 80px;">
					<c:if test="${ record.status==0 }">
						<span>待处理</span>
						<br />
					</c:if>
					<c:if test="${ record.status==1 }">
						<span>已处理</span>
						<br />
					</c:if>
					<span>订纸数量:${ record.applyMobile }卷</span><br /> <span
						style="color: gray;">预计可使用至${ record.remark }</span>
				</div>
			</div>
		</c:if>
	</c:forEach>
</body>
</html>