package com.example.medical_record.controller;

import com.example.medical_record.entity.vo.RecordVo;
import com.example.medical_record.service.RecordService;
import com.example.medical_record.util.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @PostMapping("/add")
    public ResponseData addRecord(@RequestBody RecordVo recordVo, @RequestParam("did") Integer did) {
        log.debug(recordVo.toString());
        log.debug("did:" + did);
        ResponseData responseData = new ResponseData();
        try {
            recordService.addRecord(recordVo, did);
            responseData.setSuccess(true);
            return responseData;
        } catch (Exception e) {
            responseData.setSuccess(false).setMsg(e.getMessage());
            return responseData;
        }

    }

    @GetMapping("/delete")
    public ResponseData deleteRecord(@RequestParam("id") Integer id) {
        log.debug("recordId：" + id);
        ResponseData responseData = new ResponseData();
        try {
            recordService.deleteRecord(id);
            responseData.setSuccess(true);
            return responseData;
        } catch (Exception e) {
            responseData.setSuccess(false).setMsg(e.getMessage());
            return responseData;
        }

    }

}
