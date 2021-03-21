package com.example.medical_record.service.impl;

import com.example.medical_record.dao.AdminDao;
import com.example.medical_record.dao.DoctorDao;
import com.example.medical_record.entity.po.Admin;
import com.example.medical_record.entity.po.Doctor;
import com.example.medical_record.entity.po.Room;
import com.example.medical_record.entity.vo.DoctorVo;
import com.example.medical_record.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private DoctorDao doctorDao;

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

    @Override
    public List<DoctorVo> findAllDoctors() {
        return doctorDao.findAll();
    }

    @Override
    public void deleteDoctor(Integer id) {
        doctorDao.deleteById(id);
    }

    @Override
    public List<Room> findAllRoom() {
        return adminDao.findAllRoom();
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctorDao.addDoctor(doctor);
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        adminDao.updateDoctor(doctor);
    }

}
