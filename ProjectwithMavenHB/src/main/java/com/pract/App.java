package com.pract;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Project Started");

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Student st = new Student();
		st.setId(104);
		st.setName("Akshay");
		st.setCity("Pune");
		 
		Address ad=new Address();
		ad.setStreet("Street1");
		ad.setCity("Pune");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(1234.234);
		FileInputStream fis=new FileInputStream("src/main/java/asdf.jpg");
		byte[] data=new byte[fis.available()];
		fis.read(data);
		//ad.setImage(data);
		
		Session session=factory.openSession();
		session.beginTransaction();
		session.save(st);
		//session.save(ad);
		session.getTransaction().commit();
		session.close();
		
	}
}


