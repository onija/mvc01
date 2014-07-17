package com.example.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
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
		if (customers.size() != 0) {
			c.setId(customers.get(customers.size() - 1).id + 1);
		}
		customers.add(c);
		saveCustomers();
	}

	@Override
	public void removeCustomer(int id) {
		int find_id = 0, i;
		for (i = 0; i < customers.size(); i++) {
			if (customers.get(i).id == id)
				find_id = i;
		}
		customers.remove(find_id);
		saveCustomers();
	}

	private void saveCustomers() {
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
