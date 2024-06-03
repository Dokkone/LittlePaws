package com.rijai.users.repository;

import com.rijai.users.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository <User, Integer> {
//    User findByUsernameAndPassword(String email, String password);
    // Working
        User findByEmail(String email);
}