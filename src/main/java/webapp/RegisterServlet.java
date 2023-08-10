package webapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neebalgurukul.service.LoginService;

@WebServlet(urlPatterns = "/register.do")
public class RegisterServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	System.out.println("Inside LoginServlet");
	request.getRequestDispatcher("/WEB-INF/views/Register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	LoginService service = new LoginService();
	String username = request.getParameter("username");
	request.setAttribute("username", username);

	try {
	    if (service.userExist(username)) {
		request.setAttribute("errorMessage", "Invalid username Try with other username!");
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	    } else {

		String password = request.getParameter("password");

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String course = request.getParameter("course");
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println("I/P Parameter :" + name + " , " + email + " ," + course + " , " + age);

		request.setAttribute("name", name);
		service.addStudent(name, email, course, age, username);
		service.addLogin(username, password);
		try {
		    request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);

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
	} catch (NumberFormatException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
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
