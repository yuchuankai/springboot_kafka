package com.chuan.kafuka.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author yuchuankai
 * @Date 2022/9/23 15:02
 * @Description:
 */
@Data
public class Message {

    private Long id;

    private String msg;

    private Date sendTime;
}
