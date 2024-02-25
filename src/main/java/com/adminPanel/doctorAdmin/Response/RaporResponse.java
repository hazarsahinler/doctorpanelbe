package com.adminPanel.doctorAdmin.Response;

public class RaporResponse {

    private String url;

    private Integer doctorId;

    private Integer userId;


    public RaporResponse(String url, Integer doctorId, Integer userId) {
        this.url = url;
        this.doctorId = doctorId;
        this.userId = userId;

    }




    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


}
