package com.example.medical_record.service;

import com.example.medical_record.entity.po.Admin;
import com.example.medical_record.entity.vo.DoctorVo;

import java.util.List;

public interface AdminService {
    Admin login(Admin admin);

    List<DoctorVo> findAllDoctors();

    void deleteDoctor(Integer id);
}