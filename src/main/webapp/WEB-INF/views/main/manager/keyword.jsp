<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css" />
	<style>
	.table-cla {
		margin-left: 130px;
	}
	
	.table-cla tr {
		text-align: center;
	}
	
	.tr-cla {
		
	}
	
	.tr-cla td {
		padding: 10px 20px;
		color: white;
		border: solid white 1px;
	}
	
	input {
		padding: 10px;
		border-radius: 6px;
	}
	</style>
	<body style="">
		<div style="padding: 20px;width: 1440px;text-align: left;margin-left:120px;margin-top: 10px;">
			<input type="text" class="searchKey" placeholder="请输入关键词搜索" />
			<span class="searchKeyWord" style="border-radius:6px;padding: 10px 30px;background-color: #6495ED;color: white;font-weight: bold;font-size: 16px;">搜索</span>
			<a href="${pageContext.request.contextPath}/keyWord/toIndex.do"><span style="border-radius:6px;padding: 10px 30px;background-color: #6495ED;color: white;font-weight: bold;font-size: 16px;">菜单</span></a>
		</div>
		<div style="padding:30px 20px;width: 100%;height:100px;text-align: left;margin-left:120px;margin-top: -10px;">
			<input class="keyWord" type="text" placeholder="请输入关键词" />
			<input class="replyMsg" type="text" placeholder="请输入微信自动回复内容" />
			<span class="addKeyWord" style="border-radius:6px;padding: 10px 30px;background-color: #6495ED;color: white;font-weight: bold;font-size: 16px;margin: 10px;">添加关键词</span>
			<c:if test="${msg==null || msg==''}"></c:if><c:if test="${msg!=null && msg!=''}"><span style="border-radius:6px;padding: 10px 30px;background-color: #2f3c52;color: white;font-weight: bold;font-size: 16px;margin: 10px;">提示：${msg}</span></c:if>
		</div>
		<div>
			<table class="table-cla">
				<tr class="tr-cla" style="background-color: #6495ED;">
					<td>排序</td>
					<td>创建时间</td>
					<td>关键词</td>
					<td>微信回复</td>
					<td>状态</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${list}" var="keyW" varStatus="v">
					<tr class="tr-cla" style="background-color: gray;">
						<td>${v.index+1 }</td>
						<td><fmt:formatDate value="${keyW.createTime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>${keyW.keyWord }</td>
						<td>${keyW.reply }</td>
						<td><c:if test="${keyW.status==0}">已关闭</c:if><c:if test="${keyW.status==1}">使用中</c:if></td>
						<td style="color:#6495ED;"><c:if test="${keyW.status==0}"><a href="${pageContext.request.contextPath}/keyWord/toUpdateKeyWord.do?keyWordNo=${keyW.keyWordNo}&status=1">启用</a><br/></c:if>
						<c:if test="${keyW.status==1}"><a href="${pageContext.request.contextPath}/keyWord/toUpdateKeyWord.do?keyWordNo=${keyW.keyWordNo}&status=0">关闭</a><br/></c:if>
						<a href="${pageContext.request.contextPath}/keyWord/toDeleteKeyWord.do?keyWordNo=${keyW.keyWordNo}">删除</a></td>
					</tr>
				</c:forEach>
				<c:if test="${list==null }">
					<tr class="tr-cla" style="background-color: gray;">
						<td colspan="6">暂无信息</td>
					</tr>
				</c:if>
			</table>
		</div>
		</div>	
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
		<script type="text/javascript">
			$(function () {
				
				$('.addKeyWord').on('click',function(){
					var keyWord = $('.keyWord').val();
					var replyMsg = $('.replyMsg').val();
					if(keyWord==""){
						alert("请输入关键词!");
						return;
					}
					if(replyMsg==""){
						alert("请输入自动回复消息");
						return;
					}
					window.location.href="${pageContext.request.contextPath}/keyWord/toKeyWord.do?keyWord="+keyWord+"&replyMsg="+replyMsg+"&type=1";
				});
				
				$('.searchKeyWord').on('click',function(){
					var keyWord = $('.searchKey').val();
					window.location.href="${pageContext.request.contextPath}/keyWord/toKeyWord.do?keyWord="+keyWord;
				});
			});
		</script>
	</body>
</html>