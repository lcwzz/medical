package com.example.medical_record.controller;

import com.example.medical_record.entity.po.Admin;
import com.example.medical_record.entity.po.Doctor;
import com.example.medical_record.entity.po.Room;
import com.example.medical_record.entity.vo.DoctorVo;
import com.example.medical_record.service.AdminService;
import com.example.medical_record.util.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getAllDoctors")
    public ResponseData getAllDoctors() {
        ResponseData responseData = new ResponseData();
        try {
            List<DoctorVo> doctors = adminService.findAllDoctors();
            responseData.setSuccess(true);
            responseData.setData(doctors);
            return responseData;
        } catch (Exception e) {
            responseData.setSuccess(false).setMsg(e.getMessage());
            return responseData;
        }
    }

    @GetMapping("/deleteDoctor")
    public ResponseData deleteDoctor(@RequestParam("id") Integer id) {
        ResponseData responseData = new ResponseData();
        try {
            adminService.deleteDoctor(id);
            responseData.setSuccess(true);
            return responseData;
        } catch (Exception e) {
            responseData.setSuccess(false).setMsg("删除失败，此医生有关联病历！");
            return responseData;
        }
    }

    @GetMapping("/getAllRoom")
    public ResponseData getAllRoom() {
        ResponseData responseData = new ResponseData();
        try {
            List<Room> roomList = adminService.findAllRoom();
            responseData.setSuccess(true);
            responseData.setData(roomList);
            return responseData;
        } catch (Exception e) {
            responseData.setSuccess(false).setMsg(e.getMessage());
            return responseData;
        }
    }

    @PostMapping("/add")
    public ResponseData addDoctor(@RequestBody Doctor doctor) {
        ResponseData responseData = new ResponseData();
        try {
            adminService.addDoctor(doctor);
            responseData.setSuccess(true);
            return responseData;
        } catch (Exception e) {
            responseData.setSuccess(false).setMsg(e.getMessage());
            return responseData;
        }
    }

    @PostMapping("/updateDoctor")
    public ResponseData updateDoctor(@RequestBody Doctor doctor) {
        ResponseData responseData = new ResponseData();
        try {
            adminService.updateDoctor(doctor);
            responseData.setSuccess(true);
            return responseData;
        } catch (Exception e) {
            responseData.setSuccess(false).setMsg(e.getMessage());
            return responseData;
        }
    }

    @PostMapping("/updateInfo")
    public ResponseData updateInfo(@RequestBody Admin admin) {
        ResponseData responseData = new ResponseData();
        try {
            adminService.updateAdmin(admin);
            responseData.setSuccess(true);
            return responseData;
        } catch (Exception e) {
            responseData.setSuccess(false).setMsg(e.getMessage());
            return responseData;
        }
    }
}
