package com.jamiltonquintero.layer.business.service.impl;

import com.jamiltonquintero.layer.business.service.IUserService;
import com.jamiltonquintero.layer.common.exception.UserException;
import com.jamiltonquintero.layer.common.util.constant.UserConstant;
import com.jamiltonquintero.layer.domain.entity.User;
import com.jamiltonquintero.layer.persistence.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        var optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()){
            throw new UserException(HttpStatus.NOT_FOUND,
                    String.format(UserConstant.TASK_NOT_FOUND_MESSAGE_ERROR, id));
        }

        return optionalUser.get();
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(User user) {
       return userRepository.save(user);
    }

}
