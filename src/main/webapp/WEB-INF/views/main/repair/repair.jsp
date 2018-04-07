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
			<div style="float: left;position: fixed;">
				<img src="${pageContext.request.contextPath}/img/back.png" width="25px" height="25px" style="margin-top: 28px;margin-left: 6px;" />
				<img src="${pageContext.request.contextPath}/img/close.png" height="25px" style="margin-top: 28px;margin-left: 4px;" />
			</div>
			<div><span style="color: white;font-size: 22px;line-height: 80px;text-align: center;display: block;font-weight: bold;">我要报修</span></div>
		</div>
		<div style="margin-top: 10px;background-color: white;height: 100%;">
			<div>
				<div style="padding: 10px;overflow: hidden;border-bottom: solid #cccccc 1px;">
					<img src="${pageContext.request.contextPath}/img/u87.png" height="30px" style="float: left;"/>
					<span style="font-size: 18px;font-weight: bold;float: left;margin-top: 6px;margin-left: 10px;">请选择故障类型</span>
				</div>
				<div style="padding: 10px;overflow: hidden;border-bottom: solid #cccccc 1px;">
					<span style="font-size: 18px;float: left;margin-top: 4px;margin-left: 40px;">1.机器按了没反应</span>
				</div>
				<div style="padding: 10px;overflow: hidden;border-bottom: solid #cccccc 1px;">
					<span style="font-size: 18px;float: left;margin-top: 4px;margin-left: 40px;">2.网线坏了</span>
				</div>
				<div style="padding: 10px;overflow: hidden;border-bottom: solid #cccccc 1px;">
					<span style="font-size: 18px;float: left;margin-top: 4px;margin-left: 40px;">3.机器无法充电</span>
				</div>
				<div style="padding: 10px;overflow: hidden;border-bottom: solid #cccccc 1px;">
					<span style="font-size: 18px;float: left;margin-top: 4px;margin-left: 40px;">4.签到时显示一直连接或一直倒计时</span>
				</div>
				<div style="padding: 10px;overflow: hidden;border-bottom: solid #cccccc 1px;">
					<span style="font-size: 18px;float: left;margin-top: 4px;margin-left: 40px;">5.扫码没反应</span>
				</div>
				<div style="padding: 20px 10px;overflow: hidden;border-bottom: solid #cccccc 1px;">
					<span style="font-size: 18px;float: left;margin-top: 4px;margin-left: 40px;"><span><img src="${pageContext.request.contextPath}/img/problem.png" width="26px"/>&nbsp;<a href="#">以上问题都不是</a></span></span>
				</div>
			</div>
		</div>
	</body>
</html>
