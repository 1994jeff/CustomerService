package com.example.customerservicesystem.service;

import java.util.List;

import com.example.customerservicesystem.bean.ApplyRecord;

public interface RecordService {

	void insertRecord(ApplyRecord applyRecord);

	List<ApplyRecord> getRecordByCondition(ApplyRecord applyRecord);

	void updateRecordByCondition(ApplyRecord applyRecord);

	void deleteRecordByUserNo(ApplyRecord applyRecord);
}
