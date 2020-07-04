<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8" />
    <title>Бык и Корова</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
    <div class="container">
        <header class="header">
            <h1 class="header__title">Игра "Бык и Корова"</h1>
            <a class="header__auth" href="/new">Новая игра</a>
            <a class="header__auth" href="/logout">Выход</a>

        </header>

        <c:if test="${not empty gameIsEnd}">
            <div style="display: flex; justify-content: center; color: #00ff01; font-size: 28px; width: 100%; margin-top: 20px">
                Вы угадали! Начните новую игру.
            </div>
        </c:if>


        <main class="content">
            <div class="content__game">
                <h4 class="content__game__name title">Игра</h4>
                <form action="${pageContext.request.contextPath}/enterValue" method="post">
                    <div class="content__game__panel">
                        <input type="text" name="value" size="9" maxlength="4" placeholder="Введите 4-х значное число" class="content__game__panel__input input">
                        <input type="hidden" name="idGame" value="${idGame}" class="content__game__panel__input input">
                        <button id="button" class="content__game__panel__button button">Сделать ход</button>
                    </div>
                </form>
                <c:if test="${not empty error}">
                    <div style="margin-left: 10px; color: #8b000b">
                        Значение должно состоять из 4 чисел
                    </div>
                </c:if>

            </div>
            <div class="content__steps">
                <h4 class="content__steps__name title">Ходы</h4>
                <ul style="text-align: center; margin-top: 20px">
                <c:forEach  items="${stepList}" var ="step">
                        <li class="item">${step}</li>
                    <ul>
                </c:forEach>
            </div>
            <div class="content__rate">
                <h4 class="content__rate__name title">Рейтинг</h4>
                <table width="100%" align="center" border="1" cellpadding="0" cellspacing="0">
                    <tr>
                        <th align="center">Имя</th>
                        <th align="center">Рейтинг</th>
                    </tr>
                    <c:forEach  items="${ratingVOList}" var ="ratingVO">
                    <tr>
                        <td align="center">${ratingVO.player.name}</td>
                        <td align="center">${ratingVO.avgAttempt}</td>
                    </tr>
                    </c:forEach>
            </div>
        </main>
    </div>
</body>
</html>