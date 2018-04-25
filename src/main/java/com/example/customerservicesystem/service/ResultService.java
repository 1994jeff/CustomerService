package com.example.customerservicesystem.service;

import java.util.List;

import com.example.customerservicesystem.bean.Result;

public interface ResultService {


	List<Result> getResultByCondition(Result result);

	void updateResultByCondition(Result result);

	void insertResult(Result result);

	void deleteResultByResultNo(String resultNo);
	
	Result getResultByResultNo(String resultNo);

}
