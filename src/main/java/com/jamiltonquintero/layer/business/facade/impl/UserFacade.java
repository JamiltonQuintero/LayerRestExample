package com.jamiltonquintero.layer.business.facade.impl;

import com.jamiltonquintero.layer.business.facade.IUserFacade;
import com.jamiltonquintero.layer.business.mapper.UserDtoMapper;
import com.jamiltonquintero.layer.business.mapper.UserRequestMapper;
import com.jamiltonquintero.layer.business.service.ITaskService;
import com.jamiltonquintero.layer.business.service.IUserService;
import com.jamiltonquintero.layer.business.service.UserSetValuesToUpdateService;
import com.jamiltonquintero.layer.business.service.UserValidateAvailabilityToAssignService;
import com.jamiltonquintero.layer.business.service.UserValidateAvailabilityToDeleteService;
import com.jamiltonquintero.layer.domain.dto.UserDto;
import com.jamiltonquintero.layer.domain.dto.request.UserRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserFacade implements IUserFacade {

    private final IUserService iUserService;
    private final ITaskService iTaskService;
    private final UserRequestMapper userRequestMapper;
    private final UserDtoMapper userDtoMapper;
    private final UserValidateAvailabilityToAssignService userValidateAvailabilityToAssignService;
    private final UserSetValuesToUpdateService userSetValuesToUpdateService;
    private final UserValidateAvailabilityToDeleteService userValidateAvailabilityToDeleteService;

    public UserFacade(IUserService iUserService,
                      ITaskService iTaskService,
                      UserRequestMapper userRequestMapper,
                      UserDtoMapper userDtoMapper,
                      UserValidateAvailabilityToAssignService userValidateAvailabilityToAssignService, UserSetValuesToUpdateService userSetValuesToUpdateService, UserValidateAvailabilityToDeleteService userValidateAvailabilityToDeleteService) {
        this.iUserService = iUserService;
        this.iTaskService = iTaskService;
        this.userRequestMapper = userRequestMapper;
        this.userDtoMapper = userDtoMapper;
        this.userValidateAvailabilityToAssignService = userValidateAvailabilityToAssignService;
        this.userSetValuesToUpdateService = userSetValuesToUpdateService;
        this.userValidateAvailabilityToDeleteService = userValidateAvailabilityToDeleteService;
    }

    public UserDto createNew(UserRequest request){
        var userRequest = userRequestMapper.toDomain(request);
        var userCreated = iUserService.create(userRequest);
        return userDtoMapper.toDto(userCreated);
    }

    public UserDto getById(Long id){

        var user = iUserService.getById(id);

        return userDtoMapper.toDto(user);
    }

    public List<UserDto> getAll(){
        var users = iUserService.getAll();

        return users
                .stream()
                .map(userDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id){

        var user = iUserService.getById(id);

        userValidateAvailabilityToDeleteService.execute(user);

        iUserService.deleteById(id);
    }

    public UserDto update(UserRequest request, Long id){

        var userToUpdate = userRequestMapper.toDomain(request);

        userSetValuesToUpdateService.execute(request,userToUpdate);

        var userUpdated = iUserService.update(userToUpdate);

        return userDtoMapper.toDto(userUpdated);
    }

    public void assignTasks(Long id, List<Long> tasksIds) {

        var user = iUserService.getById(id);

        var tasksToDo = iTaskService.getByIds(tasksIds);

        userValidateAvailabilityToAssignService.execute(new ArrayList<>(user.getTasks()), tasksToDo);

        user.getTasks().addAll(tasksToDo);

        iUserService.update(user);

    }

}
