package bank;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/new")
public class NewAccountServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		CustomerBean cb = new CustomerBean();
		cb.setUserName(req.getParameter("uname"));
		cb.setPassword(req.getParameter("pword"));
		cb.setAmount(Long.parseLong(req.getParameter("amot")));
		cb.setAddress(req.getParameter("add"));
		cb.setPhono(Long.parseLong(req.getParameter("phono")));
		
		NewAcountDAO nad = new NewAcountDAO();
		int k = nad.register(cb);
		if(k>0)
		{ 
			 // CustomerBean cb1 = nad.find(cb.getUserName());
			CustomerBean cb1 = new NewAcountDAO().find(cb.getUserName());
			  System.out.println(cb1);
			  req.getServletContext().setAttribute("cbean", cb1);
		      req.getRequestDispatcher("Regsucc.jsp").forward(req, resp);
		}
		else
		{
			req.setAttribute("msg", "User Already Registered ...");
			req.getRequestDispatcher("Message.jsp").forward(req, resp);
		}
	}

}
