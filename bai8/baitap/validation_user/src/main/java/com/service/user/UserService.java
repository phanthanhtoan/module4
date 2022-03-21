package com.service.user;

import com.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<User> findALl(Pageable pageable);
    void saveUser(User user);
    void deleteUser(Long id);
    User findUserById(Long id);
    Page<User> findByEmail(String email, Pageable pageable);
}
