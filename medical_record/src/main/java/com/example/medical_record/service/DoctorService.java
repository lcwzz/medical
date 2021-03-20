package com.example.medical_record.service;

import com.example.medical_record.entity.po.Doctor;
import com.example.medical_record.entity.vo.DoctorVo;
import com.example.medical_record.entity.vo.RecordVo;

import java.util.List;

public interface DoctorService {

    Doctor login(Doctor doctor);

    List<RecordVo> getRecords(Integer did);

    DoctorVo getDoctor(Integer id);

    void updateDoctor(Doctor doctor);
}
