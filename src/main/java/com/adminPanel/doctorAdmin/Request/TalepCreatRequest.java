package com.adminPanel.doctorAdmin.Request;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


public class TalepCreatRequest {
    @Id
    private int id;
    private String text;
    Integer userId;

    public TalepCreatRequest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "TalepCreatRequest{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", userId=" + userId +
                '}';
    }
}
