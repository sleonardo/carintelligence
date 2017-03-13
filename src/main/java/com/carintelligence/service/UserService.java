package com.carintelligence.service;

import java.util.List;

import com.carintelligence.model.User;

/**
 * Project: carintelligence
 * Created by Leonardo Simoza on 09/3/17.
 **/
public interface UserService {

    User find(Long userId);
    List<User> findAll();
    List<User> paginate(int offset, int limit);
    User save(User user);
    User update(User user, Long userId);
    User delete(Long userId);
}
