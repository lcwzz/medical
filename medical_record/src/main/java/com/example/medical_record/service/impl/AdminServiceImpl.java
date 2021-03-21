package com.example.medical_record.service.impl;

import com.example.medical_record.dao.AdminDao;
import com.example.medical_record.entity.po.Admin;
import com.example.medical_record.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin login(Admin admin) {
        Admin adminBb = adminDao.findAdminByAccount(admin.getAccount());
        if (adminBb == null) {
            throw new RuntimeException("用户名错误！");
        } else {
            if (!admin.getPassword().equals(adminBb.getPassword())) {
                throw new RuntimeException("密码错误！");
            } else {
                return adminBb;
            }
        }
    }
}
