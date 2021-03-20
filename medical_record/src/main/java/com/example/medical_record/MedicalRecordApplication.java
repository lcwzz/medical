package com.example.medical_record;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.medical_record.dao")
@SpringBootApplication
public class MedicalRecordApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicalRecordApplication.class, args);
    }

}
