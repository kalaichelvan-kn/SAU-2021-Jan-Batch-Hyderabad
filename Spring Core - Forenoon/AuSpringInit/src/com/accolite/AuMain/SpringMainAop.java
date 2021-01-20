package com.accolite.AuMain;

import com.accolite.ModelAop.ShapeHolder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMainAop {
    public static void main(String[] args) {
        AbstractApplicationContext abstractApplicationContext = new ClassPathXmlApplicationContext("SpringAop.xml");
        ShapeHolder shapeHolder = abstractApplicationContext.getBean("shapeHolder", ShapeHolder.class);
        shapeHolder.getShape1().printShapeName();
        shapeHolder.getShape2().printShapeName();
        abstractApplicationContext.close();
    }
}
