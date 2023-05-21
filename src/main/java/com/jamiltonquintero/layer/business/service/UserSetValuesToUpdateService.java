package com.jamiltonquintero.layer.business.service;

import com.jamiltonquintero.layer.domain.dto.request.UserRequest;
import com.jamiltonquintero.layer.domain.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserSetValuesToUpdateService {

    public void execute(UserRequest request, User currentUser){
        currentUser.setName(request.getName());
        currentUser.setAge(request.getAge());
        currentUser.setCountry(request.getCountry());
    }

}
