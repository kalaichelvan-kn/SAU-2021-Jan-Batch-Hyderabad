package com.accolite.au.generics;

public class Vehicle {

	String name;
	Vehicle(String name) {
		this.name = name;
	}
	
	void printName() {
		System.out.println(this.name);
	}
}
