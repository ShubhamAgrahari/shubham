package com.jlcindia.hibernate;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Lab32B {

	public static void main(String[] args) {
		
		Transaction tx=null;
		try {
			SessionFactory sf= HibernateUtil.getSessionFactory();
			Session session= sf.openSession();
			tx=session.beginTransaction();
			
			String hql= "from Customer32 cust where cust.city=? ";
            Query query=session.createQuery(hql);
			query.setString(0,"Blanglore");
			List<Customer32> list=query.list();
			
			for(Customer32 cust: list)
			{
				System.out.println(cust);
			}
			
			tx.commit();
			session.close();
			
			
		} catch (Exception e) {
			
			if(tx!=null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}

	}

}
