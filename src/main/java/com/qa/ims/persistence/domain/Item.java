package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {

	
	private Long id;
	private String itemName;
	private Float price;

	// constructor without id
	public Item(String itemName,float price) {
		this.setItemName (itemName);
		this.setPrice (price);
	}

	// constructor with id
	public Item(Long id, String itemName, Float price) {
		this.id = id;
		this.setItemName (itemName);
		this.setPrice (price);
	}

	// getters & setters
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

	@Override
	public String toString() {
		return "id:" + id + " itemName " + itemName + " price: " + price;
	}

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