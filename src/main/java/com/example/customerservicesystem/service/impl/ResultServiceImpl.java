package com.example.customerservicesystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.customerservicesystem.bean.Result;
import com.example.customerservicesystem.dao.ResultDao;
import com.example.customerservicesystem.service.ResultService;
import com.example.customerservicesystem.untils.DomainNoUtils;

@Service("resultService")
public class ResultServiceImpl implements ResultService{

	@Resource
	ResultDao resultDao;

	@Override
	public List<Result> getResultByCondition(Result result) {
		return resultDao.getResultByCondition(result);
	}
	
	@Override
	public Result getResultByResultNo(String resultNo) {
		return resultDao.getResultByResultNo(resultNo);
	}

	@Override
	public void updateResultByCondition(Result result) {
		resultDao.updateResultByCondition(result);
	}

	@Override
	public void insertResult(Result result) {
		String resultNo = DomainNoUtils.getNoByPreStr(DomainNoUtils.RESULT_NO);
		result.setResultNo(resultNo);
		resultDao.insertResult(result);
	}

	@Override
	public void deleteResultByResultNo(String resultNo) {
		resultDao.deleteResultByResultNo(resultNo);
	}
	
	
}
