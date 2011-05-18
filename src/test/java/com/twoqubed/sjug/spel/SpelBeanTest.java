package com.twoqubed.sjug.spel;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class SpelBeanTest {

    private static Properties properties;

    @BeforeClass
    public static void cacheSystemProperties() {
        properties = System.getProperties();
    }

    @AfterClass
    public static void resetSystemProperties() {
        System.setProperties(properties);
    }

    @Test
    public void testSystemProperty() {
        System.setProperty("my.property", "foo");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spel-context.xml");
        SpelBean spelBean = context.getBean("spelBean", SpelBean.class);

        assertEquals("foo", spelBean.getName());
    }

    @Test
    public void testSystemPropertyForAnnotation() {
        System.setProperty("my.annotation.property", "bar");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spel-context.xml");
        SpelPropertyBean spelPropertyBean = context.getBean("spelPropertyBean", SpelPropertyBean.class);

        assertEquals("bar", spelPropertyBean.getAnnotationProperty());
    }
}
