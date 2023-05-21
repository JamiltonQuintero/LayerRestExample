package com.jamiltonquintero.layer.business.facade;

import com.jamiltonquintero.layer.domain.dto.UserDto;
import com.jamiltonquintero.layer.domain.dto.request.UserRequest;

import java.util.List;

public interface IUserFacade {

    UserDto createNew(UserRequest request);
    UserDto getById(Long id);
    List<UserDto> getAll();
    void deleteById(Long id);
    UserDto update(UserRequest request, Long id);
    void assignTasks(Long id, List<Long> tasksIds);

}
