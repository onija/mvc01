package com.example.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.CoffeeExpert;
import com.example.model.Customer;
import com.example.model.DAOCustomerImplementation;

/**
 * Servlet implementation class CustomerController
 */
// @WebServlet("/CustomerController")
@WebServlet(name = "CustomerController", urlPatterns = { "/controller" })
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DAOCustomerImplementation cm = new DAOCustomerImplementation();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Customer> customers = new ArrayList<Customer>();
		if (request.getParameter("name") == null) {
			customers = cm.getAllCustomers();
			request.setAttribute("customers", customers);
			RequestDispatcher view = request
					.getRequestDispatcher("customers.jsp");
			view.forward(request, response);
		} else {
			cm.addCustomer(new Customer(0, request.getParameter("name"),
					request.getParameter("surname"), request
							.getParameter("address"), request
							.getParameter("phone")));
			customers = cm.getAllCustomers();
			request.setAttribute("customers", customers);
			RequestDispatcher view = request
					.getRequestDispatcher("customers.jsp");
			view.forward(request, response);
		}

//		customers
//				.add(new Customer(0, "Jan", "Kowalski", "Wroclaw", "73567456"));
//
//		request.setAttribute("customers", customers);
//		RequestDispatcher view = request.getRequestDispatcher("customers.jsp");
//		view.forward(request, response);
	}

}
