package com.accolite.au.streams;

import java.util.Arrays;
import java.util.List;

public class LambdaExample {

	interface Ops {
		int operate(int a, int b);
	}
	
	public static void main(String[] args) {
		LambdaExample lambdaExample = new LambdaExample();
//		lambdaExample.traditionalImpl();
//		lambdaExample.lambdaImpl();
		// extending functional interfaces
//		lambdaExample.extendFuncInterface();
//		lambdaExample.whereNotToUseLambda();
	}

	void traditionalImpl() {
		Ops op = new Ops() {
			@Override
			public int operate(int a, int b) {
				return a + b;
			}
		};
		
		System.out.println(op.operate(2, 3));
	}
	
	void lambdaImpl() {
		Ops op = (a, b) -> a + b;
		System.out.println(op.operate(2, 3));
	}
	
	private void extendFuncInterface() {
		// Can we extend functional interfaces?
		// If so why do we want to extend?
		
		// CommonOps commonOps = ...
	}
	
	private void whereNotToUseLambda() {
		List<String> strs = Arrays.asList("A", "b", "C");
		strs.stream().map(s -> s.toLowerCase()).forEach(s -> System.out.println(s));

		// instead use method reference
		strs.stream().map(String::toLowerCase).forEach(System.out::println);
	}
}
