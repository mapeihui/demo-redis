package com.maph.demoredis.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ：maph
 * @version ：
 * @date ：Created in 2021-05-15 21:56
 * @description：简单测试所需要的万能实体类
 * @modified By：
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -5035685707296735083L;

    /**
     * 编号
     */
    private int id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;
}
