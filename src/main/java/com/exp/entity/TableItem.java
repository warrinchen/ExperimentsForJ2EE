package com.exp.entity;

import java.util.Date;

public class TableItem {
    private String id;
    private String name;
    private String gender;
    private Date birthDay;
    private String politicalStatus;
    private String birthplace;
    private String flatId;
    private Integer admissionScore;
    private Float averageScore;
    private Integer ranking;
    private String note;

    public TableItem() {
        note = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getFlatId() {
        return flatId;
    }

    public void setFlatId(String flatId) {
        this.flatId = flatId;
    }

    public Integer getAdmissionScore() {
        return admissionScore;
    }

    public void setAdmissionScore(Integer admissionScore) {
        this.admissionScore = admissionScore;
    }

    public Float getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Float averageScore) {
        this.averageScore = averageScore;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDay=" + birthDay +
                ", politicalStatus='" + politicalStatus + '\'' +
                ", birthplace='" + birthplace + '\'' +
                ", flatId='" + flatId + '\'' +
                ", admissionScore=" + admissionScore +
                ", averageScore=" + averageScore +
                ", ranking=" + ranking +
                ", note='" + note + '\'' +
                '}';
    }
}
