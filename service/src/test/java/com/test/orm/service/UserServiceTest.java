package com.test.orm.service;

import com.test.orm.configuration.JpaConfiguration;
import com.test.orm.model.Role;
import com.test.orm.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfiguration.class})
public class UserServiceTest {

    public static final String ADMIN = "ADMIN";
    @Autowired
    UserService userService;

    @Before
    public void before() {
        System.out.println("==============================");
    }

    @After
    public void after() {
        System.out.println("==============================");
    }

    @Test
    public void getAll() {
        long startTime = System.currentTimeMillis();
        userService.gatAll();
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");
    }

    @Test
    public void saveTest() {
        User user = new User();
        user.setName("Bob");
        user.setEmail("Bob@email.com");
        user.setPassword("123");

        Role admin = new Role();
        admin.setName(ADMIN);
        admin = userService.saveRole(admin);

        Set<Role> roles = new HashSet<>();
        roles.add(userService.findOne(admin.getRoleId()));

        System.out.println("=+=+=+=+=+=+=+=+=");

        user.setRoles(roles);
        user = userService.save(user);
        System.out.println("++++++++++++");

        userService.gatAll().forEach(System.out::println);
    }
}
