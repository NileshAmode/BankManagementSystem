package bank;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/with")
public class WithdrawServlet extends HttpServlet {
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
			
			if(bal<sbal)
			{
				   req.setAttribute("msg", "Not  Sufficient Balance!!!!");
				   req.getRequestDispatcher("WithDrawSucc.jsp").forward(req, resp);;
			}
			else
			{
				 cb.setAmount(bal-sbal);
				 int k = new UpdateDAO().update(cb);
				 if(k>0)
				 {
					 req.getServletContext().setAttribute("cbean", cb);
					 req.setAttribute("bal", sbal);
					 req.getRequestDispatcher("WithDrawSucc.jsp").forward(req, resp);
				 }
				 else
				 {
					 req.setAttribute("msg", "Withdrow Failed");
					 req.getRequestDispatcher("WithDrawSucc.jsp").forward(req, resp);
				 }
			}
			
		}
	}

}
