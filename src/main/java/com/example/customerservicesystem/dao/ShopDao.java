package com.example.customerservicesystem.dao;

import com.example.customerservicesystem.bean.Shop;

public interface ShopDao {

	void insertShop(Shop shop);

	void getShopByCondition(Shop shop);

	void updateShopByCondition(Shop shop);

	void deleteShopByUserNo(Shop shop);

}
