package com.database.DatebaseRelations.onetoone;

import com.database.DatebaseRelations.onetoone.entity.User;
import com.database.DatebaseRelations.onetoone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OneToOneService {

    @Autowired
    UserRepository repository;

    public User addUser(User user) {
        return repository.save(user);
    }

    public List<User> finAllUsers() {
        return repository.findAll();
    }

    public void deleteAllUsers() {
        repository.deleteAll();
    }

}
