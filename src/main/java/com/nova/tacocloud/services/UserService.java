package com.nova.tacocloud.services;

import com.nova.tacocloud.dao.UserRepository;
import com.nova.tacocloud.domain.User;
import com.nova.tacocloud.dto.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepo;

    public void save(RegistrationForm form){
        userRepo.save(new User(form.getUsername(), passwordEncoder.encode(form.getPassword()), form.getFullname(), form.getStreet(),
                form.getCity(), form.getState(), form.getZip(), form.getPhone()));
    }
}
