package com.adminPanel.doctorAdmin.Controller;


import com.adminPanel.doctorAdmin.Entity.Doctor;
import com.adminPanel.doctorAdmin.Entity.Service;
import com.adminPanel.doctorAdmin.Repository.DoctorRepository;
import com.adminPanel.doctorAdmin.Repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class DoctorController {

    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    ServiceRepository serviceRepository;



    // Get all doctors
    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
    @GetMapping("/doctors/{doctorId}")
    public Doctor getDoctorById(@PathVariable Integer doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).get();
        return doctor;
    }

    @PostMapping("/doctors")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        Doctor _doctor;
        _doctor = doctorRepository.save(doctor);
        return new ResponseEntity<>(_doctor, HttpStatus.CREATED);
    }


    //istenen doktora idsine göre services atamak
    @PostMapping("/doctors/{doctorId}/services")
    public ResponseEntity<Doctor> addServiceToDoctor(@PathVariable Integer doctorId, @RequestBody Service service) {
        Doctor doctor = doctorRepository.findById(doctorId).get();
        if (doctor == null) {
            return ResponseEntity.notFound().build();
        }
        // doktorların servisleri içinde dolaş ama hangi doktorların bana id ile gelen doktorların eğer bana post edilen service id si doktorun zaten hali hazırında servisinde varsa
        // zaten kayıtlı diye dön
        //        yoksa post et
        //

        List<Service> serviceList =  doctor.getService();

        int size= serviceList.size();
        int i ;
        for(i=0;i<size;i++){

            if(doctor.getService().equals(serviceList.get(i))){
                return ResponseEntity.badRequest().build();
            }
        }






        serviceList.add(service);


        doctorRepository.save(doctor);
        return ResponseEntity.ok(doctor);
    }
    //verilen doktor idsinden o doktorun verdiği hizmetlere ulaşma apisi
    @GetMapping("/doctors/{doctorId}/services")
    public  List<Service> findServicesByDoctorsId(@PathVariable Integer doctorId){
        Doctor doctor = doctorRepository.findById(doctorId).get();
        List<Service> serviceList = doctor.getService();



        return serviceList;


    }
    @DeleteMapping("/doctors/{doctorId}")
    void  DeleteDoctorById(@PathVariable Integer doctorId){
        Doctor doctor = doctorRepository.findById(doctorId).get();
        doctorRepository.delete(doctor);

    }



}










