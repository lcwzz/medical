package com.example.medical_record.service;

import com.example.medical_record.entity.po.User;
import com.example.medical_record.entity.vo.RecordVo;

import java.util.List;

public interface UserService {
    void register(User user);

    User login(User user);

    List<RecordVo> getRecords(Integer uid);

    User getUser(Integer id);

    void updateUser(User user);
}
