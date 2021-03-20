package com.example.medical_record.service.impl;

import com.example.medical_record.dao.RecordDao;
import com.example.medical_record.dao.UserDao;
import com.example.medical_record.entity.po.Record;
import com.example.medical_record.entity.po.User;
import com.example.medical_record.entity.vo.RecordVo;
import com.example.medical_record.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
@Transactional
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordDao recordDao;

    @Autowired
    private UserDao userDao;

    @Override
    public void addRecord(RecordVo recordVo, Integer did) {
        Record record = new Record();
        User user = userDao.findUserByName(recordVo.getUserName());
        if (user == null) {
            throw new RuntimeException("该患者不存在!");
        }
        record.setUid(user.getId());
        record.setDid(did);
        record.setDescription(recordVo.getDescription());
        record.setState(recordVo.getState());
        record.setDate(new Date(System.currentTimeMillis()));
        recordDao.addRecord(record);
    }

    @Override
    public void deleteRecord(Integer id) {
        recordDao.deleteById(id);
    }

    @Override
    public void updateRecord(RecordVo recordVo) {
        recordDao.updateRecord(recordVo);
    }
}

