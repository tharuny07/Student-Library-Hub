package com.example.StudentLibraryManagement.DTOs;

public class StudentUpdateMobReqDto {
    private int id;
    private String mobNo;

    public StudentUpdateMobReqDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }
}
