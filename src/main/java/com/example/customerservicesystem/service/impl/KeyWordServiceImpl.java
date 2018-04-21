package com.example.customerservicesystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.customerservicesystem.bean.KeyWord;
import com.example.customerservicesystem.bean.dto.ShopDto;
import com.example.customerservicesystem.dao.KeyWordDao;
import com.example.customerservicesystem.service.KeyWordService;
import com.example.customerservicesystem.untils.DomainNoUtils;

@Service("keyWordService")
public class KeyWordServiceImpl implements KeyWordService {

	@Resource
	KeyWordDao keyWordDao;
	
	@Override
	public List<ShopDto> getShopDtoByCondition(ShopDto dto) {
		return keyWordDao.getShopDtoByCondition(dto);
	}

	@Override
	public void insertKeyWord(KeyWord key) throws Exception {
			KeyWord k = new KeyWord();
			k.setKeyWord(key.getKeyWord());
			List<KeyWord> keywords = keyWordDao.getKeyWordByCondition(k );
			if(keywords!=null && keywords.size()>0){
				throw new Exception("关键词["+key.getKeyWord()+"]已存在!请先删除此关键词");
			}else{
				key.setStatus("1");
				String keyWordNo = DomainNoUtils.getNoByPreStr(DomainNoUtils.KEY_NO);
				key.setKeyWordNo(keyWordNo );
				keyWordDao.insertKeyWord(key);			
			}
	}

	@Override
	public List<KeyWord> getKeyWordByCondition(KeyWord keyWord) {
		List<KeyWord> list = null;
		try {
			list = keyWordDao.getKeyWordByCondition(keyWord);
		} catch (Exception e) {
		}
		return list;
	}

	@Override
	public void updateKeyWordByCondition(KeyWord keyWord) {
		keyWordDao.updateKeyWordByCondition(keyWord);
	}

	@Override
	public void deleteKeyWordByKeyWordNo(KeyWord keyWord) {
		keyWordDao.deleteKeyWordByKeyWordNo(keyWord);
	}

}
