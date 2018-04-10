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
	<style>.pass {
	text-align: left;
	padding: 10px;
	display: block;
	height: 300px;
}
.title{
	position: fixed;
	z-index: 99;
	background: rgba(102, 153, 204, 1);
	width: 100%;
	}
.reject {
	display: block;
	text-align: left;
	padding: 10px;
	height: 300px;
}</style>
	<body>
		<div style="height: 80px;background-color:rgba(102, 153, 204, 1);">
			<div style="float: left;position: fixed;z-index:100;">
				<img src="${pageContext.request.contextPath}/img/back.png" width="25px" height="25px" style="margin-top: 28px;margin-left: 6px;" onclick="backPage(-1)"/>
				<img src="${pageContext.request.contextPath}/img/close.png" height="25px" style="margin-top: 28px;margin-left: 4px;" />
			</div>
			<div class="title"><span style="color: white;font-size: 22px;line-height: 80px;display:block;text-align:center;font-weight: bold;">我要订纸</span></div>
		</div>
		<div>
			<c:if test="${shop!=null }">
				<div class="card">
					<div style="float:left;">
						<img src="${pageContext.request.contextPath}/img/u161.png" width="40px" style="padding: 20px;"/>
					</div>
					<div style="padding-bottom: 20px;padding-left: 80px;">
						<br/><span style="color: cornflowerblue;font-size: 16px;line-height: 20px;">${shop.name }</span><br />
						<span>门店电话:${shop.remark}</span><span style="float: right;margin-right: 4px;color:gray;">我换店了>></span><br />
						<span>门店地址:${shop.address}</span><br />
					</div>
				</div>
			</c:if>
		</div>
		<div style="background-color: white;margin-top: 10px;overflow: hidden;">
			<c:if test="${days==null}">
				<div class="pass">
					<img src="${pageContext.request.contextPath}/img/u172.png" width="60px" style="margin-left: 30px;margin-top: 10px;margin-bottom: 10px;float: left;margin-right: 20px;"/>
					<span style="display: block;line-height: 40px;font-size: 22px;margin-top: 20px;">您符合订纸条件</span>
					<span style="margin-left: 30px;line-height: 30px;">本次发放数量</span><br />
					<span style="color:rgba(102, 153, 204, 1);font-size: 50px;display: block;text-align:center;font-weight: bold;">30卷</span>
					<span style="color:rgba(102, 153, 204, 1);display: block;text-align: center;">预计使用期限：30天</span>
					<a href="${pageContext.request.contextPath}/book/toBook.do"><span style="color:rgba(102, 153, 204, 1);display: block;border-radius: 30px;border: solid rgba(102,153,204,1) 1px;width: 120px;padding: 20px;text-align: center;margin:  0px auto;margin-top: 20px;">去订纸</span></a>
				</div>
			</c:if>
			<c:if test="${days!=null}">
				<div class="reject">
					<img src="${pageContext.request.contextPath}/img/u187.png" width="60px" style="margin-left: 30px;margin-top: 10px;margin-bottom: 10px;float: left;margin-right: 10px;"/>
					<span style="display: block;line-height: 40px;font-size: 22px;margin-top: 20px;">您不符合订纸条件</span>
					<span style="margin-left: 20px;line-height: 30px;">小E有点傻，别骗我~</span><br />
					<span style="display: block;text-align:center;line-height: 30px;">根据预估您的卷纸还有剩余喔~</span><br />
					<div>
						<div style="width: 100%;text-align: left;">
							<span style="display:block;text-align:center;width:100%;"><b style="text-align: center;background-color: #555555;padding-right: 6px;padding-left: 6px;color: white;font-weight: bold;border-radius: 10px;margin-right: 4px;">!</b>预估剩余15卷</span>
						</div>
						<span style="display: block;text-align: center;">预估剩余使用期限:${days}天</span>
					</div>
					<a href="${pageContext.request.contextPath}/book/toBook.do"><span style="color:rgba(102, 153, 204, 1);display: block;border-radius: 30px;border: solid rgba(102,153,204,1) 1px;width: 220px;padding: 20px;text-align: center;margin:  0px auto;margin-top: 20px;">小E你错了，我是真没纸了</span></a>
				</div>
			</c:if>
		</div>
		<script type="text/javascript">
		function backPage(num) {
			history.go(num);
		}
		</script>
	</body>
</html>
