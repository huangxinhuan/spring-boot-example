package com.example.demo.domain;


public class Account {

    private Integer id;

    private Integer uid;

    private Double amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("{\"id\"=%d,\"uid\"=\"%d\",\"amount\"=%.2f}", id, uid, amount);
    }
}
