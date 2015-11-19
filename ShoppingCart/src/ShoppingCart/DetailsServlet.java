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
 * Servlet implementation class DetailsServlet
 */
@WebServlet("/DetailsServlet")
public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		detailsDB(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		detailsDB(request,response);
	}
	public void detailsDB(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		EntityManager em = customTools.DBUtil.getEmFactory().createEntityManager();
		String productName = request.getParameter("prod");
		String query = "Select p from Product p where p.productname = :name";
		TypedQuery<Product> q = em.createQuery(query, Product.class);
		Product myProduct = q.setParameter("name", productName).getSingleResult();
		ProductJB productBean = new ProductJB();
		productBean.setProductid(myProduct.getProductid());
		productBean.setProductname(myProduct.getProductname());
		productBean.setPrice(myProduct.getPrice());
		productBean.setDescription(myProduct.getDescription());
		request.setAttribute("productList", productBean);
		
		try {
			getServletContext().getRequestDispatcher("/ProductDetails.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
