package com.example.medical_record.controller;

import com.example.medical_record.entity.po.Doctor;
import com.example.medical_record.entity.vo.DoctorVo;
import com.example.medical_record.entity.vo.RecordVo;
import com.example.medical_record.service.DoctorService;
import com.example.medical_record.util.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/login")
    public ResponseData login(@RequestBody Doctor doctor) {
        log.debug(doctor.toString());
        ResponseData responseData = new ResponseData();
        try {
            Doctor doctorDb = doctorService.login(doctor);
            responseData.setSuccess(true);
            responseData.setData(doctorDb.getId());
            return responseData;
        } catch (Exception e) {
            responseData.setSuccess(false).setMsg(e.getMessage());
            return responseData;
        }
    }

    @GetMapping("/getRecords")
    public ResponseData getRecords(@RequestParam("did")Integer did) {
        log.debug("医生id：" + did);
        ResponseData responseData = new ResponseData();
        try {
            List<RecordVo> records = doctorService.getRecords(did);
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
        log.debug("医生id：" + id);
        ResponseData responseData = new ResponseData();
        DoctorVo doctor = doctorService.getDoctor(id);
        responseData.setSuccess(true);
        responseData.setData(doctor);
        return responseData;
    }

    @PostMapping("/updateInfo")
    public ResponseData updateInfo(@RequestBody Doctor doctor) {
        log.debug("医生：" + doctor);
        ResponseData responseData = new ResponseData();
        try {
            doctorService.updateDoctor(doctor);
            responseData.setSuccess(true);
            return responseData;
        } catch (Exception e) {
            responseData.setSuccess(false).setMsg(e.getMessage());
            return responseData;
        }
    }
}
