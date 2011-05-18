package com.twoqubed.sjug.profile;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class SpringProfilesTest {

    private Properties properties;


    @Before
    public void cacheSystemProperties() {
        properties = System.getProperties();
    }

    @After
    public void resetSystemProperties() {
        System.setProperties(properties);
    }

    @Test
    public void shouldLoadDevelopmentBeanBySettingProfileProgramatically() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:profile-context.xml");
        context.getEnvironment().setActiveProfiles("development");
        context.refresh();

        MyService myService = context.getBean("myService", MyService.class);

        assertThat(myService, is(MyDevelopmentService.class));
    }
    
    @Test
    public void shouldLoadDevelopmentBeanBySettingSystemProperty() {
        System.setProperty("spring.profiles.active", "development");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:profile-context.xml");

        MyService myService = context.getBean("myService", MyService.class);

        assertThat(myService, is(MyDevelopmentService.class));
    }

}
