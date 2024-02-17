package com.adminPanel.doctorAdmin.ServiceLayer;

import com.adminPanel.doctorAdmin.Entity.Talep;
import com.adminPanel.doctorAdmin.Entity.User;
import com.adminPanel.doctorAdmin.Repository.TalepRepository;
import com.adminPanel.doctorAdmin.Request.TalepCreatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TalepService {
    @Autowired
    TalepRepository talepRepository;
    @Autowired
    UserService userService;




    public List<Talep> getAllTalep(Optional<Integer> userId) {
        if (userId.isPresent())
            return talepRepository.findByUserId(userId.get());
        return talepRepository.findAll();
    }

    public Talep createOneTalep(TalepCreatRequest newTalepRequest) {
        User user=  userService.getOneUser(newTalepRequest.getUserId());

        if(user==null)
            return null;
        Talep talep = new Talep();
        talep.setId(newTalepRequest.getId());
        talep.setText(newTalepRequest.getText());
        talep.setUser(user);
        return talepRepository.save(talep);

    }
}
