package com.accolite.ModelAnnotaions;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class DiscBikeBreak implements BikeBreak {
    @Override
    public void applyBreak(){ System.out.println("bike disc break applied"); }
}
