package DAO;

import org.hibernate.SessionFactory;
import java.util.ArrayList; 
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.RegistrationVO;
import VO.loginVO;

public class loginDAO {
	public int add_login(loginVO loginVO) 
	{
		// TODO Auto-generated method stub
		int login_id = -1;
		try
		{
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		session.save(loginVO);
		login_id = loginVO.getLogin_id();
		transaction.commit();
		session.flush();
		session.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}	
		return login_id;
	
	}
	public void updatelogin(loginVO loginVO) 
	{
		Session session = null;
		try
		{
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query q=session.createQuery("update loginVO set Email = '"+loginVO.getEmail()+"', password='"+loginVO.getPassword()+"' where login_id='"+loginVO.getLogin_id()+"'");
		int result = q.executeUpdate();
		
		
		session.flush();
        session.clear();
		transaction.commit();
		sessionFactory.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
	        session.close();
		}
	
		
	}
	public List authentication(loginVO loginVO)
	{
		// TODO Auto-generated method stub
		List<loginVO> list_of_user=new ArrayList<loginVO>();
		try{
				
				SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
				Session session=sessionFactory.openSession();
				Transaction transaction=session.beginTransaction();
				
				Query q=session.createQuery("from loginVO where Email='"+loginVO.getEmail()+"' and password='"+loginVO.getPassword()+"'");
				list_of_user=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_user;
	}
	public List fetchName(loginVO loginVO)
	{
		// TODO Auto-generated method stub
		List<loginVO> list_of_user=new ArrayList<loginVO>();
		try{
				
				SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
				Session session=sessionFactory.openSession();
				Transaction transaction=session.beginTransaction();
				
				Query q=session.createQuery("from RegistrationVO where loginvo='"+loginVO.getLogin_id()+"'");
				list_of_user=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_user;
	}
	public List forgetPassword(RegistrationVO RegistrationVO)
	{
		List ls=null;
		try{
			Session session = null;
			SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
			session = sessionfactory.openSession();
			Query q =  session.createQuery("from RegistrationVO where Email='"+RegistrationVO.getEmail()+"'"); 
			ls =  q.list();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return ls; 
	}
	public void updatePassword(RegistrationVO RegistrationVO) 
	{
		Session session = null;
		try
		{
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query q=session.createQuery("update loginVO set password = '"+RegistrationVO.getPassword()+"' where Email='"+RegistrationVO.getRegistrationid()+"'");
		q.executeUpdate();
		session.flush();
        session.clear();
		transaction.commit();
		sessionFactory.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
	        session.close();
		}
	
		
	}
	public void delete(loginVO loginVO) {
		// TODO Auto-generated method stub
		try{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			Query q=session.createQuery("delete loginVO where Email='"+loginVO.getEmail()+"'");
			q.executeUpdate();
			transaction.commit();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
}
}
