package com.case_study.config;

import com.case_study.model.Role;
import com.case_study.model.User;
import com.case_study.repository.user_role.RoleRepository;
import com.case_study.repository.user_role.UserRepository;
import com.case_study.ultil.EncrypPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (roleRepository.findByRoleName("ROLE_ADMIN")==null){
            roleRepository.save(new Role("ROLE_ADMIN"));
        }

        if (roleRepository.findByRoleName("ROLE_MEMBER")==null){
            roleRepository.save(new Role("ROLE_MEMBER"));
        }
        if (roleRepository.findByRoleName("ROLE_BLOCK")==null){
            roleRepository.save(new Role("ROLE_BLOCK"));
        }

        //them admin
        if (userRepository.findByUsername("admin") == null){
            User admin = new User();
            admin.setUsername("admin");
//            admin.setUsername("admin");
            admin.setPassword(EncrypPasswordUtils.EncrypPasswordUtils("123456"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByRoleName("ROLE_ADMIN"));
            roles.add(roleRepository.findByRoleName("ROLE_MEMBER"));
            admin.setRoles(roles);
            userRepository.save(admin);
        }

        //Them Member
        if (userRepository.findByUsername("member") == null){
            User user = new User();
            user.setUsername("member");
//            user.setUsername("toan");
            user.setPassword(EncrypPasswordUtils.EncrypPasswordUtils("123456"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByRoleName("ROLE_MEMBER"));
            user.setRoles(roles);
            userRepository.save(user);
        }
    }
}
