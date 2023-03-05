

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BalanceServlet
 */
public class BalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BalanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    /*
     * 1. request
     * 2. response
     * 3. out
     * 4. session
     * 
     * 
     * 
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("user");
		int balance = 10000;
		
		HttpSession session = request.getSession();
		Integer bal = (Integer) session.getAttribute("balance");
		if(bal != null) {
			balance = bal.intValue();
		}
		//String outHtml = "<html<head><title>HomePage</title></head><body>";
		
		String outHtml;
		 
		outHtml = "<html><body><h1>The balance is " + balance + "</h1></body></html>";
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
