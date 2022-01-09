package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Payment implements Serializable {

    private Long id;
    private String serial;

    public Payment(String serial) {
        this.serial = serial;
    }
}
