package com.twoqubed.sjug.profile;

public class MyProductionService implements MyService {

    public void saySomething() {
        System.out.println("I should only be used in development");
    }
}
