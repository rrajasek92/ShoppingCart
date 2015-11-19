package ShoppingCart;

import java.io.Serializable;

public class CartJB implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String prodid;

	private String productname;

	private int quantity;

	private double subtotal;

	public CartJB() {
	}

	public String getProdid() {
		return this.prodid;
	}

	public void setProdid(String prodid) {
		this.prodid = prodid;
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
