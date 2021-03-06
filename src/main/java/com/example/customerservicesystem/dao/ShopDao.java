package com.example.customerservicesystem.dao;

import java.util.List;

import com.example.customerservicesystem.bean.Shop;

public interface ShopDao {

	void insertShop(Shop shop);

	List<Shop> getShopByCondition(Shop shop);

	void updateShopByCondition(Shop shop);

	void deleteShopByUserNo(Shop shop);

}
