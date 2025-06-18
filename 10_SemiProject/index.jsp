<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인화면</title>
    <style>
        /* 기본 스타일 설정 */
body {
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background: white;
}

/* 전체 컨테이너 */
.container {
    width: 100%;
    height: 100%;
    position: relative;
    background: white;
    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
    overflow: hidden;
    outline: 1px solid black;
    outline-offset: -1px;
}

/* 로고 */
.logo {
    width: 263.57px;
    height: 148.86px;
    position: absolute;
    left: 1030px;
    top: 80px;
}

/* 배경 이미지 */
.background-img {
    max-width: 900px;
    width: 80%;
    height: 100%;
    
}

/* 입력 박스 */
.input-box {
    width: 20%;
    height: 65px;
    position: absolute;
    left: 1000px;
    border-radius: 10px;
    border: 1px solid rgba(181, 0, 0, 0.3);
    display: flex;
    align-items: center;
    padding-left: 20px;
    font-size: 25px;
    color: #BABABA;
}

/* 첫 번째 입력창 위치 (ID) */
.input-box:nth-child(3) {
    top: 250px;
}

/* 두 번째 입력창 위치 (PASSWORD) */
.input-box:nth-child(4) {
    top: 350px;
}

/* 버튼 스타일 */
.btn {
    width: 20%;
    height: 65px;
    border-radius: 10px;
    font-size: 25px;
    font-family: Arial;
    font-weight: 400;
    text-align: center;
    cursor: pointer;
    border: none;
    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
    margin: 10px 0;
}

/* 로그인 버튼 */
.login-btn {
    position: absolute;
    left: 1010px;
    top: 450px;
    background: #FFE3D0;
    color: #BABABA;
}

/* 회원가입 버튼 */
.signup-btn {
    position: absolute;
    left: 1010px;
    top: 530px;
    background: #FFE3D0;
    color: #BABABA;
}

/* 하단 연락처 */
.contact-info {
    width: 286px;
    height: 47px;
    position: absolute;
    left: 1010px;
    top: 650px;
    text-align: center;
    color: #858585;
    font-size: 15px;
    font-family: Arial;
    font-weight: 400;
}

    </style>
</head>
<body>
    <div class="container">
        <img class="logo" src="resources/logo.png" alt="Logo">
        <img class="background-img" src="resources/background.png" alt="Background">

        <div class="input-box">
            <div class="input-icon"></div>
            <span class="input-placeholder">ID</span>
        </div>

        <div class="input-box">
            <div class="input-icon"></div>
            <span class="input-placeholder">PASSWORD</span>
        </div>

        <button class="btn login-btn">LOGIN</button>
        <button class="btn signup-btn">회원가입</button>

        <div class="contact-info">CONTACT US 010-0000-1111</div>
        <jsp:include page="footer.jsp">
    </div>

</body>
</html>
