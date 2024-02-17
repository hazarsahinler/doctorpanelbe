package com.adminPanel.doctorAdmin.Controller;

import com.adminPanel.doctorAdmin.Entity.Talep;
import com.adminPanel.doctorAdmin.Request.TalepCreatRequest;
import com.adminPanel.doctorAdmin.ServiceLayer.TalepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/talep")
public class TalepController {
    @Autowired
    TalepService talepService;

    @GetMapping
    public List<Talep> getAllTalep(@RequestParam Optional<Integer> userId){
        return talepService.getAllTalep(userId);
    }
    @PostMapping
    public Talep createOneTalep(@RequestBody TalepCreatRequest newTalepRequest){
        return talepService.createOneTalep(newTalepRequest);
    }
}
