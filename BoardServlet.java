import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html></html>");
		out.println("<head><meta charset='UTF-8' /></head>");
		out.println("<title>ŒfŽ¦”Â</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form method=\"POST\" action=\"/servlet/Post\">");
		out.println("<p><input name=\"author\" type=\"text\" size=\"10\" /></p>");
		out.println("<p><input name=\"title\" type=\"text\" size=\"10\" /></p>");
		out.println("<p><textarea name=\"body\" rows=\"4\" cols=\"40\"></textarea></p>");
		out.println("<p><input type=\"submit\" value=\"“Še\"></p>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");

	}
}