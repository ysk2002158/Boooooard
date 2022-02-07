<%@ page contentType="text/html; charset=UTF-8"
	import="java.net.URLDecoder" import="java.util.*"
	import="java.util.List" import="java.util.*"%>
<jsp:useBean id="postBean" class="PostBean" scope="request" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<form method="POST" action="servlet55/Post">
		掲示板
		<dd>
			<input name=author type=text size=10 />
			<p>
				<input name=title type=text size=10 />
			</p>
			<p>
				<textarea name=body rows=4 cols=40></textarea>
			</p>
			<p>
				<input type="submit" value="投稿">
			</p>
		</dd>

	</form>
	<p>
	<%=postBean.getAuthor() %>
	<%=postBean.getTitle() %>
	<%=postBean.getBody() %>
	
	</p>

</body>
</html>