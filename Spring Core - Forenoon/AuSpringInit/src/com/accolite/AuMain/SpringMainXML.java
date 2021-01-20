package com.accolite.AuMain;

import com.accolite.ModelXML.Bike;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMainXML {
    public static void main(String[] args) {
        AbstractApplicationContext context= new ClassPathXmlApplicationContext("Spring.xml");
        Bike bike = context.getBean("bike", Bike.class);
        bike.getBikeBreak().applyBreak();
        context.close();
    }
}
