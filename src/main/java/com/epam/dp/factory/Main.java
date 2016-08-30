package com.epam.dp.factory;

import com.epam.dp.decorator.ApplicationContext;

/**
 * @author Ivan_Zhuravel
 */
public class Main {

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException {

        BeanFactory factory = new BeanFactory();
//        SomeClass someClass =
//                (SomeClass) factory.getBean("SomeClass");
//        System.out.println(someClass.getTest());
        ApplicationContext applicationContext = new ApplicationContext(factory);
        TestClass testClass = (TestClass) applicationContext.getBean("TestClass");

        testClass.showInt();
       AnotherTestClass anotherTestClass = (AnotherTestClass) applicationContext.getBean("AnotherTestClass");
        anotherTestClass.showInt();

    }
}
