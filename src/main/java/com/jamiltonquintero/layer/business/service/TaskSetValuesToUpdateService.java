package com.jamiltonquintero.layer.business.service;

import com.jamiltonquintero.layer.domain.dto.request.TaskRequest;
import com.jamiltonquintero.layer.domain.dto.request.UserRequest;
import com.jamiltonquintero.layer.domain.entity.Task;
import com.jamiltonquintero.layer.domain.entity.User;
import org.springframework.stereotype.Service;

@Service
public class TaskSetValuesToUpdateService {

    public void execute(TaskRequest request, Task currentTask){
        currentTask.setName(request.getName());
        currentTask.setDescription(request.getDescription());
        currentTask.setTimeRequiredToComplete(request.getTimeRequiredToComplete());
    }

}
