package com.asherflo.testing;

import com.asherflo.testing.domain.Role;
import com.asherflo.testing.domain.User;
import com.asherflo.testing.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class TestingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestingApplication.class, args);

    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
@Bean
CommandLineRunner run(UserService userService){
        return  args -> {
            userService.saveRole(new Role(null,"ROLE_USER"));
            userService.saveRole(new Role(null,"ROLE_MANAGER"));
            userService.saveRole(new Role(null,"ROLE_ADMIN"));
            userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null,"john smith","john","1234",new ArrayList<>()));
            userService.saveUser(new User(null,"grace love","lovlyn","1234",new ArrayList<>()));
            userService.saveUser(new User(null,"zoe Mercy","exotic","1234",new ArrayList<>()));
            userService.saveUser(new User(null,"God faith","faithful","1234",new ArrayList<>()));


            userService.addRoleToUser("john","ROLE_USER");
            userService.addRoleToUser("exotic","ROLE_MANAGER");
            userService.addRoleToUser("lovlyn","ROLE_MANAGER");
            userService.addRoleToUser("faithful","ROLE_USER");
            userService.addRoleToUser("faithful","ROLE_ADMIN");
            userService.addRoleToUser("faithful","ROLE_SUPER_ADMIN");
        };
    }
}

