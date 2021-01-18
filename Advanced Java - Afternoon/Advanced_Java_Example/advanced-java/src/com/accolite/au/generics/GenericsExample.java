package com.accolite.au.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericsExample {
	
	public static void main(String[] args) {
		GenericsExample genericsExample = new GenericsExample();
//		genericsExample.collectionWithoutGenerics();
		
		// simple generic
//		genericsExample.printEverything("Hey", 2);
		
		// generic type bounds
//		genericsExample.addBoundedGeneric(Integer.valueOf(20), Double.valueOf(20.097));
//		genericsExample.addBoundedGeneric("Hello", Double.valueOf(20.097));

		// polymorphic arguments
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("Seltos"));
//		genericsExample.polymorphicArgumentIssue(cars);
		
		// wildcards
//		List<Bike> bikes = new ArrayList<>();
//		bikes.add(new Bike("RE"));
//		genericsExample.wildcardsUpperBound(bikes);
		List<Vehicle> bikes = new ArrayList<Vehicle>();
		bikes.add(new Bike("Street Twin"));
		genericsExample.wildcardsLowerBound(bikes);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	void collectionWithoutGenerics() {
		// storing different types of data in list
		List al = new ArrayList();
		al.add("Hey");
		al.add(Integer.valueOf(2));
		System.out.println(al);
		
		// fetching values
//		String strValue =  (String) al.get(1);
//		Integer intValue = (Integer) al.get(0);
		
		List<String> al1 = new ArrayList<>();
//		al1.add(Integer.valueOf(2));
//		String s = al1.get(1);
	}
	
	@SuppressWarnings("unused")
	void collectionsWithGenerics() {
		List<Integer> list = new ArrayList<>();
		// list.add("Hello");
	}
	
	<T, G> void printEverything(T t, G g) {
		System.out.println(t.getClass().getName());
		
		// What do you think is the type of G?
		System.out.println(g.getClass().getName());
	}
	
	@SuppressWarnings("unchecked")
	<T extends Number & Comparable<T>, G extends Number> void addBoundedGeneric(
			T num1, G num2) {
		System.out.println(num1.doubleValue() + num2.doubleValue());
		System.out.println(num1.compareTo((T) Integer.valueOf(10)));
	}
	
	void polymorphicArgumentIssue(Collection<Vehicle> vehicles) {
		for(Vehicle vehicle:vehicles) {
			vehicle.printName();
		}
	}
	
	void wildcardsUpperBound(Collection<? extends Vehicle> vehicles) {
		for(Vehicle vehicle:vehicles) {
			vehicle.printName();
		}
	}
	
	void wildcardsLowerBound(Collection<? super Car> vehicles) {
		for(Object vehicle:vehicles) {
			((Vehicle)vehicle).printName();
		}
	}
}
