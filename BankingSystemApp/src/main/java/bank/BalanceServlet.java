package bank;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/bal")
public class BalanceServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		long acc = Long.parseLong(req.getParameter("acc"));
		String username = req.getParameter("uname");
		String pword = req.getParameter("pword");
		
		BalanceDAO bd = new BalanceDAO();
		CustomerBean bal = bd.bal(acc, username, pword);
		if(bal ==null)
		{
			 req.setAttribute("msg", "user not  found");
			 req.getRequestDispatcher("Message.jsp").forward(req, resp);
		}
		else
		{
			req.getServletContext().setAttribute("cbean", bal);
			req.getRequestDispatcher("Regsucc.jsp").forward(req, resp);
		}
	}

}
