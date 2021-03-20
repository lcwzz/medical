package com.example.medical_record.service.impl;

import com.example.medical_record.dao.DoctorDao;
import com.example.medical_record.entity.po.Doctor;
import com.example.medical_record.entity.vo.DoctorVo;
import com.example.medical_record.entity.vo.RecordVo;
import com.example.medical_record.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorDao doctorDao;

    @Override
    public Doctor login(Doctor doctor) {
        Doctor doctorDb = doctorDao.findDoctorByAccount(doctor.getAccount());
        if (doctorDb == null) {
            throw new RuntimeException("用户名错误！");
        } else {
            if (!doctor.getPassword().equals(doctorDb.getPassword())) {
                throw new RuntimeException("密码错误！");
            } else {
                return doctorDb;
            }
        }
    }

    @Override
    public List<RecordVo> getRecords(Integer did) {
        List<RecordVo> recordVoList = doctorDao.findRecordVoByDid(did);
        if (recordVoList == null || recordVoList.size() == 0) {
            throw new RuntimeException("当前无记录");
        }

        return recordVoList;
    }

    @Override
    public DoctorVo getDoctor(Integer id) {
        return doctorDao.findDoctorById(id);
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        doctorDao.updateDoctor(doctor);
    }

}
