package com.adminPanel.doctorAdmin.Request;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


public class TalepCreatRequest {

    private int id;
    private String text;
    Integer userId;

    Integer doctorId;



    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
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
                ", doctorId=" + doctorId +
                '}';
    }
}
