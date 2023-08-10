package webapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Example code for Servlet URL Rewriting
 * 
 * @author zaiba contractor
 *
 */
@WebServlet(urlPatterns = "/servlet2.do")
public class NewServlet extends HttpServlet {

    private static final long serialVersionUID = -8252653038577850731L;

    public void init() throws ServletException {
	System.out.println("----------------");
	System.out.println("Calling the init method in " + this.getClass().getName());
	System.out.println("----------------");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// response.setContentType("text/html");
	// PrintWriter out = response.getWriter();
	String userName = request.getParameter("name");
	// out.println("Hello World : "+userName);
	// out.close();
	request.setAttribute("name", userName);
	// request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,
	// response);
	response.sendRedirect("https://mail.google.com/mail/u/0/?tab=rm&ogbl#inbox");
    }

    public void destroy() {
	System.out.println("------------------");
	System.out.println("Destroy method called in " + this.getClass().getName());
	System.out.println("------------------");
    }
}
