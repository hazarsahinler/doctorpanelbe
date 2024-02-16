package com.adminPanel.doctorAdmin.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Table(name="demand")
public class Demand {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="demand_id")
    private int id;

    @Column
    private Date writtenOn;

    @Column
    private String writtenBy;




    @Lob
    private String content;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "doctor_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Doctor doctor;





    public Demand() {
    }

    public Demand(Date writtenOn, String writtenBy, String content) {
        this.writtenOn = writtenOn;
        this.writtenBy = writtenBy;
        this.content = content;
    }

    public Demand(String writtenBy, String content) {
        this.writtenOn = new Date();
        this.writtenBy = writtenBy;
        this.content = content;
    }

    public Demand(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getWrittenOn() {
        return writtenOn;
    }

    public void setWrittenOn(Date writtenOn) {
        this.writtenOn = writtenOn;
    }

    public String getWrittenBy() {
        return writtenBy;
    }

    public void setWrittenBy(String writtenBy) {
        this.writtenBy = writtenBy;
    }

    @Override
    public String toString() {
        return "Demand{" +
                "id=" + id +
                ", writtenOn=" + writtenOn +
                ", writtenBy='" + writtenBy + '\'' +
                ", content='" + content + '\'' +
                ", doctor=" + doctor +
                '}';
    }
}
