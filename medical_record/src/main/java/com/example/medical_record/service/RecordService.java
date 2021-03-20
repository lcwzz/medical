package com.example.medical_record.service;

import com.example.medical_record.entity.vo.RecordVo;

public interface RecordService {
    void addRecord(RecordVo recordVo, Integer did);

    void deleteRecord(Integer id);
}
