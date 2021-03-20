package com.example.medical_record.service.impl;

import com.example.medical_record.dao.UserDao;
import com.example.medical_record.entity.po.User;
import com.example.medical_record.entity.vo.RecordVo;
import com.example.medical_record.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void register(User user) {
        if (userDao.findUserByAccount(user.getAccount()) == null) {
            userDao.saveUser(user);
        } else {
            throw new RuntimeException("用户名已存在，请重新输入！");
        }
    }

    @Override
    public User login(User user) {
        User userDb = userDao.findUserByAccount(user.getAccount());
        if (userDb == null) {
            throw new RuntimeException("用户名错误！");
        } else {
            if (!user.getPassword().equals(userDb.getPassword())) {
                throw new RuntimeException("密码错误！");
            } else {
                return userDb;
            }
        }
    }

    @Override
    public List<RecordVo> getRecords(Integer uid) {
        List<RecordVo> recordVoList = userDao.findRecordVoByUid(uid);
        if (recordVoList == null || recordVoList.size() == 0) {
            throw new RuntimeException("当前无记录");
        }

        return recordVoList;
    }

    @Override
    public User getUser(Integer id) {
        return userDao.findUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
