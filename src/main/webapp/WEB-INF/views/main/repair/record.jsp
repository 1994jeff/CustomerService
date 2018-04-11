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
	.title{
	position: fixed;
	z-index: 99;
	background: rgba(102, 153, 204, 1);
	width: 100%;
	}
	</style>
	<body>
		<div style="height: 80px;background-color:rgba(102, 153, 204, 1);">
			<div style="float: left;position: fixed;z-index:100;">
				<img src="${pageContext.request.contextPath}/img/back.png" width="25px" height="25px" style="margin-top: 28px;margin-left: 6px;" onclick="backPage(-1)" />
<%-- 				<img src="${pageContext.request.contextPath}/img/close.png" height="25px" style="margin-top: 28px;margin-left: 4px;"  onclick="closeWindow()"/> --%>
			</div>
			<div class="title"><span style="color: white;font-size: 22px;line-height: 80px;text-align: center;display: block;font-weight: bold;">申请报修记录</span></div>
		</div>
		<div style="margin-top: 20px;background-color: white;">
			<c:forEach begin="0" end="1" items="${records}" var="record">
				<div style="background-color: white;padding: 10px;overflow: hidden;border-bottom:solid #cccccc 1px;">
					<div style="float: left;width: 64px;padding: 4px 0px;border-right: solid #cccccc 1px;">
						<img src="${pageContext.request.contextPath}/img/u87.png" width="36px" style="margin-left: 13px;"><br />
						<span style="margin-left: 16px;">报修</span>
					</div>
					<div style="padding-top: 6px;padding-left: 80px;">
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
			</c:forEach>
		</div>
		<script type="text/javascript">
	function backPage(num) {
		history.go(num);
	}
	</script>
	</body>

</html>