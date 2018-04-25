package com.example.customerservicesystem.service;

import java.util.List;

import com.example.customerservicesystem.bean.KeyWord;
import com.example.customerservicesystem.bean.dto.ShopDto;

public interface KeyWordService {

	List<ShopDto> getShopDtoByCondition(ShopDto dto);

	void insertKeyWord(KeyWord key) throws Exception;
	
	List<KeyWord> getKeyWordByCondition(KeyWord keyWord);

	void updateKeyWordByCondition(KeyWord keyWord);

	void deleteKeyWordByKeyWordNo(KeyWord keyWord);
}
