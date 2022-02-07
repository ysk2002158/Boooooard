import java.io.IOException;


import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Post")
public class PostServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		List<PostBean> PostBeanList = new ArrayList<>();
		PostBean postBean = new PostBean();
		postBean.setAuthor(getServletInfo());
		postBean.setTitle(getServletInfo());
		postBean.setBody(getServletInfo());
		request.setAttribute("postBean", postBean);
		
		
		
		getSerbletContext().
		 getRequestDispatcher("/layout.jsp")
         .forward(request, response);
	}
}