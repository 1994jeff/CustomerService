package com.example.customerservicesystem.dao;

import java.util.List;

import com.example.customerservicesystem.bean.Result;

public interface ResultDao {

	List<Result> getResultByCondition(Result result);

	void updateResultByCondition(Result result);

	void insertResult(Result result);

	void deleteResultByResultNo(String resultNo);

	Result getResultByResultNo(String resultNo);

}
