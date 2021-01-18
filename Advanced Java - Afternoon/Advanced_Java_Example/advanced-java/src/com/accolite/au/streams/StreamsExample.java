package com.accolite.au.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample {

	public static void main(String[] args) {
		StreamsExample streamsExample = new StreamsExample();
//		streamsExample.createStreams();
//		streamsExample.iteration();
//		streamsExample.filtering();
//		streamsExample.mapping();
//		streamsExample.matching();
		streamsExample.reduction();
//		streamsExample.collecting();
	}

	private void createStreams() {
		// from arrays
		String[] arr = new String[]{"a", "b", "c"};
		Stream<String> arrStream = Arrays.stream(arr);
		
		// from collections
		List<String> list = new ArrayList<>();
		list.add("a");
		Stream<String> listStream = list.stream();
		
		// Using Stream API
		Stream<String> stream = Stream.of("a", "b", "c");
		
		// using stream builder
		Stream<String> builder = Stream.<String>builder().add("a").add("b").build();
		System.out.println(stream);
		// why is a reference pipeline printed here?
	}
	
	
	private void iteration() {
		List<String> carBrands = Arrays.asList("Mercedes", "BMW", "Audi");
		
		// traditional looping
		for(String brand: carBrands) {
			System.out.println(brand);
		}
		carBrands.stream().forEach(System.out::println);
	}
	
	private void filtering() {
		List<String> carBrands = Arrays.asList("Mercedes", "BMW", "Audi", "Maserati");
		long mCount = carBrands.stream().filter(s -> s.startsWith("M")).count();
		System.out.println(mCount + " car brands start with M");
	}
	
	private void mapping() {					
		List<String> carBrands = Arrays.asList("Mercedes", "BMW", "Audi", "Maserati");
		carBrands.stream().map(String::toUpperCase).forEach(System.out::println);
	}
	
	private void matching() {
		List<String> carBrands = Arrays.asList("Mercedes", "Ferrari", "Audi", "Maserati");
		boolean allHaveE = carBrands.stream().allMatch(s -> s.contains("e"));
		boolean anyHasE = carBrands.stream().anyMatch(s -> s.contains("e"));
		System.out.println(allHaveE + " " + anyHasE);
	}
	
	private void reduction() {
		List<Integer> hp = Arrays.asList(450, 600, 350, 550);
		int totalHp = hp.parallelStream().reduce((a, b) -> a+b).orElse(0);
		
		System.out.println("Combined horse power: " + totalHp);
	}
	
	private void collecting() {
		Brand merc = new Brand("Mercedes", 200);
		Brand bmw = new Brand("BMW", 200);
		List<Brand> carBrands = Arrays.asList(merc, bmw);
		
		Map<String, Integer> brandValuationMap = carBrands.stream()
				.collect(Collectors.toMap(Brand::getName, Brand::getValuation));
		System.out.println(brandValuationMap);
	}
}
