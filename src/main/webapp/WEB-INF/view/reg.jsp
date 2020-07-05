<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>
</head>
<body>


<div class="authorization">
    <h2>Регистрация</h2>
        <form:form action="/reg" method="post" modelAttribute="player">
            <table cellspacing="5" cellpadding="0">
                <tr>
                    <td><form:label path="name">Имя:</form:label></td>
                    <td><form:input path="name"/></td>
                </tr>
                <tr>
                    <td><form:label  path="mail">Почта</form:label></td>
                    <td><form:input path="mail"/></td>

                </tr>
                <tr>
                    <td><form:label  path="password">Пароль:</form:label></td>
                    <td><form:password path="password"/></td>
                </tr>
                <tr>
                    <td><form:button>Зарегистрироваться</form:button></td>
                </tr>

            </table>
        </form:form>
    <c:if test="${not empty message}">
        <div style="color:red; font-weight: bold; margin: 30px 0px;">
                ${message}
        </div>
    </c:if>
</div>
<a style="margin-left: 5px" class="header__auth" href="/">Войти</a>
</body>
</html>