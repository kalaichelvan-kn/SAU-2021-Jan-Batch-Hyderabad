package com.accolite.au.xmlprocessing;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Assignment {

	String name;
	
	String review;
	
	int id;
	
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public String getReview() {
		return review;
	}
	@XmlElement
	public void setReview(String review) {
		this.review = review;
	}
	public int getId() {
		return id;
	}
	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Assignment [name=" + name + ", review=" + review + ", id=" + id + "]";
	}
}