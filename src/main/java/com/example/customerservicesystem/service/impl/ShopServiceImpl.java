package com.example.customerservicesystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.customerservicesystem.bean.Shop;
import com.example.customerservicesystem.dao.ShopDao;
import com.example.customerservicesystem.service.ShopService;
import com.example.customerservicesystem.untils.DomainNoUtils;

@Service("shopService")
public class ShopServiceImpl implements ShopService{

	@Resource
	ShopDao shopDao;

	@Override
	public void insertShop(Shop shop) {
		shopDao.insertShop(shop);
	}

	@Override
	public List<Shop> getShopByCondition(Shop shop) {
		return shopDao.getShopByCondition(shop);
	}

	@Override
	public void updateShopByCondition(Shop shop) {
		shopDao.updateShopByCondition(shop);
	}

	@Override
	public void deleteShopByUserNo(Shop shop) {
		shopDao.deleteShopByUserNo(shop);
	}
	
}
