package com.adminPanel.doctorAdmin.Controller;

import com.adminPanel.doctorAdmin.Entity.Rapor;
import com.adminPanel.doctorAdmin.Request.RaporCreatRequest;
import com.adminPanel.doctorAdmin.Response.RaporResponse;
import com.adminPanel.doctorAdmin.ServiceLayer.RaporService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rapor")
public class RaporController {
    @Autowired
    RaporService raporService;

    @GetMapping
    public ResponseEntity<List<RaporResponse>> getListFiles() {
        List<RaporResponse> files = raporService.getAllFiles().map(dbFile -> {
            String url = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/rapor/")
                    .path(dbFile.getId())
                    .toUriString();

            return new RaporResponse(
                    url,
                    dbFile.getDoctor().getId(),
                    dbFile.getUser().getId());


        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }
    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getRapor(@PathVariable String id) {
        Rapor rapor = raporService.getRapor(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + rapor.getUser() + "\"")
                .body(rapor.getData());
    }


    @PostMapping("/upload")
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
