package com.example.elog.entity;

import lombok.Data;

import java.util.Date;

/**
 * 手动创建
 * @Author gorge
 * @Version 1.0
 * @Date 2023/4/30 17:13
 **/
@Data
public class BaseEntity {
    private Long id;
    private Date created;
    private Date modified;
}
