package Controller;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.RegistrationDAO;
import VO.RegistrationVO;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegistrationController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();
		
		String FirstName=request.getParameter("fn");
		String LastName=request.getParameter("ln");
		String Email=request.getParameter("email");
		String Password=request.getParameter("password");
		String BirthDate=request.getParameter("birthdate");
		String Gender=request.getParameter("gender");
		
		Pattern pa =Pattern.compile("[a-zA-Z0-9_.]*@[a-zA-Z]*.[a-zA-Z]*");
	       Matcher m = pa.matcher(Email);
	       boolean b = m.matches();
			
	     if (FirstName.isEmpty() || LastName.isEmpty() ||Email.isEmpty() || BirthDate.isEmpty() || Gender.isEmpty()|| Password.isEmpty())
		{
			String message= " Please Enter all the Details ";
			request.setAttribute("msg", message);
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			
		}
		else if(b==false)
		{
			String message= " Please Enter Valid Email Address ";
			request.setAttribute("msg", message);
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		
		else{
		
		RegistrationVO RegistrationVO =new RegistrationVO();
		RegistrationDAO RegistrationDAO =new RegistrationDAO();
		RegistrationVO.setFirstName(FirstName);
		RegistrationVO.setLastName(LastName);
		RegistrationVO.setEmail(Email);
		RegistrationVO.setPassword(Password);
		RegistrationVO.setBirthdate(BirthDate);
		RegistrationVO.setGender(Gender);
		
		List<RegistrationVO> list =  RegistrationDAO.authentication_email(RegistrationVO);
		if(list != null && list.size()>=1)
		{
			String message= " Email Id is already registered ";
			request.setAttribute("msg", message);
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		else
		{
		try{
			RegistrationDAO.insert(RegistrationVO);
			System.out.println("after insertion");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		String success= "Successfully Registered";
		request.setAttribute("success", success);
		session.setAttribute("firstname", FirstName);
		session.setAttribute("lastname", LastName);
		System.out.println("before send redirect");
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
		}	
		}
	}

}
