import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    //no-argument constructor
    public LoginServlet() {

    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        Model model = Model.getInstance();

        PrintWriter out = response.getWriter();

        //get parameters from request object.
        String userName = request.getParameter("userName").trim();
        String password = request.getParameter("password").trim();

        String loginTemp = "";
        String passwordTemp = "";
        for (User u : model.list()) {
            if (userName.equals(u.getLogin()) && password.equals(u.getPassword())) {
                loginTemp = u.getLogin();
                passwordTemp = u.getPassword();
            }
        }

        //check for null and empty values.
        if (userName == null || userName.equals("") ||
                password == null || password.equals("")) {
            out.print("Please enter both username " +
                    "and password. <br/><br/>");
            RequestDispatcher requestDispatcher =
                    request.getRequestDispatcher("/index.jsp");
            requestDispatcher.include(request, response);
        }//Check for valid username and password.
        else if (userName.equals(loginTemp) && password.equals(passwordTemp)) {
            HttpSession session = request.getSession();
            session.setAttribute("userName", userName);
            session.setAttribute("password", password);
            out.println("Logged in successfully.<br/>");
            out.println("Click on the below link to see " +
                    "the all users.<br/>");
            out.println("<a href='DisplaySessionValueServlet'>" +
                    "Click here</a>");
            out.println("<a href='LogoutServlet'>" +
                    "LOGOUT</a>");
            out.close();
        } else {
            out.print("Wrong username or password. <br/><br/>");
            RequestDispatcher requestDispatcher =
                    request.getRequestDispatcher("/index.jsp");
            requestDispatcher.include(request, response);
        }
    }
}
