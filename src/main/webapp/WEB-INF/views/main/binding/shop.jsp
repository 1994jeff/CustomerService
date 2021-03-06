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
			<div style="float: left;position: fixed;z-index:100;">
				<img src="${pageContext.request.contextPath}/img/back.png" width="25px" height="25px" style="margin-top: 28px;margin-left: 6px;" onclick="backPage(-1)" />
<%-- 				<img src="${pageContext.request.contextPath}/img/close.png" height="25px" style="margin-top: 28px;margin-left: 4px;" /> --%>
			</div>
			<div class="title"><span style="margin-left:10px;color: white;font-size: 22px;line-height: 80px;text-align: center;display: block;">门店绑定</span></div>
		</div>
		<div style="margin-top: 10px;background-color: white;overflow: hidden;">
			<div>
				<div style="padding: 10px;overflow: hidden;border-bottom: solid #cccccc 1px;">
					<span style="float: left;margin-left: 10px;"><img src="${pageContext.request.contextPath}/img/u135.png" width="40px"/></span>
					<span style="float: right;width: 220px;margin-right: 30px;"><input class="inText" id="posId" placeholder="请注册您门店POS机终端号"/></span>
				</div>
			</div>
			<div>
				<div style="padding:10px;overflow: hidden;border-bottom: solid #cccccc 1px;">
					<span style="float: left;margin-left: 10px;"><img src="${pageContext.request.contextPath}/img/u144.png" width="40px"/></span>
					<span style="float: right;width: 220px;margin-right: 30px;"><input class="inText"  id="employee" placeholder="请注册操作员号信息"/></span>
				</div>
			</div>
			<div>
				<div style="padding:10px;overflow: hidden;border-bottom: solid #cccccc 1px;">
					<span style="float: left;margin-left: 10px;"><img src="${pageContext.request.contextPath}/img/u145.png" width="40px"/></span>
					<span style="float: right;width: 220px;margin-right: 30px;"><input class="inText"  id="brand" type="text" placeholder="请注册门店品牌"/></span>
				</div>
			</div>
			<div>
				<div style="padding:10px;overflow: hidden;border-bottom: solid #cccccc 1px;">
					<span style="float: left;margin-left: 10px;"><img src="${pageContext.request.contextPath}/img/u145.png" width="40px"/></span>
					<span style="float: right;width: 220px;margin-right: 30px;"><input class="inText" id="name" type="text" placeholder="请注册门店名称"/></span>
				</div>
			</div>
			<div>
				<div style="padding:10px;overflow: hidden;border-bottom: solid #cccccc 1px;">
					<span style="float: left;margin-left: 10px;"><img src="${pageContext.request.contextPath}/img/u145.png" width="40px"/></span>
					<span style="float: right;width: 220px;margin-right: 30px;"><input class="inText"  id="remark" type="text" placeholder="请注册门店电话"/></span>
				</div>
			</div>
			<div>
				<div style="padding:10px;overflow: hidden;border-bottom: solid #cccccc 1px;">
					<span style="float: left;margin-left: 10px;"><img src="${pageContext.request.contextPath}/img/u145.png" width="40px"/></span>
					<span style="float: right;width: 220px;margin-right: 30px;"><input class="inText"  id="address" type="text" placeholder="请注册门店地址"/></span>
				</div>
			</div>
			<div>
				<div style="padding:10px;overflow: hidden;border-bottom: solid #cccccc 1px;">
					<span style="float: left;margin-left: 10px;"><img src="${pageContext.request.contextPath}/img/u145.png" width="40px"/></span>
					<span style="float: right;width: 220px;margin-right: 30px;"><input class="inText"  id="employeePsd" type="password" placeholder="请注册操作员密码"/></span>
				</div>
			</div>
		</div>
		<div style="text-align: center;margin-top: 20px;" onclick="registerShop()"><span style="display: block;color: cornflowerblue;padding:10px 20px;border-radius: 30px;border: solid cornflowerblue 1px;width: 230px;margin:auto;">下一步</span></div>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
		<script type="text/javascript">
		function backPage(num) {
			history.go(num);
		}
		function registerShop() {
			var posId = $('#posId').val();
			var name = $('#name').val();
			var brand = $('#brand').val();
			var address = $('#address').val();
			var employee = $('#employee').val();
			var employeePsd = $('#employeePsd').val();
			var remark = $('#remark').val();
			if(posId==''){alert("POS机号不能为空!");return;}
			if(name==''){alert("门店名不能为空!");return;}
			if(brand==''){alert("门店品牌不能为空!");return;}
			if(address==''){alert("门店地址不能为空!");return;}
			if(employee==''){alert("操作员账号不能为空!");return;}
			if(employeePsd==''){alert("操作员密码不能为空!");return;}
			if(remark==''){alert("门店电话不能为空!");return;}
			window.location.href='${pageContext.request.contextPath}/userBinding/bindShop.do?posNo='+posId+'&name='+name+'&brand='+brand
					+'&address='+address+'&employee='+employee+'&employeePsd='+employeePsd+'&remark='+remark;
		}
		</script>
	</body>
</html>
