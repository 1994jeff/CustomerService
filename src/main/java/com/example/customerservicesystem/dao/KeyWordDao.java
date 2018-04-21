package com.example.customerservicesystem.dao;

import java.util.List;

import com.example.customerservicesystem.bean.KeyWord;
import com.example.customerservicesystem.bean.dto.ShopDto;

public interface KeyWordDao {
	
	List<KeyWord> getKeyWordByCondition(KeyWord keyWord);

	void updateKeyWordByCondition(KeyWord keyWord);

	void deleteKeyWordByKeyWordNo(KeyWord keyWord);

	List<ShopDto> getShopDtoByCondition(ShopDto dto);

	void insertKeyWord(KeyWord key);
}
