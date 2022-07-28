package com.qa.ims.persistence.domain;

public class Order {
	
	private Long id;
	private Long customerId;
	private Long itemId;
	private Integer quantity;
	private Float price;
	
	
	
	// Constructor 1
	public Order(Long id, Long customerId, Long itemId, Integer quantity, Float price) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.itemId = itemId;
		this.quantity = quantity;
		this.price = price;
		
	}
	
	// Constructor 2
	
	public Order(Long id, Long customerId, Long itemId, Integer quantity) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.itemId = itemId;
		this.quantity = quantity;
	}
	
	// Constructor 3
	public Order(Long customerId, Long itemId, Integer quantity) {
		super();
		this.customerId = customerId;
		this.itemId = itemId;
		this.quantity = quantity;
	}

	
// getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customerId=" + customerId + ", price=" + price + ", itemId=" + itemId
				+ ", quantity=" + quantity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}
}
