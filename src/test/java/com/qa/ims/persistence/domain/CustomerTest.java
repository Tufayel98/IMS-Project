package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerTest {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Customer.class).verify();
	}

	@Test
	public void toStringTest() {
		Customer customer = new Customer(1L, "Mohammed", "Ahmed");
		String expected = "id:1 first name:Mohammed surname:Ahmed";
		assertEquals(expected, customer.toString());
	}

	@Test
	public void firstConstructorTest() {
		Customer customer = new Customer("Jack", "Daniels");
		assertEquals("Jack", customer.getFirstName());
		assertEquals("Daniels", customer.getSurname());

	}

	@Test
	public void secondConstructorTest() {
		Customer customer = new Customer(1L, "Michael", "Jackson");
		assertEquals(Long.valueOf("1"), customer.getId());
		assertEquals("Michael", customer.getFirstName());
		assertEquals("Jackson", customer.getSurname());
	}
	
}
