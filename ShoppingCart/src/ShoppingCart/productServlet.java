package ShoppingCart;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;



/**
 * Servlet implementation class productServlet
 */
@WebServlet("/productServlet")
public class productServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		productDB(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		productDB(request,response);
		}

	public void productDB(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = customTools.DBUtil.getEmFactory().createEntityManager();
	       String q="select p from Product p ";
		TypedQuery<Product> qT = em.createQuery(q, Product.class);
		List<Product> p_product = null;
		String tableinfo="";
		p_product=qT.getResultList();
		for(int i=0;i<p_product.size();i++){
			tableinfo += "<tr><td>" + p_product.get(i).getProductid()+"</td><td>" + p_product.get(i).getProductname()+"</td><td>" + p_product.get(i).getDescription()+"</td><td>" + p_product.get(i).getPrice()+"</td><td><a href=\"http://localhost:8080/ShoppingCart/DetailsServlet?prod="+p_product.get(i).getProductname()+"\">Buy</a></td></tr>";

		}
		request.setAttribute("tableinfo", tableinfo);
		
	     getServletContext()
	     	.getRequestDispatcher("/ProductList.jsp")
	     		.forward(request, response);
		
		
	}
}
