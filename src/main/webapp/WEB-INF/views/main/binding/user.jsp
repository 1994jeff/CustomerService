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
		.inText {
	padding: 10px;
	background-color: white;
	border: 0px;
	font-size: 18px;
	padding-right: 20px;
}
	</style>
	<body>
		<div style="height: 80px;background-color:rgba(102, 153, 204, 1);">
			<div style="float: left;position: fixed;">
				<img src="${pageContext.request.contextPath}/img/back.png" width="25px" height="25px" style="margin-top: 28px;margin-left: 6px;" onclick="backPage(-1)"/>
				<img src="${pageContext.request.contextPath}/img/close.png" height="25px" style="margin-top: 28px;margin-left: 4px;" />
			</div>
			<div><span style="margin-left:10px;color: white;font-size: 22px;line-height: 80px;text-align: center;display: block;">用户绑定</span></div>
		</div>
		<div style="margin-top: 10px;background-color: white;overflow: hidden;">
			<div>
				<div style="padding: 10px;overflow: hidden;border-bottom: solid #cccccc 1px;">
					<span style="float: left;margin-left: 10px;"><img src="${pageContext.request.contextPath}/img/u135.png" width="40px"/></span>
					<span style="float: right;width: 220px;margin-right: 30px;"><input data="${openId}" class="inText" id="name" placeholder="请输入您的姓名"/></span>
				</div>
			</div>
			<div>
				<div style="padding:10px;overflow: hidden;border-bottom: solid #cccccc 1px;">
					<span style="float: left;margin-left: 10px;"><img src="${pageContext.request.contextPath}/img/u144.png" width="40px"/></span>
					<span style="float: right;width: 220px;margin-right: 30px;"><input class="inText" id="remark"  placeholder="请输入您的联系电话"/></span>
				</div>
			</div>
			<div>
				<div style="padding:10px;overflow: hidden;border-bottom: solid #cccccc 1px;">
					<span style="float: left;margin-left: 10px;"><img src="${pageContext.request.contextPath}/img/u145.png" width="40px"/></span>
					<span style="float: right;width: 220px;margin-right: 30px;"><input class="inText" id="address"  type="text" placeholder="请输入您的收货地址"/></span>
				</div>
			</div>
		</div>
		<div style="text-align: center;margin-top: 20px;"><span class="btn" style="display: block;color: cornflowerblue;padding:10px 20px;border-radius: 30px;border: solid cornflowerblue 1px;width: 230px;margin:auto;">下一步</span></div>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
		<script type="text/javascript">
			$(function(){
				$('.btn').on('click',function(){
					var openId = $('#name').attr('data');
					var name = $('#name').val();
					var remark = $('#remark').val();
					var address = $('#address').val();
					if(openId=="" ){
						alert("获取您的openId失败，请从菜单或者客服消息中进入进入绑定界面!");
						return;
					}
					if(name==''||remark==''||address==''){
						alert('您的信息不能为空!');
						return;
					}
					window.location.href="${pageContext.request.contextPath}/userBinding/bindUser.do?name="+name+"&remark="+remark+"&address="+address+"&openId="+openId;
				});
			});
			
			function backPage(num) {
				history.go(num);
			}
		</script>
	</body>
</html>
