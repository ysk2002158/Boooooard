<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.ZoneId" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="ja_JP" />
<main>
<form method="POST" action="${path}">
  <input type="hidden" name="id" value="${bean.id}" />
  <section id="form">
    <dl class="clearfix">
      <dt><label for="author">投稿者</label></dt><dd><input type="text" name="author" id="author" value="${bean.author}" /></dd>
      <dt><label for="title">タイトル</label></dt><dd><input type="text" name="title" id="title" value="${bean.title}" /></dd>
      <dt><label for="body">内容</label></dt><dd><textarea name="body" id="body">${bean.body}</textarea></dd>
      <button type="submit">送信</button>
    </dl>
  </section>
</form>
<section id="posts">
<ul>
<c:forEach items="${list}" var="bean">
<c:if test="${bean.deleted == false}">
  <li>
    <article class="post">
      <ul>
        <li><h3><c:out value="${bean.author}" /></h3></li>
        <li><h2><c:out value="${bean.title}" /></h2></li>
        <li><pre><c:out value="${bean.body}" /></pre><li>
        <li><div class="buttons clearfix"><a href="edit?id=<c:out value="${bean.id}" />" class="edit">編集</a><a href="delete?id=<c:out value="${bean.id}" />" class="delete">削除</a></div></li>
      </ul>
    </article>
  </li>
</c:if>
</c:forEach>
</ul>
</section>
</main>
