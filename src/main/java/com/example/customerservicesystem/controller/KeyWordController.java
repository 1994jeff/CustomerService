package com.example.customerservicesystem.controller;
import java.util.List;

/**
 * 后台管理接口
 */
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.customerservicesystem.bean.ApplyRecord;
import com.example.customerservicesystem.bean.KeyWord;
import com.example.customerservicesystem.bean.User;
import com.example.customerservicesystem.bean.dto.ShopDto;
import com.example.customerservicesystem.service.KeyWordService;
import com.example.customerservicesystem.service.RecordService;
import com.example.customerservicesystem.service.ShopService;
import com.example.customerservicesystem.service.UserService;

@Controller
@RequestMapping("/keyWord")
public class KeyWordController extends BaseController{

	
	@Resource
	KeyWordService keyWordService;
	@Resource
	RecordService recordService;
	@Resource
	ShopService shopService;
	@Resource
	UserService userService;
	
	@RequestMapping("/toIndex.do")
	public String toIndex(HttpSession session,Model model){
		return "main/manager/index";
	}
	
	/**
	 * @param session
	 * @param model
	 * @param shopName
	 * @param shopBrand
	 * @return
	 * 查看订纸列表
	 */
	@RequestMapping("/toBook.do")
	public String toBook(HttpSession session,Model model,String shopName,String shopBrand){
		ShopDto dto = new ShopDto();
		dto.setReason("common");
		dto.setType("1");
		if(!"".equals(shopName) && null!=shopName){
			dto.setShopName(shopName);
		}
		if(!"".equals(shopBrand) && null != shopBrand){
			dto.setShopBrand(shopBrand);
		}
		List<ShopDto> dtos = keyWordService.getShopDtoByCondition(dto);
		model.addAttribute("dtos", dtos);
		return "main/manager/book";
	}
	
	@RequestMapping("/toException.do")
	public String toException(HttpSession session,Model model,String shopName,String shopBrand){
		ShopDto dto = new ShopDto();
		dto.setType("1");
		if(!"".equals(shopName) && null!=shopName){
			dto.setShopName(shopName);
		}
		if(!"".equals(shopBrand) && null != shopBrand){
			dto.setShopBrand(shopBrand);
		}
		List<ShopDto> dtos = keyWordService.getShopDtoByCondition(dto);
		model.addAttribute("dtos", dtos);
		return "main/manager/exception";
	}
	
	@RequestMapping("/toRepair.do")
	public String toRepqir(HttpSession session,Model model,String shopName,String shopBrand){
		ShopDto dto = new ShopDto();
		dto.setType("0");
		if(!"".equals(shopName) && null!=shopName){
			dto.setShopName(shopName);
		}
		if(!"".equals(shopBrand) && null != shopBrand){
			dto.setShopBrand(shopBrand);
		}
		List<ShopDto> dtos = keyWordService.getShopDtoByCondition(dto);
		model.addAttribute("dtos", dtos);
		return "main/manager/repair";
	}
	
	@RequestMapping("/toKeyWord.do")
	public String toKeyWords(HttpSession session,Model model,String keyWord,String type,String replyMsg){
		if(type==null || "".equals(type)){
			KeyWord keyWords = new KeyWord();
			if(null!=keyWord && !"".equals(keyWord))
			{
				keyWords.setKeyWord(keyWord);
			}
			List<KeyWord> list = keyWordService.getKeyWordByCondition(keyWords);
			if(list!=null && list.size()>0){
				model.addAttribute("list", list);
			}
		}else if("1".equals(type)){
			KeyWord key = new KeyWord();
			key.setKeyWord(keyWord);
			key.setReply(replyMsg);
				try {
					keyWordService.insertKeyWord(key);
				} catch (Exception e) {
					model.addAttribute("msg", e.getMessage());
				}
				KeyWord keyWords = new KeyWord();
				List<KeyWord> list = keyWordService.getKeyWordByCondition(keyWords);
				if(list!=null && list.size()>0){
					model.addAttribute("list", list);
				}

		}
		return "main/manager/keyword";
	}
	
	@RequestMapping("/toUpdateKeyWord.do")
	public String toUpdateKeyWord(HttpSession session,Model model,String status,String keyWordNo){
		KeyWord l = new KeyWord();
		if(!"".equals(status)){
			l.setStatus(status);
			l.setKeyWordNo(keyWordNo);
		}
		keyWordService.updateKeyWordByCondition(l);
		KeyWord keyWords = new KeyWord();
		List<KeyWord> list = keyWordService.getKeyWordByCondition(keyWords);
		if(list!=null && list.size()>0){
			model.addAttribute("list", list);
		}
		return "main/manager/keyword";
	}
	
	@RequestMapping("/toDeleteKeyWord.do")
	public String toDeleteKeyWord(HttpSession session,Model model,String keyWordNo){
		KeyWord l = new KeyWord();
		if(!"".equals(keyWordNo)){
			l.setStatus(keyWordNo);
			l.setKeyWordNo(keyWordNo);
		}
		keyWordService.deleteKeyWordByKeyWordNo(l);
		KeyWord keyWords = new KeyWord();
		List<KeyWord> list = keyWordService.getKeyWordByCondition(keyWords);
		if(list!=null && list.size()>0){
			model.addAttribute("list", list);
		}
		return "main/manager/keyword";
	}
	
}
