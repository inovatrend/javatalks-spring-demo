package com.example.javatalks;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class UserManagerImpl implements UserManager {

    private UserRepository repository;

    public UserManagerImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getUser(Long userId) {
        return repository.findOne(userId);
    }

    @Override
    @Transactional
    public User saveUser(User user) {

        User userSaved = repository.save(user);

        //za testiranje transakcije odkomentiraj liniju ispod ovog komentara
        // u slucaju greske, user nece biti spremljen u bazu
        // iako je u liniji iznad  uspješno spremljen

//        int a = 5/0;
        return userSaved;
    }

    @Override
    public void deleteUser(Long userId) {
        repository.delete(userId);
    }
}
