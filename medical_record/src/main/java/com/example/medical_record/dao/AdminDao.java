package com.example.medical_record.dao;

import com.example.medical_record.entity.po.Admin;
import com.example.medical_record.entity.po.Doctor;
import com.example.medical_record.entity.po.Room;

import java.util.List;


public interface AdminDao {
    Admin findAdminByAccount(String account);

    List<Room> findAllRoom();

    void updateDoctor(Doctor doctor);

    void updateAdmin(Admin admin);
}
