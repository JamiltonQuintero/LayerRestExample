package com.jamiltonquintero.layer.business.service;

import com.jamiltonquintero.layer.common.exception.UserException;
import com.jamiltonquintero.layer.common.util.constant.TaskConstant;
import com.jamiltonquintero.layer.common.util.constant.UserConstant;
import com.jamiltonquintero.layer.domain.entity.Task;
import com.jamiltonquintero.layer.domain.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class UserValidateAvailabilityToDeleteService {

    public void execute(User user) {

        if(!user.getTasks().isEmpty()){
            throw new UserException(HttpStatus.BAD_REQUEST,
                    String.format(UserConstant.CURRENT_USER_NOT_ALLOW_TO_DELETE, user.getName()));
        }
    }

}
