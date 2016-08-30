package com.epam.dp.factory;

import com.epam.dp.decorator.BeanPostProcessor;
import com.epam.dp.decorator.InjectRandomInt;

/**
 * Created by Oleg_Gondar on 8/30/2016.
 */

@Component("TestClass")
public class TestClass implements BeanPostProcessor {


    @InjectRandomInt
    int test;

    public void setTest(int test) {
        this.test = test;
    }

    @Override
    public void showInt(){
        System.out.println("Value in TestClass is: " + test);
    }
}
