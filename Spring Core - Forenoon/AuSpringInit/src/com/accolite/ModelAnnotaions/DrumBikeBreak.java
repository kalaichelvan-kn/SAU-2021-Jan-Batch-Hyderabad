package com.accolite.ModelAnnotaions;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DrumBikeBreak implements BikeBreak {
    @Override
    public void applyBreak(){
        System.out.println("bike drum break applied");
    }
}
