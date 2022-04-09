package com.case_study.service.user_role;

import com.case_study.model.User;
import org.apache.juli.logging.Log;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    Iterable<User> saveAll(Iterable<User> users);

    Optional<User> findByUserName(String userName);

    List<User> findAll();

    void delete(User user);

    UserDetails loadUserByUsername(String userName);
}

