package com.adminPanel.doctorAdmin.Controller;

import com.adminPanel.doctorAdmin.Entity.Doctor;
import com.adminPanel.doctorAdmin.Entity.Service;
import com.adminPanel.doctorAdmin.Repository.DoctorRepository;
import com.adminPanel.doctorAdmin.Repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class ServiceController {
    @Autowired
    ServiceRepository serviceRepository;
    @Autowired
    DoctorRepository doctorRepository;





    // Get all doctors
    @GetMapping("/services")
    public List<Service> getAllService() {
        return serviceRepository.findAll();
    }
    @GetMapping("/services/{serviceId}")
    public Service getServiceById(@PathVariable Integer serviceId) {
        Service service = serviceRepository.findById(serviceId).get();
        return  service;
    }

    @PostMapping("/services")
    public Service addService(@RequestBody Service service){
        service.setId(0);

        Service dbService = serviceRepository.save(service);
        return dbService;
    }

    //verilen service idsini hangi doktorlar verir apisi
    @GetMapping("/service/{serviceId}/doctors")
    public  List<Doctor> findDoctorsByServiceId(@PathVariable Integer serviceId){
        Service service = serviceRepository.findById(serviceId).get();
        List<Doctor> doctorList = service.getDoctors();




        return doctorList;


    }








}




