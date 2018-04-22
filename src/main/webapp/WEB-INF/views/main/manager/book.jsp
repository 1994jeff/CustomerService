<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订纸记录</title>
</head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/base.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/manager.css" />
<style>
</style>
<body style="">
	<div class="resultDialog">
		<h3 style="text-align: center;padding: 6px;background: gray;">处理结果</h3>
		<div class="diaBody">
				<div class="rejectDiv">
					<span style="float: left;">订纸关闭原因:</span>
					<div style="width:400px;overflow: auto;">
						<span class="closeRea"></span>
					</div>
					<span class="btn cancel" style="background: gray;">取消</span>
					<span class="btn cancel" style="background: #eded00 ;">确定</span>
				</div>
				<div style="width:400px;overflow: auto;" class="passDiv">
					<span style="float: left;" class="resultK"></span><br>
					<span style="float: left;" class="resultY"></span><br>
					<span style="float: left;" class="resultM"></span>元<br>
					<span style="float: left;" class="resultJ"></span>卷<br>
					<span class="btn cancel" style="background: gray;">取消</span>
					<span class="btn cancel" style="background: #eded00 ;">确定</span>
				</div>
		</div>
	</div>
	<div class="closeDialog">
		<h3 style="text-align: center;padding: 6px;background: gray;">关闭申请</h3>
		<div class="diaBody">
			<span style="float: left;">订纸关闭原因:</span>
			<textarea class="replyMsg" rows="6" cols="10"></textarea>
			<div style="width:400px;overflow: auto;">
				<span class="btn cancel" style="background: gray;">取消</span>
				<span class="btn sub" style="background: #eded00 ;">提交</span>
			</div>
		</div>
	</div>
	<div class="passDialog">
		<h3 style="text-align: center;padding: 6px;background: gray;">发货</h3>
		<div class="diaBody">
			<span style="float: left;">运单号	:</span>
			<input class="diaInput remark"/><br/><br/>
			<span style="float: left;">快递公司:</span>
			<input class="diaInput reason"/><br/><br/>
			<span style="float: left;">运			费:</span>
			<input class="diaInput type"/><br/><br/>
			<span style="float: left;">寄出卷纸:</span>
			<input class="diaInput goods"/><br/><br/>
			<div style="width:400px;overflow: auto;">
				<span class="btn cancel" style="background: gray;">取消</span>
				<span class="btn subPass" style="background: #eded00 ;">提交</span>
			</div>
		</div>
	</div>
	<div class="allBody" >
		<div
		style="padding: 20px; width: 1440px; text-align: left; margin-left: 120px; margin-top: 10px;">
		<input type="text" placeholder="请输入门店品牌搜索" class="shopBrand" /> <input type="text"
			placeholder="请输入门店名称搜索"  class="shopName"/> <span class="search"
			style="border-radius: 6px; padding: 10px 30px; background-color: #6495ED; color: white; font-weight: bold; font-size: 16px;">搜索</span>
		<a href="${pageContext.request.contextPath}/keyWord/toIndex.do"><span style="border-radius:6px;padding: 10px 30px;background-color: #6495ED;color: white;font-weight: bold;font-size: 16px;">菜单</span></a>
	</div>
	<div>
		<table class="table-cla">
			<tr class="tr-cla" style="background-color: #6495ED;">
				<td>排序</td>
				<td>订纸时间</td>
				<td>门店名称</td>
				<td>所属品牌</td>
				<td>联系人</td>
				<td>订纸数量</td>
				<td>收货地址</td>
				<td>状态</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${dtos}" var="shopDto" varStatus="v">
				<tr class="tr-cla" style="background-color: gray;">
					<td>${v.index+1}</td>
					<td><fmt:formatDate value="${shopDto.createTime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>${shopDto.shopName }</td>
					<td>${shopDto.shopBrand }</td>
					<td>${shopDto.contactName }<br/>${shopDto.contactMobile }</td>
					<td>${shopDto.bookNum }卷</td>
					<td>${shopDto.shopAddress }</td>
					<td><c:if test="${shopDto.bookStatus==0}">未处理</c:if>
					<c:if test="${shopDto.bookStatus==1}">
						<c:if test="${shopDto.resolveResult=='reject'}">已拒绝</c:if>
						<c:if test="${shopDto.resolveResult=='pass'}">已发货</c:if>
					</c:if></td>
					<td style="color: #6495ED;"><c:if test="${shopDto.bookStatus==0}"><span data="${shopDto.recordNo}" class="look">关闭</span><br /><span data="${shopDto.recordNo}" class="passGood">发货</span></c:if>
					<c:if test="${shopDto.bookStatus==1}"><span data="${shopDto.recordNo}" class="lookResult">查看</span><br /></c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
	<script type="text/javascript">
		$(function () {
			
			$('.search').on('click',function(){
				var shopName = $('.shopName').val();
				var shopBrand = $('.shopBrand').val();
				window.location.href="${pageContext.request.contextPath}/keyWord/toBook.do?shopName="+shopName+"&shopBrand="+shopBrand;
			});
			
			$('.cancel').on('click',function(){
				$(".closeDialog").css('display','none');
				$(".passDialog").css('display','none');
				$(".resultDialog").css('display','none');
				$(".allBody").css('display','block');
			});
			$('.sub').on('click',function(){
				var replyMsg = $('.replyMsg').val();
				var recordNo = $(this).attr('data');
				window.location.href="${pageContext.request.contextPath}/result/toCloseRecord.do?replyMsg="+replyMsg+"&recordNo="+recordNo;
			});
			$('.subPass').on('click',function(){
				var remark = $('.remark').val();
				var reason = $('.reason').val();
				var type = $('.type').val();
				var goods = $('.goods').val();
				var recordNo = $(this).attr('data');
				if(remark=='' || reason=='' || type=='' || goods=='' ){
					alert('请输入发货信息');
					return;
				}
				window.location.href="${pageContext.request.contextPath}/result/toPassRecord.do?remark="+remark+"&reason="+reason+"&type="+type+"&goods="+goods+"&recordNo="+recordNo;
			});
			
			$('.look').on('click',function(){
				$(".closeDialog").css('display','block');
				$(".allBody").css('display','none');
				var recordNo = $(this).attr('data');
				$('.sub').attr('data',recordNo);
			});
			$('.passGood').on('click',function(){
				$(".passDialog").css('display','block');
				$(".allBody").css('display','none');
				var recordNo = $(this).attr('data');
				$('.subPass').attr('data',recordNo);
			});
			$('.lookResult').on('click',function(){
				$(".resultDialog").css('display','block');
				$(".allBody").css('display','none');
				var recordNo = $(this).attr('data');
				postAjax(recordNo);
			});
		});
		
		function postAjax(recordNo){
			$.ajax({
				type : 'post',
				dataType : 'json',
				data : {
					'recordNo' : recordNo
				},
				url : '${pageContext.request.contextPath}/result/getResult.do',
				success:function(data){
					var obj = $.parseJSON(data);
					var retCode = obj.retCode;
					var retMsg = obj.retMsg;
					var retData = obj.retData;
					console.log(obj);
					if (retCode == 'success') {
						var result = retData[0];
						if(result.remark==''){
							$('.passDiv').css('display','none');
							$('.rejectDiv').css('display','block');
							$('.closeRea').text(result.replyMsg);
						}else{
							$('.rejectDiv').css('display','none');
							$('.passDiv').css('display','block');
							$('.resultK').text('发货快递:'+result.reason);
							$('.resultY').text('运单号:'+result.remark);
							$('.resultM').text('运费:'+result.type);
							$('.resultJ').text('卷纸:'+result.goods);
						}
					} else {
						alert(retMsg);
					}
				}
			});
		}
		
	</script>
</body>
</html>