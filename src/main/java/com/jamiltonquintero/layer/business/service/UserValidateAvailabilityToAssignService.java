package com.jamiltonquintero.layer.business.service;

import com.jamiltonquintero.layer.business.service.TaskGetRequirementTimeToDoService;
import com.jamiltonquintero.layer.common.exception.UserException;
import com.jamiltonquintero.layer.common.util.constant.UserConstant;
import com.jamiltonquintero.layer.domain.entity.Task;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserValidateAvailabilityToAssignService {

    private final TaskGetRequirementTimeToDoService taskGetRequirementTimeToDoService;

    public UserValidateAvailabilityToAssignService(TaskGetRequirementTimeToDoService taskGetRequirementTimeToDoService) {
        this.taskGetRequirementTimeToDoService = taskGetRequirementTimeToDoService;
    }

    public void execute(List<Task> currentTasks, List<Task> tasksToDo) {

        int totalTimeInTasks = taskGetRequirementTimeToDoService.execute(currentTasks,tasksToDo);

        var isNotAllow = totalTimeInTasks > 8;

        if (isNotAllow){
            throw new UserException(HttpStatus.BAD_REQUEST,
                    String.format(UserConstant.CURRENT_USER_NOT_ALLOW_TO_DO_TASKS, totalTimeInTasks));
        }

    }

}
