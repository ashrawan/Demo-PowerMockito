package com.example.demoPowerMockito.ServiceImpl;

import com.example.demoPowerMockito.Service.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements User {

    // constructor
    public UserServiceImpl() {
        System.out.println("Spy Instantiate real object, constructor called");
    }

    private int getSome(int a, int b) {
        return a+b;
    }

    @Override
    public int getSecret() {
        return getSome(1, 2);
    }

    public static String getClassCode() {
        return "User000";
    }

    public final String getInfo(){
        return "final method";
    }

}
