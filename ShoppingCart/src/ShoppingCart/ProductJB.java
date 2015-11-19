package ShoppingCart;

import java.io.Serializable;

public class ProductJB implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String productid;

	private String description;

	private double price;

	private String productname;
	
	public ProductJB(){
		
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}
	
	
}
