import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/")
public class BoardServlet extends HttpServlet {
	public void doGet (HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
			{
			this.doPost(request, response);
			}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String pathInfo = request.getPathInfo();
		switch (pathInfo) {
		case "/board":
			this.getServletContext().getRequestDispatcher("/rayout.jsp");
			break;
		case "/create":
			this.getServletContext().getRequestDispatcher("/rayout.jsp");
			break;
		case "/edit":
			this.getServletContext().getRequestDispatcher("/Post");

		}
		
	}

}
