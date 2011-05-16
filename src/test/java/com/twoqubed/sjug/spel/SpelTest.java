package com.twoqubed.sjug.spel;

import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import static org.junit.Assert.*;

public class SpelTest {

    private ExpressionParser parser;
    private StandardEvaluationContext context;

    @Before
    public void setUp() {
        parser = new SpelExpressionParser();
        context = new StandardEvaluationContext();
    }

    @Test
    public void testPublicMethodAccess() {
        Expression exp = parser.parseExpression("'Hello World'.bytes.length");
        int length = (Integer) exp.getValue();

        assertEquals(11, length);
    }

    @Test
    public void testPropertyAccessOfRootObject() {
        SpelBean bean = new SpelBean();
        bean.setName("foo");
        context.setRootObject(bean);
        
        Expression exp = parser.parseExpression("name");
        String name= (String) exp.getValue(bean);

        assertEquals("foo", name);
    }

    @Test
    public void testParseMathmaticalComparison() {
        assertTrue(parser.parseExpression("2 == 2").getValue(Boolean.class));
        assertTrue(parser.parseExpression("3 > 2").getValue(Boolean.class));
    }

    @Test
    public void testParseMathmaticalOperations() {
        Integer value = parser.parseExpression("1 + 1").getValue(Integer.class);
        assertEquals(new Integer(2), value);

        value = parser.parseExpression("5 % 2").getValue(Integer.class);
        assertEquals(new Integer(1), value);
    }

    @Test
    public void testPropertyAssignment() {
        SpelBean bean = new SpelBean();
        context.setRootObject(bean);

        Expression exp = parser.parseExpression("name");
        exp.setValue(bean, "foo");

        assertEquals("foo", bean.getName());
    }
}
