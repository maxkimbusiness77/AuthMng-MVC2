package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import model.AuthBean;
import model.AuthDao;

/**
 * LoginController
 * - 로그인 요청을 처리하는 컨트롤러
 * - GET  : 로그인 화면 출력
 * - POST : 로그인 처리
 */
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final AuthDao authDao = new AuthDao();

    private void doProc(HttpServletRequest req,
												HttpServletResponse resp
    ) throws ServletException, IOException {

        // GET 요청이면 로그인 화면으로 이동
        if ("GET".equalsIgnoreCase(req.getMethod())) {
            req.getRequestDispatcher("/WEB-INF/view/login.jsp")
               .forward(req, resp);
            return;
        }

        // 요청 데이터 인코딩
        req.setCharacterEncoding("UTF-8");

        // 로그인 정보 받기
        String username = req.getParameter("user-id");
        String password = req.getParameter("user-pw");

        // 입력값 검증
        if (username == null || username.trim().isEmpty()
                || password == null || password.trim().isEmpty()) {
            req.setAttribute(
                    "error",
                    "아이디와 비밀번호를 모두 입력해주세요"
            );
            req.getRequestDispatcher("/WEB-INF/view/login.jsp")
               .forward(req, resp);

            return;
        }

        // 로그인 확인
        AuthBean authBean= authDao.login(username, password);

        if (authBean!= null) {
            // 세션 고정 공격 방지
            try {
                req.changeSessionId();
            } catch (Throwable e) {
                e.printStackTrace();
            }

            HttpSession session = req.getSession(true);
            session.setAttribute("loginUser", authBean);

            // 로그인 성공 → 프로필 페이지
            resp.sendRedirect(
                    req.getContextPath() + "/profile.do"
            );
        } else {
            // 로그인 실패
            req.setAttribute(
                    "error",
                    "아이디 또는 비밀번호가 올바르지 않습니다."
            );
            req.getRequestDispatcher("/WEB-INF/view/login.jsp")
               .forward(req, resp);
        }
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