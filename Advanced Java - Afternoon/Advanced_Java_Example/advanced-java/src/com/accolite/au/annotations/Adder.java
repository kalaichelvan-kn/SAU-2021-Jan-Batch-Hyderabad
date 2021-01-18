package com.accolite.au.annotations;

public class Adder implements MathFunctionalInterface {

	@Override
	public int operate(int a, int b) {
		return a+b;
	}

}
