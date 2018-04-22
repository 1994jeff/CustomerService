<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>报修记录</title>
	</head>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/manager.css" />
	<style>
	</style>
	<body style="">
	<div class="resultDialog">
		<h3 style="text-align: center;padding: 6px;background: gray;">处理结果</h3>
		<div class="diaBody">
				<div class="rejectDiv">
					<span class="diaTitle" style="float: left;"></span>
					<div style="width:400px;overflow: auto;">
						<span class="closeRea"></span>
					</div>
					<span class="btn cancel" style="background: gray;">取消</span>
					<span class="btn cancel" style="background: #eded00 ;">确定</span>
				</div>
				<div style="width:400px;overflow: auto;" class="passDiv">
					<span style="float: left;" class="resultK"></span><br>
					<span style="float: left;" class="resultY"></span><br>
					<span style="float: left;" class="resultM"></span><br>
					<span style="float: left;" class="resultJ"></span><br>
					<span class="btn cancel" style="background: gray;">取消</span>
					<span class="btn cancel" style="background: #eded00 ;">确定</span>
				</div>
		</div>
	</div>
	<div class="closeDialog">
		<h3 style="text-align: center;padding: 6px;background: gray;">关闭报修申请</h3>
		<div class="diaBody">
			<span style="float: left;">报修关闭原因:</span>
			<textarea class="replyMsg" rows="6" cols="10"></textarea>
			<div style="width:400px;overflow: auto;">
				<span class="btn cancel" style="background: gray;">取消</span>
				<span class="btn sub" style="background: #eded00 ;">提交</span>
			</div>
		</div>
	</div>
	<div class="passDialog" style="height: 380px;">
		<h3 style="text-align: center;padding: 6px;background: gray;">操作记录</h3>
		<div class="diaBody">
			<div>预计处理方式:
				<select class="sel" style="float: right;margin-right: 100px;width: 200px;">
					<option value="pass" selected="selected">快递维修</option>
					<option value="go">上门维修</option>
					<option value="call">电话沟通</option>
				</select>
			</div><br/>
			<div class="passD" >
				<div>寄出部件:
				<input class="goods1" style="float: right;margin-right: 100px;width: 200px;padding: 0px;border-radius: 0px;">
				</div><br/>
				<div>运单号:
				<input class="remark1" style="float: right;margin-right: 100px;width: 200px;padding: 0px;border-radius: 0px;">
				</div><br/>
				<div>快递公司:
				<input  class="reason1" style="float: right;margin-right: 100px;width: 200px;padding: 0px;border-radius: 0px;">
				</div><br/>
				<div>最晚寄出时间:
				<input  class="resolveTime1" type="date" style="float: right;margin-right: 100px;width: 200px;padding: 0px;border-radius: 0px;">
				</div><br/>
				<div>微信推送消息:
				<input  class="replyMsg1" style="float: right;margin-right: 100px;width: 200px;padding: 0px;border-radius: 0px;">
				</div><br/>
			</div>
			<div class="goD" style="display: none;">
				<div>最晚上门时间:
				<input   class="resolveTime2" type="date" style="float: right;margin-right: 100px;width: 200px;padding: 0px;border-radius: 0px;">
				</div><br/>
				<div>微信推送消息:
				<input  class="replyMsg2" style="float: right;margin-right: 100px;width: 200px;padding: 0px;border-radius: 0px;">
				</div><br/>
			</div>
			<div class="callD"  style="display: none;">
				<div>最晚沟通时间:
				<input   class="resolveTime3" type="date" style="float: right;margin-right: 100px;width: 200px;padding: 0px;border-radius: 0px;">
				</div><br/>
				<div>微信推送消息:
				<input  class="replyMsg3" style="float: right;margin-right: 100px;width: 200px;padding: 0px;border-radius: 0px;">
				</div><br/>
			</div>			
			<div style="width:400px;overflow: auto;">
				<span class="btn cancel" style="background: gray;">取消</span>
				<span class="btn subPass" style="background: #eded00 ;">提交</span>
			</div>
		</div>
	</div>
		<div class="allBody">
			<div style="padding: 20px;width: 1440px;text-align: left;margin-left:120px;margin-top: 10px;">
				<input class="shopBrand" type="text" placeholder="请输入门店品牌搜索" />
				<input class="shopName" type="text" placeholder="请输入门店名称搜索" />
				<span class="search" style="border-radius:6px;padding: 10px 30px;background-color: #6495ED;color: white;font-weight: bold;font-size: 16px;">搜索</span>
				<a href="${pageContext.request.contextPath}/keyWord/toIndex.do"><span style="border-radius:6px;padding: 10px 30px;background-color: #6495ED;color: white;font-weight: bold;font-size: 16px;">菜单</span></a>
			</div>
			<div>
				<table class="table-cla">
					<tr class="tr-cla" style="background-color: #6495ED;">
						<td>排序</td>
						<td>报修时间</td>
						<td>门店名称</td>
						<td>所属品牌</td>
						<td>联系人</td>
						<td>收货地址</td>
						<td>故障描述</td>
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
							<td>${shopDto.shopAddress }</td>
							<td>${shopDto.reason }</td>
							<td><c:if test="${shopDto.bookStatus==0}">未处理</c:if><c:if test="${shopDto.bookStatus==1}">已处理</c:if></td>
							<td style="color: #6495ED;"><c:if test="${shopDto.bookStatus==0}"><span data="${shopDto.recordNo}" class="look">关闭</span><br /><span data="${shopDto.recordNo}" class="passGood">处理</span></c:if>
							<c:if test="${shopDto.bookStatus==1}"><span data="${shopDto.recordNo}" class="lookResult">查看</span></c:if>
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
					window.location.href="${pageContext.request.contextPath}/keyWord/toRepair.do?shopName="+shopName+"&shopBrand="+shopBrand;
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
					window.location.href="${pageContext.request.contextPath}/result/toCloseRepairRecord.do?replyMsg="+replyMsg+"&recordNo="+recordNo;
				});
				$('.subPass').on('click',function(){
					var recordNo = $(this).attr('data');
					var sel = $('.sel').val();
					if(sel=='pass'){
						var goods = $('.goods1').val();
						var remark = $('.remark1').val();
						var reason = $('.reason1').val();
						var resolveTime = $('.resolveTime1').val();
						var replyMsg = $('.replyMsg1').val();
						if(goods=='' ||remark=='' ||reason=='' ||resolveTime=='' ||replyMsg==''){
							alert('信息不能为空!');
							return;
						}
						if(!checkEndTime(resolveTime)){
							alert('请选择正确的日期!');
							return;
						}
						window.location.href="${pageContext.request.contextPath}/result/toPassRepairRecord.do?remark="+remark+"&reason="+reason+"&type="+sel+"&goods="+goods+"&recordNo="+recordNo+"&resolveTime="+resolveTime+"&replyMsg="+replyMsg;
					}else if(sel=='go'){
						var resolveTime = $('.resolveTime2').val();
						var replyMsg = $('.replyMsg2').val();
						if(resolveTime=='' ||replyMsg==''){
							alert('信息不能为空!');
							return;
						}
						if(!checkEndTime(resolveTime)){
							alert('请选择正确的日期!');
							return;
						}
						window.location.href="${pageContext.request.contextPath}/result/toPassRepairRecord.do?recordNo="+recordNo+"&type="+sel+"&resolveTime="+resolveTime+"&replyMsg="+replyMsg;
					}else if(sel=='call'){
						var resolveTime = $('.resolveTime3').val();
						var replyMsg = $('.replyMsg3').val();
						if(resolveTime=='' ||replyMsg==''){
							alert('信息不能为空!');
							return;
						}
						if(!checkEndTime(resolveTime)){
							alert('请选择正确的日期!');
							return;
						}
						window.location.href="${pageContext.request.contextPath}/result/toPassRepairRecord.do?recordNo="+recordNo+"&type="+sel+"&resolveTime="+resolveTime+"&replyMsg="+replyMsg;
					}
					//window.location.href="${pageContext.request.contextPath}/result/toPassRecord.do?remark="+remark+"&reason="+reason+"&type="+type+"&goods="+goods+"&recordNo="+recordNo;
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
				
				$('.sel').on('change',function(){
					var sel = $(this).val();
					if(sel=='pass'){
						$(".goD").css('display','none');
						$(".callD").css('display','none');
						$(".passD").css('display','block');
					}else if(sel=='go'){
						$(".callD").css('display','none');
						$(".passD").css('display','none');
						$(".goD").css('display','block');
					}else if(sel=='call'){
						$(".goD").css('display','none');
						$(".passD").css('display','none');
						$(".callD").css('display','block');
					}
				});
				
			});

		    function checkEndTime(endTime){  
		        var start=new Date();  
		        var end=new Date(endTime.replace("-", "/").replace("-", "/"));  
		        if(end<=start){  
		            return false;  
		        }  
		        return true;  
		    } 
			
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
							if(result.type=='go' || result.type=='call'){
								$('.passDiv').css('display','none');
								$('.rejectDiv').css('display','block');
								$('.closeRea').text(result.replyMsg);
								var ty = '';
								if(result.type=='go'){
									ty = '上门维修';
								}
								if(result.type=='call'){
									ty = '电话沟通';
								}
								$('.diaTitle').text('处理方式:'+ty);
							}else if(result.type=='pass'){
								$('.rejectDiv').css('display','none');
								$('.passDiv').css('display','block');
								$('.resultK').text('发货快递:'+result.reason);
								$('.resultY').text('运单号:'+result.remark);
								$('.resultM').text('预计时间:'+result.resolveTime);
								$('.resultJ').text('寄出物件:'+result.goods);
							}else if(result.type=='reject' ){
								$('.passDiv').css('display','none');
								$('.rejectDiv').css('display','block');
								$('.closeRea').text(result.replyMsg);
								$('.diaTitle').text('报修关闭原因:');
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