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
	<style>
			/*垂直翻转图片*/
		.flipy {
			-moz-transform: scaleY(-1);
			-webkit-transform: scaleY(-1);
			-o-transform: scaleY(-1);
			transform: scaleY(-1);
			/*IE*/
			filter: FlipV;
			position: fixed;
			top: 118px;
		}
	</style>

	<body>
		<div style="height: 80px;background-color:rgba(102, 153, 204, 1);">
			<div style="float: left;position: fixed;">
				<img src="${pageContext.request.contextPath}/img/back.png" width="25px" height="25px" style="margin-top: 28px;margin-left: 6px;" />
				<img src="${pageContext.request.contextPath}/img/close.png" height="25px" style="margin-top: 28px;margin-left: 4px;" />
			</div>
			<div><span style="margin-left:10px;color: white;font-size: 22px;line-height: 80px;text-align: center;display: block;">机器按了没反应</span></div>
		</div>
		<div style="">
			<span style="display: block;
				text-align: center;padding: 10px;">请根据操作步骤解决</span>
		</div>
		<div style="background-color: white;width: 100%;">
			<div style="background-color: white;margin-left:48%;"><img src="${pageContext.request.contextPath}/img/u494.png" class="flipy" /></div>
			<div>
				<div style="padding-bottom: 10px;padding-left: 20px;padding-top: 16px;">
					<span style="background-color: red;color: white;padding:0px 2px; border-radius: 120px;">？</span>
					<span style="padding-left: 4px;font-weight: bold;">POS机开机后一直卡在某个画面不动</span>
				</div>
				<div style="padding-left: 50px;">
					<span>请按以下步骤操作:</span><br />
					<span>1.拔掉电源</span><br />
					<span>2.把机具后盖往下推,拔掉电池</span><br />
					<span>3.重新装入电池后开机</span><br />
				</div>
				<div style="padding-bottom: 10px;padding-left: 20px;padding-top: 16px;">
					<span style="background-color: red;color: white;padding:0px 2px; border-radius: 120px;">？</span>
					<span style="padding-left: 4px;font-weight: bold;">POS机开机后一直卡在交易成功界面或<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;结算界面</span>
				</div>
				<div style="padding-left: 50px;">
					<span>请按以下步骤操作:</span><br />
					<span>1.拔掉电源</span><br />
					<span>2.把机具后盖往下推,拔掉电池</span><br />
					<span>3.重新装入电池后开机</span><br />
				</div>
				<div style="padding-left: 30px;margin-top: 30px;color: gray;">
					<span>小E温馨提示：请及时进行日终结算</span>
				</div>
				<div style="padding:16px 30px;">
					<span>若未能帮您解决问题，请点击<a href="${pageContext.request.contextPath}/repair/toSelfRepair.do">自助报修</a></span>
				</div>
			</div>
			<div></div>
		</div>
	</body>

</html>