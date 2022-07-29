package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderTest {

	@Test
	public void toStringTEST() {
		Order order = new Order(2L);
		String expected = "Order [id=2, item_id=5,]";
		assertEquals(expected, order.toString());
	}

	@Test
	public void firstConstructorTEST() {
		Order order = new Order(2,5);
		assertEquals("Rolex", order.getId());
		assertEquals(5000.00, order.getCustomer_id(), 2);
	}

	@Test
	public void secondConstructorTEST() {
		Order order = new Order(2L);
		assertEquals(Long.valueOf("2"), order.getId());
		assertEquals("Rolex", order.getId());
		assertEquals(5000.00, order.getCustomer_id(), 2);

	}

	@Test
	public void equalsTEST() {
		EqualsVerifier.simple().forClass(Item.class).verify();
	}

	@Test
	public void setIdTEST() {
		Order order = new Order(2L);
		order.setId(2L);
		assertEquals(Long.valueOf("2"), order.getId());

	}

	@Test
	public void setItemNameTEST() {
		Item item = new Item(2L, "Rolex",5000.00F);
		item.setItemName("Hublot");
		assertEquals("Hublot", item.getItemName());
	}

	@Test
	public void setItemCategoryTEST() {
		Order order = new Order(2L);
	}

	@Test
	public void setPriceTEST() {
		Item item = new Item(2L, "Rolex",5000.00F);
		item.setPrice(5000);
		assertEquals(5000, item.getPrice(), 0.02);

	}
}
	
