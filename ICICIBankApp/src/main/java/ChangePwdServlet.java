

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangePwdServlet
 */
public class ChangePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePwdServlet() {
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
		String oldPwd = request.getParameter("oldpwd");
		String newPwd = request.getParameter("newpwd");
		String confirmNewPwd = request.getParameter("confirmNewPwd");
		String responseMsg = "";
		
		if(!newPwd.equals(confirmNewPwd)) {
			responseMsg = "New pwd and confirm new pwd are not matching.. Idiot fellow";
			
		} else {
			FileReader fr = new FileReader("/Users/prashanthg/Desktop/Backup/cred.txt");
			BufferedReader br = new BufferedReader(fr);
			
			
			String cred = br.readLine();
			
			String []splitArr = cred.split(" ");
			String email = splitArr[0];
			String actualOldPwd = splitArr[1];
			br.close();
			if(actualOldPwd.equals(oldPwd)) {
				FileWriter fw = new FileWriter("/Users/prashanthg/Desktop/Backup/cred.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				
				bw.write(email + " " + newPwd);
				bw.close();
			}
			responseMsg = "Password changed successfully";
		}
		
		PrintWriter pw = response.getWriter();
		pw.write("<html><body><h1>" + responseMsg + "</h1></body></html>");
	}

}
