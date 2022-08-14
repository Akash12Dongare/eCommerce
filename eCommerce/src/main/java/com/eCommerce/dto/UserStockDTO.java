/**
 * 
 */
package com.eCommerce.dto;

/**
 * @author Akash.d
 *
 */
public class UserStockDTO {

	private Integer orderId;
	private String email;
	private String name;
	private String productId;
	private String productName;
	private double orderQty;
	private String orderDate;

	public UserStockDTO() {

	}

	public UserStockDTO(Integer orderId, String email, String name, String productId, String productName,
			double orderQty, String orderDate) {
		this.orderId = orderId;
		this.email = email;
		this.name = name;
		this.productId = productId;
		this.productName = productName;
		this.orderQty = orderQty;
		this.orderDate = orderDate;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(double orderQty) {
		this.orderQty = orderQty;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

}
