<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tìm kiếm Video</title>
</head>
<body>
    <h1>Tìm kiếm Video</h1>
    <form action="<c:url value='/search'/>" method="get">
        <input type="text" name="keyword" placeholder="Nhập từ khóa tìm kiếm">
        <input type="submit" value="Tìm kiếm">
    </form>
    
    <c:if test="${not empty videos}">
        <h2>Kết quả tìm kiếm:</h2>
        <ul>
            <c:forEach var="video" items="${videos}">
                <li>
                    <a href="<c:url value='/video?id=${video.videoId}'/>">${video.title}</a>
                    - ${video.views} lượt xem
                </li>
            </c:forEach>
        </ul>
    </c:if>
</body>
</html>