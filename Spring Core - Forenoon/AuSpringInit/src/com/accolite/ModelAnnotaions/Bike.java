package com.accolite.ModelAnnotaions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Bike {
    @Autowired
    private BikeBreak bikeBreak;

    public Bike(){
    }
    public Bike(BikeBreak bikeBreak){
        this.bikeBreak = bikeBreak;
    }
    public void setBikeBreak(BikeBreak bikeBreak) {
        System.out.println("settter");
        this.bikeBreak = bikeBreak;
    }
    public BikeBreak getBikeBreak() {
        System.out.println("gettter");
        return bikeBreak;
    }
}