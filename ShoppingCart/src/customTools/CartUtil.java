package customTools;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Cart;

public class CartUtil {
	public static void insert(Cart cart) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.persist(cart);
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		em.close();
		}
		}

		public static void update(Cart cart) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.merge(cart);
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		em.close();
		}
		}
}
