package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import model.AuthBean;

/**
 * ProfileController
 * - 로그인된 사용자의 프로필 정보를 표시하는 컨트롤러
 * - "/profile.do" 요청 처리
 */
public class ProfileController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private void doProc(HttpServletRequest req,
                        HttpServletResponse resp
    ) throws ServletException, IOException {
        // 기존 세션 가져오기
        HttpSession session = req.getSession(false);
        AuthBean loginUser = null;

        if (session != null) {
            loginUser = (AuthBean) session.getAttribute("loginUser");
        }

        // 로그인하지 않은 경우 로그인 페이지로 이동
        if (loginUser == null) {
            resp.sendRedirect(
                    req.getContextPath() + "/login.do"
            );
            return;
        }

        // 프로필 화면에서 사용할 사용자 정보 전달 사용예시 ${auth.username}
        req.setAttribute("auth", loginUser);
        req.getRequestDispatcher("/WEB-INF/view/profile.jsp")
               .forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp
    ) throws ServletException, IOException {
        doProc(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp
    ) throws ServletException, IOException {
        doProc(req, resp);
    }
}