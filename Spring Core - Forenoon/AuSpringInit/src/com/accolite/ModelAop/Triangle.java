package com.accolite.ModelAop;

public class Triangle implements Shape{
    private String shapeName;

    public String getShapeName() { return shapeName; }
    public void setShapeName(String shapeName) { this.shapeName = shapeName; }

    @Override
    public void printShapeName() {
        System.out.println("Triangle name: " + shapeName);
    }
}
