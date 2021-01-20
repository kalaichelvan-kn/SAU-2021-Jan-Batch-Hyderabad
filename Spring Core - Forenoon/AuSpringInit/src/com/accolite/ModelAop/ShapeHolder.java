package com.accolite.ModelAop;

public class ShapeHolder {
    private Shape shape;
    private Shape shape2;

    public Shape getShape1() { return shape; }
    public void setShape(Shape shape) { this.shape = shape; }
    public  void printShape(){ shape.printShapeName(); }
    public Shape getShape2() { return shape2; }
    public void setShape2(Shape shape2) { this.shape2 = shape2; }
}