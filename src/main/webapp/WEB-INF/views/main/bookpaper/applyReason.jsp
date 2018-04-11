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
			<div style="float: left;position: fixed;">
				<img src="${pageContext.request.contextPath}/img/back.png" width="25px" height="25px" style="margin-top: 28px;margin-left: 6px;" onclick="backPage(-1)"/>
<%-- 				<img src="${pageContext.request.contextPath}/img/close.png" height="25px" style="margin-top: 28px;margin-left: 4px;" /> --%>
			</div>
			<div><span style="color: white;font-size: 22px;line-height: 80px;display:block;text-align:center;font-weight: bold;">申请原因</span></div>
		</div>
		<div style="margin-top: 10px;background-color: white;">
			<div style="overflow: hidden;border-bottom: solid #cccccc 1px;padding: 20px;">
				<span style="float: left;display: block;">卷纸遗失</span>
				<span style="float: right"><input type="checkbox" name="" id="forget" value="" class="checkBox"/></span>
			</div>
			<div style="padding: 20px;overflow: hidden;border-bottom: solid #cccccc 1px;">
				<span style="float: left;display: block;">卷纸受潮</span>
				<span style="float: right"><input type="checkbox" name="" id="dirty" value="" class="checkBox"/></span>
			</div>
			<div style="padding: 20px;overflow: hidden;border-bottom: solid #cccccc 1px;">
				<span style="float: left;display: block;">新活动即将上线</span>
				<span style="float: right"><input type="checkbox" name="" id="activity" value="" class="checkBox"/></span>
			</div>
			<div style="padding: 20px;overflow: hidden;border-bottom: solid #cccccc 1px;">
				<span style="float: left;display: block;">交易量暴增</span>
				<span style="float: right"><input type="checkbox" name="" id="more" value="" class="checkBox"/></span>
			</div>
			<div style="background-color: white;padding: 20px;margin-top: 0px;">
				其他原因:<input class="inText" type="text" placeholder="请输入描述内容"/>
			</div>
		</div>
		<div style="text-align: center;margin-top: 20px;" class="apply"><span style="display: block;color: rgba(102, 153, 204, 1);padding:10px 20px;border-radius: 30px;border: solid rgba(102, 153, 204, 1) 1px;width: 230px;margin:auto;">下一步</span></div>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
		<script type="text/javascript">
		function backPage(num) {
			history.go(num);
		}
			$(function(){
				$(".apply").on('click',function(){
					var forget='';
					var dirty='';
					var activity='';
					var more='';
					if($('#forget').prop('checked')){
						forget = '卷纸遗失,';
					}
					if($('#dirty').prop('checked')){
						dirty = '卷纸受潮,';
					}
					if($('#activity').prop('checked')){
						activity = '新活动即将上线,';
					}
					if($('#more').prop('checked')){
						more = '交易量暴增,';
					}
					var inText = $('.inText').val();
					var reason = forget+dirty+activity+more+inText;
					if(reason==''){
						alert('请选择或者填写原因！')
						return;
					}
					window.location.href="${pageContext.request.contextPath}/book/toBook.do?reason="+reason;
				});
			});
			
		</script>
	</body>
</html>
