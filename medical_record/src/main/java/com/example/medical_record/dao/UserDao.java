package com.example.medical_record.dao;

import com.example.medical_record.entity.po.User;
import com.example.medical_record.entity.vo.RecordVo;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    User findUserByAccount(String account);

    List<RecordVo> findRecordVoByUid(Integer uid);

    User findUserById(Integer id);

    void updateUser(User user);

    User findUserByName(String name);
}
