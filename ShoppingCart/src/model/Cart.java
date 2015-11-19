package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the CART database table.
 * 
 */
@Entity
@Table(name="CART", schema="TESTUSERDB")
@NamedQuery(name="Cart.findAll", query="SELECT c FROM Cart c")
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String prodid;

	private double price;

	private String productname;

	private int quantity;

	private double subtotal;

	public Cart() {
	}

	public String getProdid() {
		return this.prodid;
	}

	public void setProdid(String prodid) {
		this.prodid = prodid;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

}