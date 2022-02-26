package com.BrushCircle.model;

public class Cart {
    
	private int cartId;
	private int orderId;
    private String ProductId;
    private String ProductName;
    private String email;
    private String DateAdded;
    private String quantity;
    private String price;

    public Cart(String productId, String productName, String email, String dateAdded, String quantity, String price) {
    super();
    this.ProductId = productId;
    this.ProductName = productName;
    this.email = email;
    this.DateAdded = dateAdded;
    this.quantity = quantity;
    this.price = price;
    }

    public Cart() {
        super();
    }

    public Cart(String email) {
        super();
        this.email = email;
    }

	public int getOrderId() {
		return orderId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		this.ProductName = productName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getProductId() {
		return ProductId;
	}

	public void setProductId(String productId) {
		this.ProductId = productId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateAdded() {
		return DateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.DateAdded = dateAdded;
	}
}
