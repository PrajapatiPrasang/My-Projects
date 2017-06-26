package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String FirstName=request.getParameter("fn");
		String LastName=request.getParameter("ln");
		String Email=request.getParameter("email");
		String Password=request.getParameter("password");
		String BirthDate=request.getParameter("birthdate");
		String Gender=request.getParameter("gender");
		
		
		RegistrationVO RegistrationVO =new RegistrationVO();
		
		RegistrationVO.setFirstname(FirstName);
		RegistrationVO.setLastname(LastName);
		RegistrationVO.setEmail(Email);
		RegistrationVO.setPassword(Password);
		RegistrationVO.setBirthdate(BirthDate);
		RegistrationVO.setGender(Gender);
		
		
		RegistrationDAO RegistrationDAO =new RegistrationDAO();
		RegistrationDAO.insert(RegistrationVO);
		
		
		
	}

}
