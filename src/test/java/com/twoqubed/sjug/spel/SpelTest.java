package com.twoqubed.sjug.spel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import static org.junit.Assert.assertEquals;

public class SpelTest {

    private ExpressionParser parser;

    @Before
    public void setUp() {
        parser = new SpelExpressionParser();
    }

    @Test
    public void testPublicMethodAccess() {
        Expression exp = parser.parseExpression("'Hello World'.bytes.length");
        int length = (Integer) exp.getValue();

        assertEquals(11, length);
    }
}
