package com.example.model;

public class Customer {
	int id = 0;
	String name = null;
	String surname = null;
	String address = null;
	String phone = null;

	public Customer(int id, String name, String surname, String address,
			String phone) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phone = phone;
	}

	public Customer() {
	}

}
