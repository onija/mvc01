package com.example.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DAOCustomerImplementation implements DAOCustomer {

	private List<Customer> customers = new ArrayList<>();

	public DAOCustomerImplementation() {
		File fc = new File("customers.ser");
		if (fc.exists()) {
			ObjectInputStream ois;
			try {
				ois = new ObjectInputStream(
						new FileInputStream("customers.ser"));
				customers = (List<Customer>) ois.readObject();
				ois.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customers;
	}

	@Override
	public void addCustomer(Customer c) {
		c.setId(customers.size());
		customers.add(c);
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("customers.ser"));
			oos.writeObject(customers);
			oos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void removeCustomer(int id) {
		customers.remove(id);
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("customers.ser"));
			oos.writeObject(customers);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
