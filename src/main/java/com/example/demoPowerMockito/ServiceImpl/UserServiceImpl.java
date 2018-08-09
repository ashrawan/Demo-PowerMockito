package com.example.demoPowerMockito.ServiceImpl;

import com.example.demoPowerMockito.Service.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements User {

    // constructor
    public UserServiceImpl() {
        System.out.println("Spy Instantiate real object, constructor called");
    }

    private int getAge() {
        return 20;
    }

    @Override
    public int getSecret() {
        return getAge();
    }

    public static String getClassCode() {
        return "User000";
    }

    public final String getInfo(){
        return "final method";
    }

}
