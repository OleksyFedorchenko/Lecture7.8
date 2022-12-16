import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
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
        PrintWriter out = response.getWriter();
        //get parameters from session object.
        HttpSession session = request.getSession(false);
        if (session.getAttribute("userName") == (null)) {
            RequestDispatcher requestDispatcher =
                    request.getRequestDispatcher("/index.jsp");
            requestDispatcher.include(request, response);
        } else {
            out.print("""
                    <style>table,th,td{
                      border: 1px solid grey;
                      text-align:center;
                    }\s

                    th,td{
                       padding:10px;
                    }</style>""");
            out.print("<table>\n" +
                    "<thead><th>Login</th><th>Name</th></thead>");
            for (User u : Model.getInstance().getUserList()) {
                out.print("<tr><td>" + u.getLogin() + "</td><td>" + u.getName() + "</td></tr>");
            }
            out.print("</table>");
        }
        out.close();
    }

}