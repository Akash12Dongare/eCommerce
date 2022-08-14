/**
 * 
 */
package com.eCommerce.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Akash.d
 *
 */
@Entity
@Table(name = "stock_trn")
public class StockTRN implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_id")
	private Integer pkId;

	@Column(name = "product_id")
	private String productId;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "book_qty")
	private double bookQuntity;

	@Column(name = "created_on", insertable = true, updatable = false)
	private String createdOn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "email", insertable = false, updatable = false)
	private UserTRN user;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
	private StockMST stock;

	public StockTRN() {

	}

	public StockTRN(String productId, String userId, double bookQuntity) {
		this.productId = productId;
		this.userId = userId;
		this.bookQuntity = bookQuntity;
	}

	public Integer getPkId() {
		return pkId;
	}

	public void setPkId(Integer pkId) {
		this.pkId = pkId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public double getBookQuntity() {
		return bookQuntity;
	}

	public void setBookQuntity(double bookQuntity) {
		this.bookQuntity = bookQuntity;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public UserTRN getUser() {
		return user;
	}

	public void setUser(UserTRN user) {
		this.user = user;
	}

	public StockMST getStock() {
		return stock;
	}

	public void setStock(StockMST stock) {
		this.stock = stock;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "StockTRN [pkId=" + pkId + ", productId=" + productId + ", userId=" + userId + ", bookQuntity="
				+ bookQuntity + ", createdOn=" + createdOn + ", user=" + user + ", stock=" + stock + "]";
	}

}
