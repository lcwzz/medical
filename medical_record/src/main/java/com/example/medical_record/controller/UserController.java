package com.example.medical_record.controller;

import com.example.medical_record.entity.po.User;
import com.example.medical_record.entity.vo.RecordVo;
import com.example.medical_record.service.UserService;
import com.example.medical_record.util.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseData registerUser(@RequestBody User user) {
        log.debug(user.toString());
        ResponseData responseData = new ResponseData();
        try {
            userService.register(user);
            responseData.setSuccess(true);
            return responseData;
        } catch (Exception e) {
            responseData.setSuccess(false).setMsg(e.getMessage());
            return responseData;
        }

    }

    @PostMapping("/login")
    public ResponseData login(@RequestBody User user) {
        log.debug(user.toString());
        ResponseData responseData = new ResponseData();
        try {
            User userDb = userService.login(user);
            responseData.setSuccess(true);
            responseData.setData(userDb.getId());
            return responseData;
        } catch (Exception e) {
            responseData.setSuccess(false).setMsg(e.getMessage());
            return responseData;
        }
    }

    @GetMapping("/getRecords")
    public ResponseData getRecords(@RequestParam("uid")Integer uid) {
        log.debug("用户id：" + uid);
        ResponseData responseData = new ResponseData();
        try {
            List<RecordVo> records = userService.getRecords(uid);
            responseData.setSuccess(true);
            responseData.setData(records);
            return responseData;
        } catch (Exception e) {
            responseData.setSuccess(false).setMsg(e.getMessage());
            return responseData;
        }
    }

    @GetMapping("/getInfo")
    public ResponseData getInfo(@RequestParam("id")Integer id) {
        log.debug("用户id：" + id);
        ResponseData responseData = new ResponseData();
        User user = userService.getUser(id);
        responseData.setSuccess(true);
        responseData.setData(user);
        return responseData;
    }

    @PostMapping("/updateInfo")
    public ResponseData updateInfo(@RequestBody User user) {
        log.debug("用户User：" + user);
        ResponseData responseData = new ResponseData();
        try {
            userService.updateUser(user);
            responseData.setSuccess(true);
            return responseData;
        } catch (Exception e) {
            responseData.setSuccess(false).setMsg(e.getMessage());
            return responseData;
        }
    }
}
