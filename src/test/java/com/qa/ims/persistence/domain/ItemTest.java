package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ItemTest {

	@Test
	public void toStringTEST() {
		Item item = new Item(2L, "Rolex", 5000.00F);
		String expected = "Item [id=2, itemName=Rolex, price=5000.00]";
		assertEquals(expected, item.toString());
	}

	@Test
	public void firstConstructorTEST() {
		Item item = new Item("Rolex", 5000.00F);
		assertEquals("Rolex", item.getItemName());
		assertEquals(5000.00, item.getPrice(), 0.05);
	}

	@Test
	public void secondConstructorTEST() {
		Item item = new Item(2L, "Rolex",5000.00F);
		assertEquals(Long.valueOf("2"), item.getId());
		assertEquals("Rolex", item.getItemName());
		assertEquals(5000.00, item.getPrice(), 0.05);

	}

	@Test
	public void equalsTEST() {
		EqualsVerifier.simple().forClass(Item.class).verify();
	}

	@Test
	public void setIdTEST() {
		Item item = new Item(2L, "Rolex",5000.00F);
		item.setId(2L);
		assertEquals(Long.valueOf("2"), item.getId());

	}

	@Test
	public void setItemNameTEST() {
		Item item = new Item(2L, "Rolex",5000.00F);
		item.setItemName("Hublot");
		assertEquals("Hublot", item.getItemName());
	}

	@Test
	public void setItemCategoryTEST() {
		Item item = new Item(2L, "Rolex",5000.00F);
	}

	@Test
	public void setPriceTEST() {
		Item item = new Item(2L, "Rolex",5000.00F);
		item.setPrice(5000);
		assertEquals(5000, item.getPrice(), 0.02);
	}

}
