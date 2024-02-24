package com.adminPanel.doctorAdmin.Controller;

import com.adminPanel.doctorAdmin.Entity.Rapor;
import com.adminPanel.doctorAdmin.Request.RaporCreatRequest;
import com.adminPanel.doctorAdmin.ServiceLayer.RaporService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rapor")
public class RaporController {
    @Autowired
    RaporService raporService;

    @GetMapping
    public List<Rapor> getAllRapor(){
        return raporService.getAllRapors();
    }
    @PostMapping
    public Rapor createOneRapor(
                                @RequestParam("data") MultipartFile data,
                                @RequestParam("doctorName") String doctorName,
                                @RequestParam("userName")String userName) throws IOException {
        RaporCreatRequest raporCreatRequest = new RaporCreatRequest();
        raporCreatRequest.setData(data);
        raporCreatRequest.setDoctorName(doctorName);
        raporCreatRequest.setUserName(userName);


        return raporService.createOneRapor(raporCreatRequest);
    }


}
