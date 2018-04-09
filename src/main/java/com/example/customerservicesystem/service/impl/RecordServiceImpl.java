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
		try {
			String reNo = DomainNoUtils.getNoByPreStr(DomainNoUtils.AUTH_NO);
			applyRecord.setRecordNo(reNo);
			recordDao.insertRecord(applyRecord);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<ApplyRecord> getRecordByCondition(ApplyRecord applyRecord) {
		List<ApplyRecord> a = null;
		try {
			a =  recordDao.getRecordByCondition(applyRecord);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return a;
	}

	@Override
	public void updateRecordByCondition(ApplyRecord applyRecord) {
		try {
			recordDao.updateRecordByCondition(applyRecord);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void deleteRecordByUserNo(ApplyRecord applyRecord) {
		try {
			recordDao.deleteRecordByUserNo(applyRecord);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
