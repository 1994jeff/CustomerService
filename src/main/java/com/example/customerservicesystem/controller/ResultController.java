package com.example.customerservicesystem.controller;

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
import com.example.customerservicesystem.bean.dto.ShopDto;
import com.example.customerservicesystem.service.KeyWordService;
import com.example.customerservicesystem.service.RecordService;
import com.example.customerservicesystem.service.ResultService;

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
		return "main/manager/book";
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
		return "main/manager/repair";
	}
}
