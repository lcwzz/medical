package com.example.medical_record.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class Record {
    private Integer id;
    private Integer uid;
    private Integer did;
    private String description;
    private String state;
    private Date date;
}
