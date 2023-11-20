package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    public static final int KITTENS_ONE = 1;

    @Spy
    Feline spyFeline = new Feline();

    @Test
    public void getKittensMethodCallReturnOne() throws Exception {
        Lion spyLion = new Lion("Самец", spyFeline);
        Mockito.when(spyLion.getKittens()).thenReturn(KITTENS_ONE);
        Assert.assertEquals("количество в потомстве не совпадает", KITTENS_ONE, spyLion.getKittens());
    }

    @Test
    public void getFoodMethodCallReturnListMeat() throws Exception {
        Lion spyLion = new Lion("Самец", spyFeline);
        List<String> foodLion = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(spyLion.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(foodLion, spyLion.getFood());
    }
}