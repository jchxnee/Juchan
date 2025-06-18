<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>내 정보</title>
    <style>
        body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.container {
    background: white;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width: 350px;
    text-align: center;
}

.info-box, .work-box {
    background: #f9f9f9;
    padding: 15px;
    margin-bottom: 15px;
    border-radius: 5px;
}

h2 {
    color: #333;
}

p {
    font-size: 14px;
    color: #666;
    margin: 8px 0;
}

input[type="password"] {
    padding: 5px;
    width: 80%;
    border: 1px solid #ccc;
    border-radius: 3px;
}

.edit-btn {
    background: #007bff;
    color: white;
    border: none;
    padding: 10px 15px;
    border-radius: 5px;
    cursor: pointer;
    font-size: 14px;
}

.edit-btn:hover {
    background: #0056b3;
}

    </style>
</head>
<body>
    <div class="container">
        <div class="info-box">
            <h2>내 정보</h2>
            <p>이름 | 김현아</p>
            <p>아이디 | user100</p>
            <p>비밀번호 | <input type="password"></p>
            <p>비밀번호 확인 | <input type="password"></p>
            <p>전화번호 | 010-1234-5678</p>
        </div>
        
        <div class="work-box">
            <h2>근무 정보</h2>
            <p>지점 | 역삼점</p>
            <p>직급 | 지점장</p>
            <p>입사일 | 2018 / 05 / 03</p>
            <p>근속일수 | 689일</p>
        </div>
        
        <button class="edit-btn">정보 수정</button>
    </div>
</body>
</html>
