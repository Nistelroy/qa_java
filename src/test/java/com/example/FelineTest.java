package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    public static final int KITTENS_ONE = 1;

    @Spy
    Feline spyFeline;

    @Test
    public void eatMeatMethodCallReturnListMeat() throws Exception {
        List<String> foodFeline = List.of("Животные", "Птицы", "Рыба");
        assertEquals("Голос кошки не совпадает с 'мяу'", foodFeline, spyFeline.eatMeat());
    }

    @Test
    public void getFamilyMethodCallReturnFamily() {
        String family = "Кошачьи";
        assertEquals("Голос кошки не совпадает с 'Кошачьи'", family, spyFeline.getFamily());
    }

    @Test
    public void getKittensOneKittensReturnOne() {
        Assert.assertEquals("количество детей не совпадает", KITTENS_ONE, spyFeline.getKittens(KITTENS_ONE));
    }

    @Test
    public void getKittensNoArgumentMethodCall() {
        spyFeline.getKittens();
        Mockito.verify(spyFeline, Mockito.times(1)).getKittens();
    }
}