package DAO;

import java.util.ArrayList; 
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.RegistrationVO;


public class RegistrationDAO {
	public List<RegistrationVO> authentication_email(RegistrationVO RegistrationVO)
	{
		// TODO Auto-generated method stub
		List<RegistrationVO> list_of_user=new ArrayList<RegistrationVO>();
		try{
				
				SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
				Session session=sessionFactory.openSession();
				Transaction transaction=session.beginTransaction();
				
				Query q=session.createQuery("from RegistrationVO where Email='"+RegistrationVO.getEmail()+"'");
				list_of_user=q.list();
				transaction.commit();
				System.out.println("aaaaaaaaaaaassssssssssss");
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_user;
	}
	public void insert(RegistrationVO RegistrationVO)
	{
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			session.save(RegistrationVO);
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
	}
}
