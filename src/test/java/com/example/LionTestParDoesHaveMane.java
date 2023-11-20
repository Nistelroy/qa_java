package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Spy;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTestParDoesHaveMane {
    private final String hasMane;
    private final Boolean expected;

    @Spy
    Feline feline;

    public LionTestParDoesHaveMane(String hasMane, Boolean expected) {
        this.hasMane = hasMane;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"someInvalidValue", null}
        };
    }

    @Test
    public void doesHaveManeBooleanOrException() {
        try {
            Lion lion = new Lion(hasMane, feline);
            if (expected != null) {
                assertEquals(expected, lion.doesHaveMane());
            } else {
                fail("Ожидалось исключение");
            }
        } catch (Exception e) {
            if (expected == null) {
                assertEquals("Используйте допустимые значения пола животного - Самец или Самка", e.getMessage());
            } else {
                fail("Не ожидалось исключение " + e);
            }
        }
    }
}

