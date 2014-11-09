package com.github.cjm0000000.h5.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Digits;
import java.io.Serializable;

/**
 * User entity
 * Created by lemon on 14/11/9.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 6855234242380279973L;
    private int id;
    @NotEmpty(message = "不能为空")
    private String name;
    @NotEmpty(message = "号码不能为空")
    @Digits(integer = 11, fraction = 0, message = "只能是数字")
    private String phone;
    @NotEmpty(message = "地址不能为空")
    private String addr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
