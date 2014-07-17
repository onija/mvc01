package com.example.model;

import java.util.List;

public interface DAOCustomer {
	public List<Customer> getAllCustomers();
	public void addCustomer(Customer c);
}
