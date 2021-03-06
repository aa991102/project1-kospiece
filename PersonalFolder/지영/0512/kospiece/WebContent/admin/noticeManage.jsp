<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 1.공지사항 리스트가 나오게 변경 -->
<!-- 2.선택한 제목이나 내용에 맞는 공지사항 리스트가 나오게 변경 -->
<!-- 3.글목록에 페이징 추가 -->

<div class="admin-notice">
	<a href="<%= request.getContextPath()%>/admin.do" class="admin-logo">관리자 페이지</a>	
	<a href="<%= request.getContextPath()%>/userList.do" class="user-button">회원관리</a>
	<a href="<%= request.getContextPath()%>/noticeList.do" class="notice-button">공지사항</a><br/>
	
	<form name="notice-search" method ="post" class="notice-search">
	    <select name="search">
  	        <option value="" selected>전체보기</option>
	        <option value="ntitle">제목</option>
	        <option value="ncontent">내용</option> 
	    </select>
	    <input type="text" name="notice-inform" />
	    <input type="submit" value="검색"/>
	</form>
	<table border="1" width="1000" align="center">
		<tr>
        	<th>글번호</th>
        	<th>제목</th>
        	<th>업로드날짜</th>
        	<th>조회수</th>
        	<th>수정</th>
        	<th>삭제</th>
        </tr>
		<c:forEach var="notice" items="${noticeList}">
        <tr>
        	<td>${notice.nno}</td>
        	<td>${notice.title}</td>
        	<td>${notice.uploadDate}</td>
        	<td>${notice.hit}</td>
        	<td>수정</td>
        	<td>삭제</td>
        </tr>
        </c:forEach>
     </table>
     <a href="<%= request.getContextPath()%>/admin/noticeWrite.jsp">공지사항작성</a>

</div>