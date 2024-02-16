package com.adminPanel.doctorAdmin.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "doctor_service",
            joinColumns = { @JoinColumn(name = "doctor_id") },
            inverseJoinColumns = { @JoinColumn(name = "service_id") })
    private List<Service> service = new ArrayList<>();



    public Doctor() {
    }

    public Doctor(String name) {
        this.name = name;
    }

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

    public List<Service> getService() {
        return service;
    }

    public void setService(List<Service> service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", service=" + service +
                '}';
    }

    public void addService(Service service) {
        this.service.add(service);
        service.getDoctors().add(this);
    }
    public void removeService(int serviceId) {
        Service service = this.service.stream().filter(t -> t.getId() == serviceId).findFirst().orElse(null);
        if (service != null) {
            this.service.remove(service);
            service.getDoctors().remove(this);
        }
    }
}
