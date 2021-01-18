package com.accolite.au.streams;

public class Brand {

	String name;
	Integer valuation;
	
	public Brand(String name, Integer valuation) {
		super();
		this.name = name;
		this.valuation = valuation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValuation() {
		return valuation;
	}

	public void setValuation(Integer valuation) {
		this.valuation = valuation;
	}
	
}
