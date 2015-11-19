package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PRODUCTS database table.
 * 
 */
@Entity
@Table(name="PRODUCTS", schema="TESTUSERDB")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String productid;

	private String description;

	private double price;

	private String productname;

	public Product() {
	}

	public String getProductid() {
		return this.productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

}