package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * LogoutController
 * - 로그아웃 처리를 담당하는 컨트롤러
 * - "/logout.do" 요청 시 세션을 종료하고 로그인 페이지로 이동
 */
public class LogoutController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private void doProc(HttpServletRequest req,
                        HttpServletResponse resp
    ) throws ServletException, IOException {

        // 기존 세션 가져오기
        HttpSession session = req.getSession(false);

        // 세션이 존재하면 세션 종료
        if (session != null) {
            session.invalidate();
        }

        // 로그인 페이지로 이동
        resp.sendRedirect(
                req.getContextPath() + "/login.do"
        );
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