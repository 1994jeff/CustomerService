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
			<img src="${pageContext.request.contextPath}/img/back.png" width="25px" height="25px" onclick="backPage(-1)" style="margin-top: 28px; margin-left: 6px;" />
<%-- 			<img src="${pageContext.request.contextPath}/img/close.png" height="25px" style="margin-top: 28px; margin-left: 4px;" /> --%>
		</div>
		<div>
			<span
				style="color: white; font-size: 22px; line-height: 80px; text-align: center; display: block; font-weight: bold;">进度提示</span>
		</div>
	</div>
	<div
		style="background: rgba(0, 204, 204, 1); border-top: solid white 1px; padding: 20px; overflow: overlay;padding-bottom: 40px;">
		<img src="${pageContext.request.contextPath}/img/u245.png"
			width="40px" style="float: left;" />
		<div
			style="float: left; margin-top: 8px; font-size: 20px; margin-left: 10px;">
			<span style="color: white;"><c:if test="${record.status=='0'}">待处理</c:if><c:if test="${record.status=='1'}">已处理</c:if></span>
		</div>
	</div>
	<c:if test="${record.status=='0'}">
		<div style="background-color: white;">
			<div class="times">
				<ul>
					<li><b></b><span>待处理</span>
					<p>管理员确认申请后，将为您发货</p></li>
					<!--b标签不输入内容，span标签内输入时间不限制格式，p标签内输入介绍内容。注意，标签内不能使用div分割-->
					<li><b></b><span><fmt:formatDate value="${record.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
					<p>提交申请成功</p></li>
				</ul>
			</div>
		</div>
	</c:if>
	<c:if test="${record.status=='1'}">
		<div style="background-color: white;">
			<div class="times">
				<ul>
					<li><b></b><span><fmt:formatDate value="${record.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
					<p>客服管理员已处理</p>
					<c:if test="${record.applyName=='pass' }">
						<p>快递:${result.reason}<br/>运单号:${result.remark }<br/>寄出小票纸:${result.goods}卷</p>
					</c:if>
					<c:if test="${record.applyName=='reject' }">
						<p>已拒绝您的申请</p>
						<p>原因:${result.replyMsg }</p>
					</c:if>
					</li>
					<!--b标签不输入内容，span标签内输入时间不限制格式，p标签内输入介绍内容。注意，标签内不能使用div分割-->
					<li><b></b><span><fmt:formatDate value="${record.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
					<p>提交申请成功</p></li>
				</ul>
			</div>
		</div>
	</c:if>
	<script type="text/javascript">
		function backPage(num) {
// 			history.go(num);
			window.location.href="${pageContext.request.contextPath}/login/toIndex.do";
		}
		</script>
</body>
</html>
