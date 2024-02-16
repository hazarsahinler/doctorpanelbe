package com.adminPanel.doctorAdmin.Controller;

import com.adminPanel.doctorAdmin.Entity.Demand;
import com.adminPanel.doctorAdmin.Entity.Doctor;
import com.adminPanel.doctorAdmin.Entity.Service;
import com.adminPanel.doctorAdmin.Repository.DoctorRepository;
import com.adminPanel.doctorAdmin.Repository.DemandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemandController {
    @Autowired
    DemandRepository demandRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @GetMapping("/doctors/{doctorId}/demands")
    public  ResponseEntity<List<Demand>> getAllDemandsByDoctorId(@PathVariable(value = "doctorId") Integer doctorId){
        if (!doctorRepository.existsById(doctorId)) {
            throw new ResourceNotFoundException("Not found Tutorial with id = " + doctorId);
        }
        List<Demand> demands = demandRepository.findDemandsByDoctorId(doctorId);
        return new ResponseEntity<>(demands, HttpStatus.OK);





    }
    @PostMapping("/doctors/{doctorId}/demands")
    public ResponseEntity<Demand> addDemandToDoctor(@PathVariable Integer doctorId, @RequestBody Demand demandRequest) {
        Demand demand1 = doctorRepository.findById(doctorId).map(doctor -> {
            demandRequest.setDoctor(doctor);
            return demandRepository.save(demandRequest);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found Doctor with id = " + doctorId));

        return new ResponseEntity<>(demand1, HttpStatus.CREATED);
    }
    @DeleteMapping("/demands/{demandId}")
    void  DeleteDemandsById(@PathVariable Integer demandId){
        Demand demand = demandRepository.findById(demandId).get();
        demandRepository.delete(demand);

    }


}












