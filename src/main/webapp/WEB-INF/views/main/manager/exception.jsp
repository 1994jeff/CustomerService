<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>异常订纸申请</title>
	</head>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/manager.css" />
	<style>
	</style>
	<body style="">
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
					<td>订纸原因</td>
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
						<td>${shopDto.reason }</td>
						<td><c:if test="${shopDto.bookStatus==0}">未处理</c:if><c:if test="${shopDto.bookStatus==1}">已处理</c:if></td>
						<td style="color: #6495ED;"><a>查看</a><c:if test="${shopDto.bookStatus==0}"><br /><a>发货</a></c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		</div>	
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
		<script type="text/javascript">
			$(function () {
				
				$('.search').on('click',function(){
					var shopName = $('.shopName').val();
					var shopBrand = $('.shopBrand').val();
					window.location.href="${pageContext.request.contextPath}/keyWord/toException.do?shopName="+shopName+"&shopBrand="+shopBrand;
				});
				
			});
		</script>
	</body>
</html>