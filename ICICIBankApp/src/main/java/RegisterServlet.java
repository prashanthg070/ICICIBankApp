

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("pwd");
		String confirmPassword = request.getParameter("confirmpwd");
		String email = request.getParameter("user");
		//String outHtml = "<html<head><title>HomePage</title></head><body>";
		
		
		String outHtml;
		if(!password.equals(confirmPassword)) {
			outHtml = "<html><body><h1>Kann Kanasallva... password do not match</h1></body><html>";
			PrintWriter pw = response.getWriter();
			pw.write(outHtml);
		}else {
			 FileWriter fw = new FileWriter("/Users/prashanthg/Desktop/Backup/cred.txt", true);
			 BufferedWriter bw = new BufferedWriter(fw);
			 
			 bw.write(email + " " + password);
			 bw.write("\n");
			 bw.close();
			 
			 
			 outHtml = "<html><body><h1>Registration Succesful. Please <a href ='Login.html'>login</a></h1></body></html>";
			 PrintWriter pw = response.getWriter();
			 pw.write(outHtml);
		}
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
