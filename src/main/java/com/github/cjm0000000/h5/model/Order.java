package com.github.cjm0000000.h5.model;

import javax.validation.Valid;

/**
 * Order BO
 * Created by lemon on 14/11/8.
 */
public class Order {
    private int id;
    @Valid
    private User sender;
    @Valid
    private User recver;
    private Goods goods;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecver() {
        return recver;
    }

    public void setRecver(User recver) {
        this.recver = recver;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
