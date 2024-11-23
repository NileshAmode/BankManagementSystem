package bank;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/deposit")
public class DepositServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		long acc = Long.parseLong(req.getParameter("acc"));
		String username = req.getParameter("uname");
		String pword = req.getParameter("pword");
		
		BalanceDAO bd = new BalanceDAO();
		CustomerBean cb = bd.bal(acc, username, pword);
		if(cb ==null)
		{
			 req.setAttribute("msg", "user not  found");
			 req.getRequestDispatcher("Message.jsp").forward(req, resp);
		}
		else
		{
			long bal  = cb.getAmount();
			long sbal = Long.parseLong(req.getParameter("amot"));
			if(sbal>0)
			{
					bal =  bal+sbal;
					cb.setAmount(bal);
					int k = new DepositDAO().deposit(cb);
					if(k>0)
					{
						req.setAttribute("bal", sbal);
						req.getServletContext().setAttribute("cbean", cb);
						req.getRequestDispatcher("DepositSucc.jsp").forward(req, resp);
					}
					else
					{
						req.setAttribute("msg", "Deposit Failed");
						req.getRequestDispatcher("DepositSucc.jsp").forward(req, resp);
					}
			}
			else
			{
				req.setAttribute("msg", "Please enter valid Amount");
				req.getRequestDispatcher("DepositSucc.jsp").forward(req, resp);
			}
			
		}
	}
}
