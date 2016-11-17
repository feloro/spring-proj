package com.myapp.service

import com.myapp.database.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by istomin.a on 16.11.2016.
 */
@Service
class AuthService {

    @Autowired
    UserRepository userRepository;

    public ArrayList getUsers(){
        return userRepository.findAll();
    }
}
