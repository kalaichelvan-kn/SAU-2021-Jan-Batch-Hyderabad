package com.accolite.au.annotations;

public class Annotations implements Runnable {

	public static void main(String[] args) {
		Annotations annotations = new Annotations();
		
		// functional interface
//		annotations.functionalInterface();
		annotations.customAnnotation();
	}
	
	@Override
	public void run() {
		// marking method with @Override ensures the we never have a 
		// scenario where sub class doesn't have expected method
	}

	void functionalInterface() {
		MathFunctionalInterface adder = (a, b) -> a + b;
		MathFunctionalInterface multiplier = (a, b) -> a * b;
		System.out.println(adder.operate(2, 3));
		System.out.println(multiplier.operate(2, 3));
	}
	
	void customAnnotation() {
		Vegetable veggie = new Vegetable("Carrot", "Orange");
		try {
			System.out.println(NameChanger.changeNames(veggie));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
