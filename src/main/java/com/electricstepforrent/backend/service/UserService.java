package com.electricstepforrent.backend.service;

import com.electricstepforrent.backend.model.User;
import com.electricstepforrent.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User createUser(User user) {
        return repo.save(user);

        }



        public boolean deleteUser(Long id) {
            if (repo.existsById(id)) {
                repo.deleteById(id);
                return true;
            }
            return false;
        }


}