package com.example.customerservicesystem.dao;

import java.util.List;

import com.example.customerservicesystem.bean.KeyWord;

public interface IKeyWordDao {
	
	void insertkeyWord(KeyWord keyWord);

	List<KeyWord> getKeyWordByCondition(KeyWord keyWord);

	void updateKeyWordByCondition(KeyWord keyWord);

	void deleteKeyWordByKeyWordNo(KeyWord keyWord);
}
