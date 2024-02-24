package com.adminPanel.doctorAdmin.Request;

import org.springframework.web.multipart.MultipartFile;

public class RaporCreatRequest {
    private String id;
    private MultipartFile data;

    String doctorName;

    String userName;

    public RaporCreatRequest() {
    }

    public RaporCreatRequest(MultipartFile data, String doctorName, String userName) {
        this.data = data;
        this.doctorName = doctorName;
        this.userName = userName;
    }

    public MultipartFile getData() {
        return data;
    }

    public void setData(MultipartFile data) {
        this.data = data;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
