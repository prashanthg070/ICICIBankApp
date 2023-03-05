

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String email = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		String outHtml = "<html<head><title>HomePage</title></head><body>";
		
		FileReader fr = new FileReader("/Users/prashanthg/Desktop/Backup/cred.txt");
		BufferedReader br = new BufferedReader(fr);
		String temp;
		String dbEmail, dbPwd;
		while((temp = br.readLine())!= null) {
			String [] cred = temp.split(" ");
			dbEmail = cred[0];
			dbPwd = cred[1];
			br.close();
			
			if(email.equals(dbEmail) && (pwd.equals(dbPwd))) {
				HttpSession session = request.getSession(true);
//				session.setAttribute("email", email);
				outHtml = outHtml + "<h1>Login Succesful</h1><br> <a href ='HomePage.html'>home</a></body></html>";
				//outHtml = "<html><body><h1>Registration Succesful. Please <a href ='Login.html'> login again </a></h1></body><html>";
				
				
				
//				PrintWriter pw = response.getWriter();
//				pw.write(outHtml);
				int updatedBalance = 10000;
				try {
					FileReader fr2 = new FileReader("/Users/prashanthg/Desktop/Backup/balance.txt");
					BufferedReader br1 = new BufferedReader(fr);
					String temp1;
					String dbEmail1, balance;
					while((temp1 = br1.readLine())!= null) {
						String [] cred1 = temp1.split(" ");
						dbEmail1 = cred1[0];
						balance = cred1[1];
						br1.close();
						
						if(email.equals(dbEmail1)) {
							updatedBalance = Integer.parseInt(balance);
						}
					}
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
				session.setAttribute("balance", updatedBalance);
				
				RequestDispatcher rd = request.getRequestDispatcher("/HomePage.html");
				rd.forward(request, response);
				return;
							
			}
			
		}
		
		outHtml = outHtml + "<h1>Email Password forgotted ha....?</h1></body></html>";
		PrintWriter pw = response.getWriter();
		pw.write(outHtml);
		
		
		
		
		
		
	}

}
