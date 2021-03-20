package com.example.medical_record.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class RecordVo {
    private String id;
    private String userName; // 患者姓名
    private String doctorName; // 医生姓名
    private String roomName; // 科室
    private String description; // 医嘱
    private String state; // 状态
    private Date date; // 日期
}
