<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
	<link rel="stylesheet" href="../../css/base.css" />
	<style>
		/*åç´ç¿»è½¬*/
		
		.flipy {
			-moz-transform: scaleY(-1);
			-webkit-transform: scaleY(-1);
			-o-transform: scaleY(-1);
			transform: scaleY(-1);
			/*IE*/
			filter: FlipV;
			position: fixed;
			top: 118px;
		}
	</style>

	<body>
		<div style="height: 80px;background-color:rgba(102, 153, 204, 1);">
			<div style="float: left;position: fixed;">
				<img src="../../img/back.png" width="25px" height="25px" style="margin-top: 28px;margin-left: 6px;" />
				<img src="../../img/close.png" height="25px" style="margin-top: 28px;margin-left: 4px;" />
			</div>
			<div><span style="margin-left:10px;color: white;font-size: 22px;line-height: 80px;text-align: center;display: block;">æºå¨æäºæ²¡ååº</span></div>
		</div>
		<div style="">
			<span style="display: block;
				text-align: center;padding: 10px;">è¯·æ ¹æ®æä½æ­¥éª¤è§£å³</span>
		</div>
		<div style="background-color: white;width: 100%;">
			<div style="background-color: white;margin-left:48%;"><img src="../../img/u494.png" class="flipy" /></div>
			<div>
				<div style="padding-bottom: 10px;padding-left: 20px;padding-top: 16px;">
					<span style="background-color: red;color: white;padding:0px 2px; border-radius: 120px;">ï¼</span>
					<span style="padding-left: 4px;font-weight: bold;">POSæºå¼æºåä¸ç´å¡å¨æä¸ªç»é¢ä¸å¨</span>
				</div>
				<div style="padding-left: 50px;">
					<span>è¯·æä»¥ä¸æ­¥éª¤æä½:</span><br />
					<span>1.ææçµæº</span><br />
					<span>2.ææºå·åçå¾ä¸æ¨,ææçµæ± </span><br />
					<span>3.éæ°è£å¥çµæ± åå¼æº</span><br />
				</div>
				<div style="padding-bottom: 10px;padding-left: 20px;padding-top: 16px;">
					<span style="background-color: red;color: white;padding:0px 2px; border-radius: 120px;">ï¼</span>
					<span style="padding-left: 4px;font-weight: bold;">POSæºå¼æºåä¸ç´å¡å¨äº¤ææåçé¢æ<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ç»ç®çé¢</span>
				</div>
				<div style="padding-left: 50px;">
					<span>è¯·æä»¥ä¸æ­¥éª¤æä½:</span><br />
					<span>1.ææçµæº</span><br />
					<span>2.ææºå·åçå¾ä¸æ¨,ææçµæ± </span><br />
					<span>3.éæ°è£å¥çµæ± åå¼æº</span><br />
				</div>
				<div style="padding-left: 30px;margin-top: 30px;color: gray;">
					<span>å°Eæ¸©é¦¨æç¤ºï¼è¯·åæ¶è¿è¡æ¥ç»ç»ç®</span>
				</div>
				<div style="padding:16px 30px;">
					<span>è¥æªè½å¸®æ¨è§£å³é®é¢ï¼è¯·ç¹å»<a href="#">èªå©æ¥ä¿®</a></span>
				</div>
			</div>
			<div></div>
		</div>
	</body>

</html>