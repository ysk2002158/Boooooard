import board.PostBean;
import java.io.IOException;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 掲示板のフロントコントローラー.
 */
@WebServlet("/board/*")
public class BoardServlet extends HttpServlet {

    /** 投稿の一覧 */
    private List<PostBean> postBeanList = new ArrayList<>();

    /**
     * GET リクエストを処理する。
     *
     * @param request
     *            リクエスト
     * @param response
     *            レスポンス
     * @throws ServletException GET に相当するリクエストが処理できない場合
     * @throws IOException Servlet が GET リクエストを処理している間に入出力エラーが発生した場合
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    /**
     * POST リクエストを処理する。
     *
     * @param request
     *            リクエスト
     * @param response
     *            レスポンス
     * @throws ServletException POST に相当するリクエストが処理できない場合
     * @throws IOException Servlet が POST リクエストを処理している間に入出力エラーが発生した場合
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String pathInfo = request.getPathInfo();
        String path = null;
        PostBean bean = null;
        int targetIndex = -1;
        int index = 0;
        switch (pathInfo) {
        case "/index":
            bean = PostFactory.newBean();
            path = "create";
            break;
        case "/create":
            bean = PostFactory.createBean(request.getParameter("author"), request.getParameter("title"),
                    request.getParameter("body"));
            this.postBeanList.add(bean);
            bean = PostFactory.newBean();
            path = "create";
            break;
        case "/edit":
            for (PostBean targetBean : this.postBeanList) {
                String id = targetBean.getId();
                if (id.equals(request.getParameter("id"))) {
                    targetIndex = index;
                    bean = targetBean;
                    break;
                }
                index++;
            }
            path = "update";
            break;
        case "/update":
            for (PostBean targetBean : this.postBeanList) {
                String id = targetBean.getId();
                if (id.equals(request.getParameter("id"))) {
                    targetIndex = index;
                    bean = PostFactory.updateBean(targetBean, request.getParameter("author"),
                            request.getParameter("title"), request.getParameter("body"));
                    this.postBeanList.set(targetIndex, bean);
                    break;
                }
                index++;
            }
            bean = PostFactory.newBean();
            path = "create";
            break;
        case "/delete":
            for (PostBean targetBean : this.postBeanList) {
                String id = targetBean.getId();
                if (id.equals(request.getParameter("id"))) {
                    targetIndex = index;
                    bean = PostFactory.deleteBean(targetBean);
                    this.postBeanList.set(targetIndex, bean);
                    break;
                }
                index++;
            }
            bean = PostFactory.newBean();
            path = "create";
            break;
        default:
            bean = PostFactory.newBean();
            path = "create";
        }
        request.setAttribute("bean", bean);
        request.setAttribute("list", this.postBeanList);
        request.setAttribute("path", path);
        this.getServletContext().getRequestDispatcher("/layout.jsp").forward(request, response);
    }

}
