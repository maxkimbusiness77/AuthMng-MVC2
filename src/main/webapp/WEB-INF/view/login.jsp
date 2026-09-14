<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>

<!-- main -->
<main class="login">

    <h2 class="main-title">로그인</h2>

    <p class="main-desc">
        아이디와 비밀번호를 입력하고 로그인하세요
    </p>

    <!-- 로그인 실패 시 에러 메시지 -->
    <p style="color:red;">${error}</p>

    <form class="main-form"
          method="post"
          action="${pageContext.request.contextPath}/login.do">

        <section class="flex-input">
            <label for="user-id" class="user-id">
                아이디
            </label>
            <input
                id="user-id"
                class="user-id"
                name="user-id"
                type="text"
                required
            />
        </section>
        
        <section class="flex-input">
            <label for="user-pw" class="user-pw">
                비밀번호
            </label>

            <input
                id="user-pw"
                class="user-pw"
                name="user-pw"
                type="password"
                required
            />
        </section>

        <section class="btn-section">
            <button
                id="login-btn"
                class="login-btn"
                type="submit">
                로그인
            </button>
        </section>
    </form>
</main>

<%@ include file="footer.jsp" %>