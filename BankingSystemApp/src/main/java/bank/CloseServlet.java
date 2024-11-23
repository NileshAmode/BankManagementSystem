package bank;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/close")
public class CloseServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		String  username = req.getParameter("uname");
		String  pass = req.getParameter("pword");
		long  acc = Long.parseLong(req.getParameter("acc"));
		
		System.out.println("Hllo  ");
		System.out.println(username);
		CustomerBean cb = new BalanceDAO().bal(acc, username, pass);
		if(cb!=null)
		{
			int k = new  CloseDAO().close(cb);
			if(k>0)
			{
				req.setAttribute("msg", "User  Account  Close Successfully ......");
				   req.getRequestDispatcher("DepositSucc.jsp").forward(req, resp);
			}
			else
			{
				req.setAttribute("msg", "User  Account  not  Closed do to some  Error......");
				   req.getRequestDispatcher("DepositSucc.jsp").forward(req, resp);
			}
		}
		else
		{
			req.setAttribute("msg", "User  Not  Found");
			   req.getRequestDispatcher("DepositSucc.jsp").forward(req, resp);
		}
	}

}
