<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách Video</title>
</head>
<body>
    <h1>Danh sách Video</h1>
    <ul>
        <c:forEach var="video" items="${videos}">
            <li>
                <a href="<c:url value='/video?id=${video.videoId}'/>">${video.title}</a>
                - ${video.views} lượt xem
            </li>
        </c:forEach>
    </ul>
    
    <c:if test="${currentPage > 1}">
        <a href="<c:url value='/videos?page=${currentPage - 1}'/>">Trang trước</a>
    </c:if>
    
    <c:if test="${currentPage < totalPages}">
        <a href="<c:url value='/videos?page=${currentPage + 1}'/>">Trang sau</a>
    </c:if>
</body>
</html>