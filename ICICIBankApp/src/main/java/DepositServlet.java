

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DepositServlet
 */
public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		int depositAmount = Integer.parseInt(request.getParameter("amount"));
		String outHtml = "<html><body>";
		int balance = 0;
		if(session != null) {
			if(depositAmount < 0) {
				outHtml = "<h1>Enter proper amount to deposit</h1></body></html>";
			} else {
				Integer bal = (Integer) session.getAttribute("balance");
				
				if(bal != null) {
					balance = bal.intValue();
				}
				session.setAttribute("balance", balance+depositAmount);
				outHtml = "<h1>Deposit successful</h1> <a href='HomePage.html'>Goto Home</a></body></html>";
				
			}
			
		} else {
			outHtml = "<h1>First login and then try to deposit</h1></body></html>";
		}
		
		
		PrintWriter pw = response.getWriter();
		pw.write(outHtml);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
