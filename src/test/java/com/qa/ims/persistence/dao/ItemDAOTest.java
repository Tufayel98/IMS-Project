package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {

	private final ItemDAO DAO = new ItemDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void createTest() {
		final Item created = new Item(2L, "Hublot", 10000.00F);
		assertEquals(created, DAO.create(created));
		assertEquals(null, DAO.create(null));
	}
	
	@Test
	public void readAllTest() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(2L, "Rolex", 5000.00F));
		assertEquals(expected, DAO.readAll());
	}

	//@Test
	//public void readLatestTest() {
	//	assertEquals(new Item(2L, "Rolex", 5000.00F), DAO.readLatest());
	//}

	@Test
	public void readTest() {
		final long ID = 2L;
		assertEquals(new Item(ID, "Rolex", 5000.00f), DAO.read(ID));
		assertEquals(null, DAO.read(null));
	}

	@Test
	public void deleteTest() {
		assertEquals(1, DAO.delete(2L));
		assertEquals(0, DAO.delete(0L));
	}

	
	@Test
	public void updateTest() {
		final Item updated = new Item(2L, "Rolex", 5000.00F);
		assertEquals(updated, DAO.update(updated));
	}

}
