package com.adminPanel.doctorAdmin.ServiceLayer;

import com.adminPanel.doctorAdmin.Entity.Doctor;
import com.adminPanel.doctorAdmin.Entity.Rapor;
import com.adminPanel.doctorAdmin.Entity.User;
import com.adminPanel.doctorAdmin.Repository.RaporRepository;
import com.adminPanel.doctorAdmin.Request.RaporCreatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.print.Doc;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RaporService {
    @Autowired
    RaporRepository raporRepository;

    @Autowired
    UserService userService;
    @Autowired
    DoctorService doctorService;

    public List<Rapor> getAllRapors() {

        return raporRepository.findAll();
    }
    public Rapor createOneRapor(RaporCreatRequest raporCreatRequest) throws IOException {
        List<User> userList = userService.getAllUsers();
        List<Doctor> doctorList = doctorService.getAllDoctors();
        int size = userList.size();
        Rapor rapor = new Rapor();
        for(int i=0;i<size;i++){
           User user = userList.get(i);

            if(Objects.equals(user.getName(), raporCreatRequest.getUserName())){
                rapor.setUser(user);
                break;
            }

        }
        int size1 = doctorList.size();
        for(int i=0;i<size1;i++){
            Doctor doctor = doctorList.get(i);

            if(Objects.equals(doctor.getName(), raporCreatRequest.getDoctorName())){
                rapor.setDoctor(doctor);

                break;
            }


        }
        if(rapor.getDoctor() == null && rapor.getUser()==null)
        {
            return null;
        }
        rapor.setData(raporCreatRequest.getData().getBytes());



        return raporRepository.save(rapor);

    }

}
