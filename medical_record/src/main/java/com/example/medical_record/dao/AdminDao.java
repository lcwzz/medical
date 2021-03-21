package com.example.medical_record.dao;

import com.example.medical_record.entity.po.Admin;


public interface AdminDao {
    Admin findAdminByAccount(String account);
}
