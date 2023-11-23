package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Spy
    Cat cat = new Cat(new Feline());

    @Test
    public void getSoundMethodCallOneCall() {
        cat.getSound();
        Mockito.verify(cat, Mockito.times(1)).getSound();
    }

    @Test
    public void getSoundMethodCallReturnCatSound() {
        String catSound = "Мяу";
        assertEquals("Голос кошки не совпадает с 'мяу'", catSound, cat.getSound());
    }

    @Test
    public void getFoodMethodCallOneCall() throws Exception {
        cat.getFood();
        Mockito.verify(cat, Mockito.times(1)).getFood();
    }

    @Test
    public void getFoodMethodCallReturnList() throws Exception {
        List<String> foodCat = List.of("Животные", "Птицы", "Рыба");
        assertEquals("Голос кошки не совпадает с 'мяу'", foodCat, cat.getFood());
    }
}