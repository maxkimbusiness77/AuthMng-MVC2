<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>

<!-- profile 전용 CSS -->
<link rel="stylesheet"
      href="${pageContext.request.contextPath}/css/profile.css">

<!-- main -->
<main class="profile">
    <section class="welcome-section">
        <img
            src="${pageContext.request.contextPath}/img/image.png"
            alt="프로필이미지"
            class="profile-img"
        >

        <h2>${auth.username}님 환영합니다!</h2>
        <p>로그인에 성공하였습니다. 환영합니다!</p>
        <p>오늘도 즐거운 하루 보내세요!</p>
    </section>
</main>

<%@ include file="footer.jsp" %>