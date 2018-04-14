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
				width="25px" height="25px" onclick="backPage(-1)"
				style="margin-top: 28px; margin-left: 6px;" />
<%-- 		<img src="${pageContext.request.contextPath}/img/close.png" height="25px" style="margin-top: 28px; margin-left: 4px;" /> --%>
		</div>
		<div>
			<span
				style="margin-left: 10px; color: white; font-size: 22px; line-height: 80px; text-align: center; display: block;">自助报修</span>
		</div>
		<div>
			<c:if test="${shop!=null}">
				<div class="card">
					<div style="float: left;">
						<img src="${pageContext.request.contextPath}/img/u161.png"
							width="40px" style="padding: 20px;" />
					</div>
					<div style="padding-bottom: 20px; padding-left: 80px;">
						<br />
						<span
							style="color: cornflowerblue; font-size: 16px; line-height: 20px;">${shop.name}</span><br />
						<span>门店电话:${shop.remark }</span><span
							style="float: right; margin-right: 4px; color: gray;"><a href="${pageContext.request.contextPath}/userBinding/toBindShop.do">我换店了></a></span><br />
						<span>门店地址:${shop.address }</span><br />
					</div>
				</div>
			</c:if>
			<c:if test="${user!=null }">
				<div class="card">
					<div style="float: left;">
						<img src="${pageContext.request.contextPath}/img/u411.png"
							width="50px" style="padding: 20px;" />
					</div>
					<div style="float: left;">
						<br />
						<span
							style="color: cornflowerblue; font-size: 16px; line-height: 30px;">申请人：${user.name}</span><br />
						<span>联系电话:${user.remark }</span><br />
					</div>
				</div>
			</c:if>
		</div>
		<div style="text-align: center; padding: 10px;">
			--<span style="color: dodgerblue; font-weight: bold;">报修信息</span>--
		</div>
		<div style="background-color: white; padding: 20px; margin-top: 10px;">
			故障描述:<input class="inText" type="text" placeholder="请输入描述内容"  name="remark" id="remark"/>
		</div>
		<div style="text-align: center; margin-top: 20px;">
			<span class="apply"
				style="display: block; color: cornflowerblue; padding: 10px 20px; border-radius: 30px; border: solid cornflowerblue 1px; width: 230px; margin: auto;" onclick="${pageContext.request.contextPath}/repair/toRepairNofication.do">确定申请报修</span>
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
	<script type="text/javascript">
	function backPage(num) {
		history.go(num);
	}
	
	$(function(){
		$('.apply').on('click',function(){
			toApply();
		});
	});
	
	function toApply(){
		var name = $('#remark').val();
		if(''==name){
			alert('请输入描述内容！');
			return;
		}
		window.location.href="${pageContext.request.contextPath}/repair/toRepairNofication.do?name="+name;

// 		$.ajax({
// 			type:'post',
// 			data:{
// 				'name':name
// 			},
// 			dataType:'json',
// 			url:'${pageContext.request.contextPath}/repair/toApplyRepair.do',
// 			success:function(data){
// 				var obj = $.parseJSON(data)
// 				var code = obj.retCode;
// 				var msg = obj.retMsg;
// 				if(code=='success'){
// 					window.location.href="${pageContext.request.contextPath}/repair/toRepairNofication.do";
// 				}else if(code=='failed'){
// 					alert(msg+'！');
// 				}else{
// 					alert('Error, please try again！');
// 				}
// 			},
// 			error:function(){
// 				alert('Error, please try again！');
// 			}
// 		});
	}
	</script>
</body>
</html>
