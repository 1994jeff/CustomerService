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
				style="margin-left: 10px; color: white; font-size: 22px; line-height: 80px; text-align: center; display: block;">自助报修</span>
		</div>
		<div>
			<div class="card">
				<div style="float: left;">
					<img src="${pageContext.request.contextPath}/img/u161.png"
						width="40px" style="padding: 20px;" />
				</div>
				<div style="padding-bottom: 20px; padding-left: 80px;">
					<br />
					<span
						style="color: cornflowerblue; font-size: 16px; line-height: 20px;">coco都可(成都店)</span><br />
					<span>门店电话:021-8977867</span><span
						style="float: right; margin-right: 4px; color: gray;">我换店了></span><br />
					<span>门店地址:上海市浦东新区张扬路</span><br />
				</div>
			</div>
			<div class="card">
				<div style="float: left;">
					<img src="${pageContext.request.contextPath}/img/u411.png"
						width="50px" style="padding: 20px;" />
				</div>
				<div style="float: left;">
					<br />
					<span
						style="color: cornflowerblue; font-size: 16px; line-height: 30px;">申请人：XXX</span><br />
					<span>联系电话:021-8977867</span><br />
				</div>
			</div>
		</div>
		<div style="text-align: center; padding: 10px;">
			--<span style="color: dodgerblue; font-weight: bold;">报修信息</span>--
		</div>
		<div style="background-color: white; padding: 20px; margin-top: 10px;">
			故障描述:<input class="inText" type="text" placeholder="请输入描述内容" />
		</div>
		<div style="text-align: center; margin-top: 20px;">
			<span
				style="display: block; color: cornflowerblue; padding: 10px 20px; border-radius: 30px; border: solid cornflowerblue 1px; width: 230px; margin: auto;">确定申请报修</span>
		</div>
	</div>
</body>
</html>
