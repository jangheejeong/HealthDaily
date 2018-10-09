package com.jang.healthdaily.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class User {

    @Test
    public void signup() {
        System.out.println("signup");
    }

    @Test
    public void signin() {
        System.out.println("signin");
    }

}
