package com.example.medical_record.dao;

import com.example.medical_record.entity.po.Doctor;
import com.example.medical_record.entity.vo.DoctorVo;
import com.example.medical_record.entity.vo.RecordVo;

import java.util.List;

public interface DoctorDao {
    Doctor findDoctorByAccount(String Account);

    List<RecordVo> findRecordVoByDid(Integer uid);

    DoctorVo findDoctorById(Integer id);

    void updateDoctor(Doctor doctor);

    List<DoctorVo> findAll();

    void deleteById(Integer id);
}
