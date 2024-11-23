package bank;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/trans")
public class TransferServlet extends  HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String username = req.getParameter("uname");
		 String pword = req.getParameter("pword");
		 long sacc = Long.parseLong(req.getParameter("acc"));
		 long reacc = Long.parseLong(req.getParameter("reacc"));
		 long amount = Long.parseLong(req.getParameter("amot"));
		 
		
		 CustomerBean cb  = new TransferDAO().bal(sacc, username, pword);
		 if(cb!=null)
		 {

			 CustomerBean cb1 = new TransferDAO().bal(reacc);
			 if(cb1!=null)
			 {
				 long bal = cb.getAmount();
				 if(bal>amount)
				 {
					  int k = new  TransferDAO().transfer(cb, cb1, amount);
					  if(k==1)
					  {
						  CustomerBean cb2  = new TransferDAO().bal(sacc, username, pword);
						  req.setAttribute("amount", amount);
						   req.getServletContext().setAttribute("reciever", cb1);
						   req.getServletContext().setAttribute("sender", cb2);
						   req.getRequestDispatcher("Transfer.jsp").forward(req, resp);
					  }
					  else
					  {
						  req.setAttribute("msg", "Transaction failed");
						  req.getRequestDispatcher("DepositSucc.jsp").forward(req, resp);
					  }
				 }
				 else
				 {
					 req.setAttribute("msg", "Insufficient  Blance ");
						req.getRequestDispatcher("DepositSucc.jsp").forward(req, resp);
				 }
				 
			 }
			 else
			 {
				 req.setAttribute("msg", "Receiver Account Number Wrong");
				   req.getRequestDispatcher("DepositSucc.jsp").forward(req, resp);
			 }
			 
		 }
		 else
		 {
			 req.setAttribute("msg", "Sender  Account Number Wrong");
				req.getRequestDispatcher("DepositSucc.jsp").forward(req, resp);
		 }
	}

}
