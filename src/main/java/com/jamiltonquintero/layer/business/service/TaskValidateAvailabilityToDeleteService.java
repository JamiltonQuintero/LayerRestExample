package com.jamiltonquintero.layer.business.service;

import com.jamiltonquintero.layer.common.exception.UserException;
import com.jamiltonquintero.layer.common.util.constant.TaskConstant;
import com.jamiltonquintero.layer.domain.entity.Task;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class TaskValidateAvailabilityToDeleteService {

    public void execute(Task task) {

        if(!task.getUsers().isEmpty()){
            throw new UserException(HttpStatus.BAD_REQUEST,
                    String.format(TaskConstant.CURRENT_TASK_NOT_ALLOW_TO_DELETE, task.getId()));
        }
    }

}
