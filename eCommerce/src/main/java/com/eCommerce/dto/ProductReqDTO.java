/**
 * 
 */
package com.eCommerce.dto;

/**
 * @author Akash.d
 *
 */
public class ProductReqDTO {

	private String productId;
	private double quntity;

	public ProductReqDTO() {

	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public double getQuntity() {
		return quntity;
	}

	public void setQuntity(double quntity) {
		this.quntity = quntity;
	}

}
