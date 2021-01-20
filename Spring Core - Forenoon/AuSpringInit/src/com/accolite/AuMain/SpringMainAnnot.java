package com.accolite.AuMain;

import com.accolite.ModelAnnotaions.Bike;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;

@ComponentScan(basePackages = "com.accolite")
public class SpringMainAnnot {
    public static void main(String[] args) {
        AbstractApplicationContext context= new AnnotationConfigApplicationContext(SpringMainAnnot.class);
        Bike bike = context.getBean(Bike.class);
        bike.getBikeBreak().applyBreak();
        context.close();
    }
}