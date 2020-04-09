package com.eflu.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Person {

	private int id;
	private String name;
	private String nickName;
	private Country country;
	private City city;

	public City getCity() {
		return city;
	}
	
	@Autowired
	public void setCity(City city) {
		this.city = city;
	}

	public Country getCountry() {
		return country;
	}

	@Autowired
	@Qualifier("country2")
	public void setCountry(Country country) {
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
