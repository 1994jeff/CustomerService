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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/js/base.js" />
	<body>
		<div style="height: 80px;background-color:rgba(102, 153, 204, 1);">
			<div style="float: left;position: fixed;z-index:100;">
				<img src="${pageContext.request.contextPath}/img/back.png" width="25px" height="25px" style="margin-top: 28px;margin-left: 6px;" onclick="backPage(-1)"/>
<%-- 				<img src="${pageContext.request.contextPath}/img/close.png" height="25px" style="margin-top: 28px;margin-left: 4px;" /> --%>
			</div>
			<div class="title"><span style="color: white;font-size: 22px;line-height: 80px;font-weight: bold;display: block;text-align: center;">订纸申请</span></div>
		</div>
		<div>
			<div style="text-align: center;padding: 10px;">
				--<span style="color: rgba(102, 153, 204, 1);">配送信息</span>--
			</div>
			<div class="card">
				<div style="float:left;">
					<img src="${pageContext.request.contextPath}/img/u223.png" width="30px" style="padding: 30px;padding-right: 10px;padding-left: 25px;"/>
				</div>
				<div style="padding-bottom: 20px;padding-left: 80px;">
					<br/><span style="font-size: 16px;line-height: 20px;">${user.name }</span><br />
					<span>${user.remark}</span><br />
					<span>${user.address}</span><br />
				</div>
			</div>
			<div style="text-align: center;padding: 10px;">
				--<span style="color: rgba(102, 153, 204, 1);">订纸信息</span>--
			</div>
			<div style="background-color: white;margin-top: 10px;">
				<div style="padding: 20px;overflow: hidden;border-bottom: solid #cccccc 1px;">
					<span style="float: left;">申请门店:</span>
					<span style="float: right">${shop.name }</span>
				</div>
				<div style="padding: 20px;overflow: hidden;border-bottom: solid #cccccc 1px;">
					<span style="float: left;">订纸数量:</span>
					<span style="float: right"><b class="bookNum">30</b>卷</span>
				</div>
				<div style="padding: 20px;overflow: hidden;border-bottom: solid #cccccc 1px;">
					<span style="float: left;">预计使用期限:</span>
					<span style="float: right">自申请之日起30天</span>
				</div>
			</div>
			<div style="text-align: center;margin-top: 20px;" onclick="book()"><span style="display: block;color: rgba(102, 153, 204, 1);padding:10px 20px;border-radius: 30px;border: solid rgba(102, 153, 204, 1) 1px;width: 230px;margin:auto;">确定申请订纸</span></div>
		</div>
		<script type="text/javascript">
		function backPage(num) {
			history.go(num);
		}
		function book() {
			var num = $('.bookNum').text();
			if(num==''){
				alert('预定数量不能为空！'+num);
				return;
			}
			window.location.href="${pageContext.request.contextPath}/book/toBookNofication.do?num="+num;
		}
		</script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
	</body>
</html>
