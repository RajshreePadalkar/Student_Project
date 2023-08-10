package webapp;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neebalgurukul.service.LoginService;

@WebServlet(urlPatterns = "/deleteStudent.do")
public class DeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	System.out.println("Inside LoginServlet");
	request.getRequestDispatcher("/WEB-INF/views/Register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	LoginService service = new LoginService();
	String name = request.getParameter("deleteUsername");
	try {
	    service.SetDeactive(name);
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	request.setAttribute("deleteStudent", name);
	request.getRequestDispatcher("/WEB-INF/views/deleted.jsp").forward(request, response);

    }
}
