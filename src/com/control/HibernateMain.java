package com.control;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.to.OrderItem;
import com.to.ProductItem;

public class HibernateMain {
	
	public static void MainCreateOrder(Date date, String name) {
		try {
			Configuration configuration = new Configuration().configure();
			configuration.addAnnotatedClass(com.to.OrderItem.class);
			StandardServiceRegistryBuilder builder = 
					new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			SessionFactory factory = configuration.buildSessionFactory(builder.build());
			
			Session session=factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			OrderItem o1 = new OrderItem(date, name);
			session.save(o1);
			transaction.commit();
			session.close();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void MainDeleteOrder(int id) {
		try {
			Configuration configuration = new Configuration().configure();
			configuration.addAnnotatedClass(com.to.OrderItem.class);
			StandardServiceRegistryBuilder builder = 
					new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			SessionFactory factory = configuration.buildSessionFactory(builder.build());
			
			Session session=factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			OrderItem o1 = (OrderItem) session.get(OrderItem.class, id);
			session.delete(o1);
			
			
			transaction.commit();
			session.close();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void MainCreateProduct(String name) {
		try {
			Configuration configuration = new Configuration().configure();
			configuration.addAnnotatedClass(com.to.OrderItem.class);
			StandardServiceRegistryBuilder builder = 
					new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			SessionFactory factory = configuration.buildSessionFactory(builder.build());
			
			Session session=factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			ProductItem p1 = new ProductItem(name);
			session.save(p1);
			transaction.commit();
			session.close();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void MainDeleteProduct(int id) {
		try {
			Configuration configuration = new Configuration().configure();
			configuration.addAnnotatedClass(com.to.OrderItem.class);
			StandardServiceRegistryBuilder builder = 
					new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			SessionFactory factory = configuration.buildSessionFactory(builder.build());
			
			Session session=factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			ProductItem p1 = (ProductItem) session.get(ProductItem.class, id);
			session.delete(p1);
			
			
			transaction.commit();
			session.close();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void main(String[] args) {
		MainCreateProduct("Shoes");
//		
//		try {
//		Configuration configuration = new Configuration().configure();
//		configuration.addAnnotatedClass(com.to.Player.class);
//		StandardServiceRegistryBuilder builder = 
//				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
//		SessionFactory factory = configuration.buildSessionFactory(builder.build());
//		
//		Session session=factory.openSession();
//		Transaction transaction = session.beginTransaction();
//		
//		Player p1 = new Player(10, "Amit", "India", 30);
//		session.save(p1);
//		transaction.commit();
//		session.close();
//		}
//		catch(Exception ex) {
//			System.out.println(ex.getMessage());
//		}
	}
}
