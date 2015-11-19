package ShoppingCart;

import customTools.CartUtil;
import model.Cart;
import model.Product;

public class insertCartItem {
	
	public static void cartDB(Product product, Integer quantity){
		
		Cart cart= new Cart();
		
		cart.setProdid(product.getProductid());
		cart.setPrice(product.getPrice());
		cart.setProductname(product.getProductname());
		cart.setQuantity(quantity);
		cart.setSubtotal(product.getPrice()*quantity);
		CartUtil.insert(cart);
	}

}
