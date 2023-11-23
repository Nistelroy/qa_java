package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    public static final int KITTENS_ONE = 1;

    @Mock
    Feline mocFeline = new Feline();

    @Test
    public void getKittensMethodCallReturnOne() throws Exception {
        Lion lion = new Lion("Самец", mocFeline);
        Mockito.when(lion.getKittens()).thenReturn(KITTENS_ONE);
        Assert.assertEquals("количество в потомстве не совпадает", KITTENS_ONE, lion.getKittens());
    }

    @Test
    public void getFoodMethodCallReturnListMeat() throws Exception {
        Lion lion = new Lion("Самец", mocFeline);
        List<String> foodLion = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(lion.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(foodLion, lion.getFood());
    }
}