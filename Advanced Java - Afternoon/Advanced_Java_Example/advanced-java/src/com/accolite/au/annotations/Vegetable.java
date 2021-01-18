package com.accolite.au.annotations;

public class Vegetable {

	@DefaultVal(size=3)
	String name;
	
	@DefaultVal(changedName = "vegetableColor1", size=4)
	String color;

	public Vegetable(String name, String color) {
		this.name = name;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Vegetable [name=" + name + ", color=" + color + "]";
	}
	
	
}
