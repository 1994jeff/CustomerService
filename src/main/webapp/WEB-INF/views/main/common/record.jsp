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
	.rightSpan{
	float: right;
	position: fixed;
	top: 30px;
	right: 10px;
	font-size: 18px;
	color: white;
	}
	.all{
	}
	.dialog{
		position:fixed;
		display: none;
		background-color: rgba(255,255,255,0.9);
		z-index: 1000;
		width: 100%;
		height: 100%;
	}
	.button-all{
		width: 200px;
		background-color: rgba(102, 153, 204, 1);
		padding: 20px;
		border-radius: 10px;
		margin: 0 auto;
		margin-top: 120px;
	}
	.button{
		display: block;
		text-align: center;
		font-size: 20px;
		background: white;
		color: rgba(102, 153, 204, 1);
		margin: 10px;
		padding: 10px;
		border-radius: 10px;
	}
	.button:HOVER {
		box-shadow:2px 4px black;	
	}
	</style>
	<body>
	<div class="dialog" >
		<div class="button-all">
			<span class="button showAll">全部显示</span>
			<span class="button showRepair">报修申请</span>
			<span class="button showBook">订纸申请</span>
		</div>
	</div>
	<div class="all">
		<div  style="height: 80px;background-color:rgba(102, 153, 204, 1);">
			<div style="float: left;position: fixed;z-index:100;">
				<img src="${pageContext.request.contextPath}/img/back.png" width="25px" height="25px" style="margin-top: 28px;margin-left: 6px;" onclick="backPage(-1)" />
				<img src="${pageContext.request.contextPath}/img/close.png" height="25px" style="margin-top: 28px;margin-left: 4px;"  onclick="closeWindow()"/>
			</div>
			<div class="title"><span style="color: white;font-size: 22px;line-height: 80px;text-align: center;display: block;font-weight: bold;">申请记录</span><span class="rightSpan">分类</span></div>
		</div>
		<div class="records" style="margin-top: 20px;background-color: white;">
			<c:forEach items="${records}" var="record">
		<c:if test="${ record.type==0 }">
			<div class="repair ch" data="${record.recordNo }"  inType="${ record.type}" style="width: 100%; height: 100%; background-color: white; padding: 10px; overflow: hidden;border-bottom: solid #ccc 1px;">
				<div
					style="float: left; width: 70px; padding: 6px 0px; border-right: solid #cccccc 1px;">
					<img src="${pageContext.request.contextPath}/img/u87.png"
						width="36px" style="margin-left: 13px;"><br /> <span
						style="margin-left: 16px;">报修</span>
				</div>
				<div style="padding-top: 6px; padding-left: 80px;">
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
		</c:if>
		<c:if test="${ record.type==1 }">
			<div class="bookPaper ch" data="${record.recordNo }" inType="${ record.type}" style="width: 100%; height: 100%; background-color: white; padding: 10px; overflow: hidden; border-bottom: solid #cccccc 1px;">
				<div
					style="float: left; width: 70px; padding: 6px 0px; border-right: solid #cccccc 1px;">
					<img src="${pageContext.request.contextPath}/img/u86.png"
						width="36px" style="margin-left: 13px;"><br /> <span
						style="margin-left: 16px;">订纸</span>
				</div>
				<div style="padding-top: 5px; padding-left: 80px;">
					<c:if test="${ record.status==0 }">
						<span>待处理</span>
						<br />
					</c:if>
					<c:if test="${ record.status==1 }">
						<span>已处理</span>
						<br />
					</c:if>
					<span>订纸数量:${ record.applyMobile }卷</span><br /> <span
						style="color: gray;">预计可使用至${ record.remark }</span>
				</div>
			</div>
		</c:if>
	</c:forEach>
		</div>
		</div>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
		<script type="text/javascript">
		
		$(function(){
			$('.rightSpan').on('click',function(){
				$('.dialog').css('display','block');
			});
			
			//点击跳转链接
			$('.records').children('div.ch').each(function(i){
				$(this).on('click',function(){
					var recordNo = $(this).attr('data');
					var type = $(this).attr('inType');
					if(type==0){
						//跳转报修
						window.location.href="${pageContext.request.contextPath}/repair/toRepairNofication.do?recordNo="+recordNo;
					}else if(type==1){
						//跳转订纸
						window.location.href="${pageContext.request.contextPath}/book/toBookNofication.do?recordNo="+recordNo;
					}
				});
			});
			
			//点击显示和隐藏相应申请记录
			$('.showAll').on('click',function(){
				$('.dialog').css('display','none');
				$('.records').children('div.ch').each(function(i){
					$(this).css('display','block');
				});
			});
			$('.showRepair').on('click',function(){
				$('.dialog').css('display','none');
				$('.records').children('div.repair').each(function(){
					$(this).css('display','block');
				});
				$('.records').children('div.bookPaper').each(function(){
					$(this).css('display','none');
				});
			});
			$('.showBook').on('click',function(){
				$('.dialog').css('display','none');
				$('.records').children('div.bookPaper').each(function(){
					$(this).css('display','block');
				});
				$('.records').children('div.repair').each(function(){
					$(this).css('display','none');
				});
			});
		});
		
		function backPage(num) {
			history.go(num);
		}
	</script>
	</body>

</html>