package com.qa.ims.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {
	
	public static final Logger Logger = LogManager.getLogger();
	
	private OrderDAO orderDAO;
	private Utils utils;
	
	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders= orderDAO.readAll();
		for (Order order : orders) {
			Logger.info(order);
		}
		return null;
	}

	@Override
	public Order create() {
		Logger.info("Enter a Customer ID");
		long customerId = utils.getLong();
		Order order = orderDAO.create(new Order(customerId, customerId, null));
		Logger.info(" created");
		return order;
	}

	@Override
	public Order update() {
		Logger.info(" *********** Please enter the order id you would like to update *********** ");
		Long id = utils.getLong();
		Logger.info(" *********** Please enter the customer id *********** ");
		long newcustomer_id = utils.getLong();
		Order order = orderDAO.read(id);
		order.setCustomerId(newcustomer_id);
		order = orderDAO.update(order);
		Logger.info(" *********** Order Updated *********** ");
		return order;
	}

	@Override
	public int delete() {
		Logger.info(" *********** Enter the id of the order you would like to delete *********** ");
		Long id = utils.getLong();
		return orderDAO.delete(id);
	}

}
