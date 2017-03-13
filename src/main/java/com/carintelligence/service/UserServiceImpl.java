package com.carintelligence.service;

import java.util.List;

import com.carintelligence.model.User;
import com.carintelligence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Project: carintelligence
 * Created by Leonardo Simoza on 09/3/17.
 **/
@Service("userService")
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserRepository userRepository;


    public User find(Long userId)
    {
        // Returns the User for given userId.
        return userRepository.find(userId);
    }


    @Transactional
    public User save(User user)
    {
        // Saves the given user object and returns the same.
        userRepository.save(user);
        return user;
    }


    @Override
    public List<User> findAll()
    {
        // Returns all the users in our system.
        return userRepository.findAll();
    }


    @Transactional
    public User update(User user, Long userId)
    {
        // Updates the user with the given userId;
        return userRepository.update(user, userId);
    }


    @Transactional
    public User delete(Long userId)
    {
        // Deletes the user with the give userId and returns the same.
        return userRepository.delete(userId);
    }


    @Override
    public List<User> paginate(int offset, int limit)
    {
        // Paginates the users objects. 
        return userRepository.paginate(offset, limit);
    }

}
