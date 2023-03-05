

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String outHtml = "<html><head><title>Logout</title></head><body>";
		
		if(session == null) {
			outHtml = outHtml + "<h1>Eyy first Login aagooo.. amele logout ella aguvante!!!</h1></body></html>";
			
		}else {
			session.invalidate(); // LOGOUT
			outHtml = outHtml + "<h1>Logout Succesful</h1><br> Go to <a href = 'Login.html'>Login</a> Page</body></html>";
		}
		
		PrintWriter pw = response.getWriter();
		pw.write(outHtml);
		
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
