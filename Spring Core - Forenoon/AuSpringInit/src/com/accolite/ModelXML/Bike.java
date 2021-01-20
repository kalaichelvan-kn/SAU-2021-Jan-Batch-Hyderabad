package com.accolite.ModelXML;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Bike implements InitializingBean, DisposableBean {
    BikeBreak bikeBreak;

    public  BikeBreak getBikeBreak(){
        return bikeBreak;
    }
    public void setBikeBreak(BikeBreak bikeBreak){
        this.bikeBreak = bikeBreak;
    }
    public void initBean(){ System.out.println("Bean init"); }
    public void destroyBean(){ System.out.println("Bean destroy"); }

    @Override
    public void afterPropertiesSet() throws Exception { System.out.println("inner initialization"); }
    @Override
    public void destroy() throws Exception { System.out.println("inner destroy"); }
}