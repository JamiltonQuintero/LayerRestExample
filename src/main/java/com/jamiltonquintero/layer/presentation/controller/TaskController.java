package com.jamiltonquintero.layer.presentation.controller;

import com.jamiltonquintero.layer.business.facade.ITaskFacade;
import com.jamiltonquintero.layer.domain.dto.TaskDto;
import com.jamiltonquintero.layer.domain.dto.request.TaskRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final ITaskFacade iTaskFacade;

    public TaskController(ITaskFacade iTaskFacade) {
        this.iTaskFacade = iTaskFacade;
    }

    @GetMapping("/{id}")
    public TaskDto getById(@PathVariable Long id){
        return iTaskFacade.getById(id);
    }

    @GetMapping
    public List<TaskDto> getAll() {
        return iTaskFacade.getAll();
    }

    @PostMapping()
    public TaskDto create(@RequestBody TaskRequest taskRequest){
        return iTaskFacade.createNew(taskRequest);
    }

    @PutMapping("/{id}")
    public TaskDto edit(@RequestBody TaskRequest taskRequest,
                               @PathVariable Long id){
        return iTaskFacade.update(taskRequest, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        iTaskFacade.deleteById(id);
    }

}
