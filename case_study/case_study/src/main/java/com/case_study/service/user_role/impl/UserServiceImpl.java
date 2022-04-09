package com.case_study.service.user_role.impl;

import com.case_study.model.Role;
import com.case_study.model.User;
import com.case_study.repository.user_role.UserRepository;
import com.case_study.service.user_role.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Iterable<User> saveAll(Iterable<User> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return Optional.ofNullable(userRepository.findByUsername(userName));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException  {
        User user = userRepository.findByUsername(userName);

        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<Role> roles = user.getRoles();
        for (Role role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), grantedAuthorities
        );
    }
}
