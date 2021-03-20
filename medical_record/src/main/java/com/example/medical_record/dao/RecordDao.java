package com.example.medical_record.dao;

import com.example.medical_record.entity.po.Record;
import com.example.medical_record.entity.vo.RecordVo;

public interface RecordDao {
    void addRecord(Record record);

    void deleteById(Integer id);

    void updateRecord(RecordVo recordVo);
}
