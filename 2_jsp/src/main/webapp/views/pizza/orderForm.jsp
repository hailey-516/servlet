<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>orderForm</title>
</head>
<body>
	<h1>피자 주문하기</h1>
    <h3>현재 날짜</h3>
    <% Date today = new Date(); %>
    <%= today %>
	
	<form action="/2_jsp/PizzaServlet">
    <fieldset>
        <legend>주문자 정보</legend>
        <table>
            <tr>
                <td>이름</td>
                <td><input type="text" id="userName"></td>
            </tr>
            <tr>
                <td>연락처</td>
                <td><input type="tel" name="phone" id="phone"></td>
            </tr>
            <tr>
                <td>주소</td>
                <td><input type="text" name="address" id="address"></td>
            </tr>
            <tr>
                <td>요청사항</td>
                <td><textarea name="req" name="req" placeholder="내용을 입력해주세요."></textarea></td>
                
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend>주문 정보</legend>
        <table>
            <tr>
                <td>피자</td>
                <td>
                    <select name="menu">
                        <option value="">콤비네이션피자</option>
                        <option value="">치즈피자</option>
                        <option value="">불고기피자</option>
                        <option value="">하와이안피자</option>
                        <option value="">페퍼로니피자</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>토핑</td>
                <td>
                    <label for="치즈"></label>
                    <input type="checkbox" name="topping" id="cheese"> 치즈
                    <label for="올리브"></label>
                    <input type="checkbox" name="topping" id="올리브"> 올리브
                    <label for="불고기"></label>
                    <input type="checkbox" name="topping" id="불고기"> 불고기
                    <label for="치즈 크러스트"></label>
                    <input type="checkbox" name="topping" id="치즈 크러스트"> 치즈 크러스트
                    <label for="파인애플"></label>
                    <input type="checkbox" name="topping" id="파인애플"> 파인애플
                    <label for="베이컨"></label>
                    <input type="checkbox" name="topping" id="베이컨"> 베이컨
                    <label for="포테이토"></label>
                    <input type="checkbox" name="topping" id="포테이토"> 포테이토
                    <label for="새우"></label>
                    <input type="checkbox" name="topping" id="새우"> 새우
                </td>
            </tr>
            <tr>
                <td>사이드</td>
                <td>
                    <label for="콜라"></label>
                    <input type="checkbox" name="sideMenu" id="콜라"> 콜라
                    <label for="사이다"></label>
                    <input type="checkbox" name="sideMenu" id="사이다"> 사이다
                    <label for="피클"></label>
                    <input type="checkbox" name="sideMenu" id="피클"> 피클
                    <label for="치즈오븐스파게티"></label>
                    <input type="checkbox" name="sideMenu" id="치즈오븐스파게티"> 치즈오븐스파게티
                    <label for="치킨텐더"></label>
                    <input type="checkbox" name="sideMenu" id="치킨텐더"> 치킨텐더
                </td>
            </tr>
        </table>
    </fieldset>
    
        <input type="submit" value="주문">
        <input type="reset" value="초기화">
    </form>
</body>
</html>