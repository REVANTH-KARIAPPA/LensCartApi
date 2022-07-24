package com.LensCart.service;

import com.LensCart.entity.User;
import com.LensCart.exception.UserNotFoundException;
import com.LensCart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return new ArrayList<>(userRepository.findAll());
    }
    public User getUserById(long id){
        Optional<User> users=userRepository.findById(id);
        if(users.isPresent()){

            return userRepository.findById(id).get();
        }
        else{
            throw new UserNotFoundException("Get Operation failed \n No User Found with id : "+id);
        }
    }
    public void deleteUser(long id)
    {
        Optional<User> users=userRepository.findById(id);
        if(users.isPresent()){
            userRepository.deleteById(id);
        }
        else{
            throw new UserNotFoundException("Delete Operation failed \n No User Found with id : "+id);
        }
    }
    public void createUser(User user){
        userRepository.save(user);
    }



}
