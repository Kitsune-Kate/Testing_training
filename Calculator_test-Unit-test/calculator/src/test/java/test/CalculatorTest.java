package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    public static HashMap<Integer, Integer> hashMap;
    public static Calculator calculator;

    @BeforeAll
    public static void init() {
        calculator = new Calculator(); //глобальный объект
        hashMap = new HashMap<Integer, Integer>() {{
            put(5, -5);
            put(6, -6);
            put(4, -4);
        }};

    }


    @Test
    void sum() throws InterruptedException {
        for (Map.Entry<Integer, Integer> integerIntegerEntry : hashMap.entrySet()) {
            int sum = calculator.sum(integerIntegerEntry.getKey(), integerIntegerEntry.getValue());
            assertEquals(0, sum);
        }


    }

    @Test
    void division() {
        int division = calculator.division(5, 5);
        assertEquals(1, division);
        assertNotEquals(2, division);
        Throwable thrown = assertThrows(ArithmeticException.class, () -> {
            calculator.division(5, 0);
        });
        assertNotNull(thrown.getMessage());
        System.out.println(thrown.getMessage());

    }


    @Test
    void substruction() {
        int substr = calculator.substruction(2, 5);
        assertEquals(-3, substr);
        assertNotEquals(3, substr);
        if(substr==6){
            Assertions.fail();
        }
    }

    @Test
    void multiplication() {
        int multip = calculator.multiplication(2,2);
        assertEquals(4,multip);
        assertNotEquals(5,multip);
        if(multip==6){
            Assertions.fail();
        }
    }
}