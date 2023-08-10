package webapp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neebalgurukul.model.Student;
import com.neebalgurukul.service.LoginService;

@WebServlet(urlPatterns = "/search.do")
public class SearchServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	LoginService service = new LoginService();
	String username = request.getParameter("username");

	try {
	    List<Student> student = service.getStudentDetail(username);
	    request.setAttribute("student", student);
	    request.getRequestDispatcher("/WEB-INF/views/next.jsp").forward(request, response);

	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

}
