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
 * �f���̃t�����g�R���g���[���[.
 */
@WebServlet("/board/*")
public class BoardServlet extends HttpServlet {

    /** ���e�̈ꗗ */
    private List<PostBean> postBeanList = new ArrayList<>();

    /**
     * GET ���N�G�X�g����������B
     *
     * @param request
     *            ���N�G�X�g
     * @param response
     *            ���X�|���X
     * @throws ServletException GET �ɑ������郊�N�G�X�g�������ł��Ȃ��ꍇ
     * @throws IOException Servlet �� GET ���N�G�X�g���������Ă���Ԃɓ��o�̓G���[�����������ꍇ
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    /**
     * POST ���N�G�X�g����������B
     *
     * @param request
     *            ���N�G�X�g
     * @param response
     *            ���X�|���X
     * @throws ServletException POST �ɑ������郊�N�G�X�g�������ł��Ȃ��ꍇ
     * @throws IOException Servlet �� POST ���N�G�X�g���������Ă���Ԃɓ��o�̓G���[�����������ꍇ
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
