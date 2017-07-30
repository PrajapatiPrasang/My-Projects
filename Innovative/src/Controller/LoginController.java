package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.loginDAO;
import VO.RegistrationVO;
import VO.loginVO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session=request.getSession();
		String flag=request.getParameter("flag");
		if(flag.equals("login")){
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			
			loginVO loginVO=new loginVO();
			loginVO.setEmail(email);
			loginVO.setPassword(password);
			
			loginDAO loginDAO = new loginDAO();
			List list =  loginDAO.authentication(loginVO);

			if(list != null && list.size()>=1)
			{	
				loginVO user1=(loginVO) list.get(0);
				String pwd=user1.getPassword();
				String un=user1.getEmail();
				if(pwd.equals(loginVO.getPassword()) && un.equals(loginVO.getEmail())){
				
				int login_id = user1.getLogin_id();
				String Email=user1.getEmail();
				
				session.setAttribute("loginId",login_id);
				session.setAttribute("Email", Email);
				
				loginVO.setLogin_id(login_id);
				RequestDispatcher rd=request.getRequestDispatcher("ProfilePage.jsp");
				rd.forward(request, response);
				}
				else
				{
					request.setAttribute("error", "Not yet Registered");
					RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
			}
				
			else{
					request.setAttribute("error", "Not yet Registered");
					RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
					
			}
			
			
		}
		}

}
