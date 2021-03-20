package com.example.medical_record.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class User {
    private Integer id;
    private String account;
    private String password;
    private String name;
    private Integer sex;
    private Integer age;
}
