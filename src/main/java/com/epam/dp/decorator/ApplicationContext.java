package com.epam.dp.decorator;

import com.epam.dp.factory.BeanFactory;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.Set;

/**
 * Created by Oleg_Gondar on 8/30/2016.
 */
public class ApplicationContext {

    private Reflections annScan = new Reflections("com.epam.dp.factory", new FieldAnnotationsScanner());

    BeanFactory beanFactory;


    public ApplicationContext(BeanFactory beanFactory){
        this.beanFactory = beanFactory;
    }

    public Object getBean(final String id) throws ClassNotFoundException, IllegalAccessException {


        Object o = beanFactory.getBean(id);

        if(o instanceof BeanPostProcessor){
            Set<Field> fieldSet = annScan.getFieldsAnnotatedWith(com.epam.dp.decorator.InjectRandomInt.class);
            for (Field f: fieldSet
                 ) {
                f.setAccessible(true);
                f.setInt(o, new Random().nextInt(10));

            }

        }

        return o;
    }

}
