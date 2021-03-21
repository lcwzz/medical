package com.example.medical_record.controller;

import com.example.medical_record.entity.po.Admin;
import com.example.medical_record.service.AdminService;
import com.example.medical_record.util.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @PostMapping("/login")
    public ResponseData login(@RequestBody Admin admin) {
        log.debug(admin.toString());
        ResponseData responseData = new ResponseData();
        try {
            Admin adminDb = adminService.login(admin);
            responseData.setSuccess(true);
            responseData.setData(adminDb);
            return responseData;
        } catch (Exception e) {
            responseData.setSuccess(false).setMsg(e.getMessage());
            return responseData;
        }
    }

}
