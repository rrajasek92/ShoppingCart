package ShoppingCart;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cart;
import model.Product;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cartDB(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cartDB(request,response);
	}
	public void cartDB(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		EntityManager em = customTools.DBUtil.getEmFactory().createEntityManager();

		if (!request.getParameter("prodID").equals("null")){
		String productID=request.getParameter("prodID");
		String quantity= request.getParameter("quantity");
		int quantityInt=Integer.parseInt(quantity);
		String q0= "Select p from Product p where p.productid= :id";
		TypedQuery<Product> q1 = em.createQuery(q0, Product.class);
		Product myProduct = q1.setParameter("id", productID).getSingleResult();
		insertCartItem.cartDB(myProduct, quantityInt);
		}
		String query = "Select c from Cart c";
		TypedQuery<Cart> q = em.createQuery(query, Cart.class);
		String tableinfo="";
		List<Cart> cartList = null;
		double total=0;
		int l=0;
		cartList = q.getResultList();
		for(int i=0;i<cartList.size();i++)
		{
			
			tableinfo += "<tr><td>" + cartList.get(i).getQuantity()+"</td><td>" + cartList.get(i).getProdid()+"</td><td>" + cartList.get(i).getProductname()+"</td><td>" + cartList.get(i).getPrice()+"</td><td>"+cartList.get(i).getSubtotal()+"</td></tr>";
			total+=cartList.get(i).getSubtotal();
			l++;
		}
		
		
		
		
		request.setAttribute("tableinfo", tableinfo);
		request.setAttribute("total",total);
		request.setAttribute("items",l);
		try {
			getServletContext().getRequestDispatcher("/Cart.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
