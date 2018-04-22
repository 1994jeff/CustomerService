package com.example.customerservicesystem.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.customerservicesystem.bean.ApplyRecord;
import com.example.customerservicesystem.bean.Result;
import com.example.customerservicesystem.bean.RetParam;
import com.example.customerservicesystem.bean.User;
import com.example.customerservicesystem.bean.dto.ShopDto;
import com.example.customerservicesystem.service.KeyWordService;
import com.example.customerservicesystem.service.RecordService;
import com.example.customerservicesystem.service.ResultService;
import com.example.customerservicesystem.service.UserService;
import com.example.customerservicesystem.untils.CreateMenu;
import com.thoughtworks.xstream.io.json.JsonWriter.Format;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/result")
public class ResultController extends BaseController{

	@Resource
	RecordService recordService;
	@Resource
	ResultService resultService;
	@Resource
	KeyWordService keyWordService;
	@Resource
	UserService userService;
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	
	@RequestMapping("/toCloseRecord.do")
	public String toCloseRecord(HttpSession session,Model model,String recordNo,String replyMsg){
		ApplyRecord applyRecord = new ApplyRecord();
		applyRecord.setRecordNo(recordNo);
		applyRecord.setStatus("1");
		applyRecord.setApplyName("reject");
		recordService.updateRecordByCondition(applyRecord );
		Result result = new Result();
		result.setRecordNo(recordNo);
		result.setReplyMsg(replyMsg);
		resultService.insertResult(result );
		ShopDto dto = new ShopDto();
		dto.setReason("common");
		dto.setType("1");
		List<ShopDto> dtos = keyWordService.getShopDtoByCondition(dto);
		model.addAttribute("dtos", dtos);
		
		List<ApplyRecord> list = recordService.getRecordByCondition(applyRecord);
		ApplyRecord ap = list.get(0);
		sendMsgToUser(ap, "订纸");
		
		return "main/manager/book";
	}

	//主动发送消息给指定微信用户,但是必须是在用户与服务号有交互的48小时之内,而且发送次数有限制
	private void sendMsgToUser(ApplyRecord ap, String str) {
		User user = new User();
		user.setUserNo(ap.getUserNo());
		try {
			List<User> us = userService.getUserByCondition(user);
			User ur = us.get(0);
			StringBuilder sb = new StringBuilder();
			sb.append("申请状态更新通知").append("\n\n");
			sb.append("亲爱的").append(ur.getName()).append("您好,您的").append(str).append("申请已受理!").append("\n");
			sb.append("请及时前往查看哦").append("\n");
			sb.append("申请时间:").append(format.format(ap.getCreateTime()));
			CreateMenu.sendMsgToUser(sb.toString(), ur.getOpenId());
		} catch (Exception e) {
		}
	}
	
	@RequestMapping("/toCloseExceptionRecord.do")
	public String toCloseExceptionRecord(HttpSession session,Model model,String recordNo,String replyMsg){
		ApplyRecord applyRecord = new ApplyRecord();
		applyRecord.setRecordNo(recordNo);
		applyRecord.setStatus("1");
		applyRecord.setApplyName("reject");
		recordService.updateRecordByCondition(applyRecord );
		Result result = new Result();
		result.setRecordNo(recordNo);
		result.setReplyMsg(replyMsg);
		resultService.insertResult(result );
		ShopDto dto = new ShopDto();
		dto.setType("1");
		List<ShopDto> dtos = keyWordService.getShopDtoByCondition(dto);
		model.addAttribute("dtos", dtos);
		
		List<ApplyRecord> list = recordService.getRecordByCondition(applyRecord);
		ApplyRecord ap = list.get(0);
		sendMsgToUser(ap, "订纸");
		return "main/manager/exception";
	}
	
	@RequestMapping("/toPassExceptionRecord.do")
	public String toPassExceptionRecord(HttpSession session,Model model,String recordNo,String reason,String remark,String type,String goods){
		ApplyRecord applyRecord = new ApplyRecord();
		applyRecord.setRecordNo(recordNo);
		applyRecord.setStatus("1");
		applyRecord.setApplyName("pass");
		recordService.updateRecordByCondition(applyRecord);
		
		Result result = new Result();
		result.setRecordNo(recordNo);
		result.setReason(reason);//快递类型
		result.setRemark(remark);//快递单号
		result.setType(type);//运费
		result.setGoods(goods);//卷纸数
		resultService.insertResult(result );
		
		ShopDto dto = new ShopDto();
		dto.setType("1");
		List<ShopDto> dtos = keyWordService.getShopDtoByCondition(dto);
		model.addAttribute("dtos", dtos);
		
		List<ApplyRecord> list = recordService.getRecordByCondition(applyRecord);
		ApplyRecord ap = list.get(0);
		sendMsgToUser(ap, "订纸");
		return "main/manager/exception";
	}
	
	@RequestMapping("/toPassRecord.do")
	public String toPassRecord(HttpSession session,Model model,String recordNo,String reason,String remark,String type,String goods){
		ApplyRecord applyRecord = new ApplyRecord();
		applyRecord.setRecordNo(recordNo);
		applyRecord.setStatus("1");
		applyRecord.setApplyName("pass");
		recordService.updateRecordByCondition(applyRecord);
		
		Result result = new Result();
		result.setRecordNo(recordNo);
		result.setReason(reason);//快递类型
		result.setRemark(remark);//快递单号
		result.setType(type);//运费
		result.setGoods(goods);//卷纸数
		resultService.insertResult(result );
		
		ShopDto dto = new ShopDto();
		dto.setReason("common");
		dto.setType("1");
		List<ShopDto> dtos = keyWordService.getShopDtoByCondition(dto);
		model.addAttribute("dtos", dtos);
		
		List<ApplyRecord> list = recordService.getRecordByCondition(applyRecord);
		ApplyRecord ap = list.get(0);
		sendMsgToUser(ap, "订纸");
		
		return "main/manager/book";
	}
	
	@RequestMapping("/getResult.do")
	@ResponseBody
	public String getResult(HttpSession session,String recordNo){
		RetParam<Result> retParam = new RetParam<>();
		try {
			Result result = new Result();
			if("".equals(recordNo)){
				throw new Exception("错误,记录号不唯一!");
			}
			result.setRecordNo(recordNo);
			List<Result> list = resultService.getResultByCondition(result );
			retParam.setRetCode("success");
			retParam.setRetData(list);
		} catch (Exception e) {
			retParam.setRetCode("fault");
			retParam.setRetMsg(e.getMessage());
		}
		return JSONObject.fromObject(retParam).toString();
	}
	
	@RequestMapping("/toCloseRepairRecord.do")
	public String toCloseRepairRecord(HttpSession session,Model model,String recordNo,String replyMsg){
		ApplyRecord applyRecord = new ApplyRecord();
		applyRecord.setRecordNo(recordNo);
		applyRecord.setStatus("1");
		applyRecord.setApplyName("reject");
		recordService.updateRecordByCondition(applyRecord );
		Result result = new Result();
		result.setRecordNo(recordNo);
		result.setReplyMsg(replyMsg);
		result.setType("reject");
		resultService.insertResult(result );
		ShopDto dto = new ShopDto();
		dto.setType("0");
		List<ShopDto> dtos = keyWordService.getShopDtoByCondition(dto);
		model.addAttribute("dtos", dtos);
		
		List<ApplyRecord> list = recordService.getRecordByCondition(applyRecord);
		ApplyRecord ap = list.get(0);
		sendMsgToUser(ap, "报修");
		return "main/manager/repair";
	}
	
	@RequestMapping("/toPassRepairRecord.do")
	public String toPassRepairRecord(HttpSession session,Model model,Result result){
		ApplyRecord applyRecord = new ApplyRecord();
		applyRecord.setRecordNo(result.getRecordNo());
		applyRecord.setStatus("1");
		applyRecord.setApplyName("pass");
		recordService.updateRecordByCondition(applyRecord );

		resultService.insertResult(result );
		
		ShopDto dto = new ShopDto();
		dto.setType("0");
		List<ShopDto> dtos = keyWordService.getShopDtoByCondition(dto);
		model.addAttribute("dtos", dtos);
		
		List<ApplyRecord> list = recordService.getRecordByCondition(applyRecord);
		ApplyRecord ap = list.get(0);
		sendMsgToUser(ap, "报修");
		
		return "main/manager/repair";
	}
}
