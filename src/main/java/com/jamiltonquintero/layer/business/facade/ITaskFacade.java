package com.jamiltonquintero.layer.business.facade;

import com.jamiltonquintero.layer.domain.dto.TaskDto;
import com.jamiltonquintero.layer.domain.dto.request.TaskRequest;

import java.util.List;

public interface ITaskFacade {

    TaskDto createNew(TaskRequest request);
    TaskDto getById(Long id);
    List<TaskDto> getAll();
    void deleteById(Long id);
    TaskDto update(TaskRequest request, Long id);

}
