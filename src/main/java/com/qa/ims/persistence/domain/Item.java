package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {

	// Fields
	private Long id;
	private String itemName;
	private Float price;

	// 1. Constructor Generated from Using Fields
	public Item(Long id, String itemName, Float price) {
		this.id = id;
		this.setItemName (itemName);
		this.setPrice (price);
	}

	// 2. Constructor Generated from Using Fields
	public Item(String itemName,float price) {
		this.setItemName (itemName);
		this.setPrice (price);
	}
	
	// Generated Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	// Generate to String
	
	@Override
	public String toString() {
		return "id:" + id + " itemName " + itemName + " price: " + price;
	}
	
	// Generate to hashCode
	@Override
	public int hashCode() {
		return Objects.hash(id,itemName, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return id == other.id && Objects.equals(itemName, other.itemName)
				&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price);
	}


}
