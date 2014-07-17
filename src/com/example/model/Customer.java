package com.example.model;

import java.io.Serializable;

public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
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
