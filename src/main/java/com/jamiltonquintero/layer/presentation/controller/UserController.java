package com.jamiltonquintero.layer.presentation.controller;

import com.jamiltonquintero.layer.business.facade.IUserFacade;
import com.jamiltonquintero.layer.domain.dto.UserDto;
import com.jamiltonquintero.layer.domain.dto.request.UserRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserFacade iUserFacade;

    public UserController(IUserFacade iUserFacade) {
        this.iUserFacade = iUserFacade;
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable long id){
        return iUserFacade.getById(id);
    }

    @GetMapping
    public List<UserDto> getAll() {
        return iUserFacade.getAll();
    }

    @PostMapping()
    public UserDto create(@RequestBody UserRequest taskRequest){
        return iUserFacade.createNew(taskRequest);
    }

    @PutMapping("/{id}")
    public UserDto userEdit(@RequestBody UserRequest taskRequest,
                               @PathVariable Long id){
        return iUserFacade.update(taskRequest, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id){
        iUserFacade.deleteById(id);
    }

    @PostMapping("/{id}/tasks")
    public void assignTasks(@PathVariable Long id , @RequestParam List<Long> tasksIds){
        iUserFacade.assignTasks(id, tasksIds);
    }

}
