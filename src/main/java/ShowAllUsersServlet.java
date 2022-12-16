import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serial;

@WebServlet("/ShowAllUsersServlet")
public class ShowAllUsersServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    //no-argument constructor
    public ShowAllUsersServlet() {

    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        //get parameters from session object.
        HttpSession session = request.getSession(false);
        if (session.getAttribute("userName") == (null)) {
            RequestDispatcher requestDispatcher =
                    request.getRequestDispatcher("/index.jsp");
            requestDispatcher.include(request, response);
        } else {
            request.setAttribute("userList", Model.getInstance().getUserList());
            request.getRequestDispatcher("/WEB-INF/allUsers.jsp").forward(request, response);
        }
    }
}