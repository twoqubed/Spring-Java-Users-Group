package com.twoqubed.sjug.spel;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Properties;

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
    }
}
