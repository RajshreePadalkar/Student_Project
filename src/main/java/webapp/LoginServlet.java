package webapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neebalgurukul.service.LoginService;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	System.out.println("Inside LoginServlet");
	request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	LoginService service = new LoginService();
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	System.out.println("I/P Parameter :" + name + " , " + password);

	request.setAttribute("name", name);
	try {
	    if (service.isValidUser(name, password)) {
		request.getRequestDispatcher("/WEB-INF/views/Register.jsp").forward(request, response);
	    } else {
		request.setAttribute("errorMessage", "Invalid Credentials!");
		request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
	    }
	} catch (ServletException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

}
