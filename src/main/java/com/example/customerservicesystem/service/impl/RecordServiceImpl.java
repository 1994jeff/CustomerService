package com.example.customerservicesystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.customerservicesystem.bean.ApplyRecord;
import com.example.customerservicesystem.dao.RecordDao;
import com.example.customerservicesystem.service.RecordService;
import com.example.customerservicesystem.untils.DomainNoUtils;
@Service("recordService")
public class RecordServiceImpl implements RecordService {

	@Resource
	RecordDao recordDao;
	
	@Override
	public void insertRecord(ApplyRecord applyRecord) {
		String reNo = DomainNoUtils.getNoByPreStr(DomainNoUtils.AUTH_NO);
		applyRecord.setRecordNo(reNo);
		recordDao.insertRecord(applyRecord);
	}

	@Override
	public List<ApplyRecord> getRecordByCondition(ApplyRecord applyRecord) {
		return recordDao.getRecordByCondition(applyRecord);
	}

	@Override
	public void updateRecordByCondition(ApplyRecord applyRecord) {
		recordDao.updateRecordByCondition(applyRecord);
	}

	@Override
	public void deleteRecordByUserNo(ApplyRecord applyRecord) {
		recordDao.deleteRecordByUserNo(applyRecord);
	}

}
