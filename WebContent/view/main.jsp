<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Contents" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>掲示板</title>
 <link rel="stylesheet" href="/bbs_sample/view/style.css" />
 <link rel="preconnect" href="https://fonts.googleapis.com" />
 <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
 <link
      href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP&family=Noto+Serif+JP&display=swap"
      rel="stylesheet"
 />
</head>
<body>
<nav>
<a href="LoginServlet">ログアウト</a>
</nav>


<!-- 名前 name メール email 題名 title 題名 text url url -->

<section class="section">
<h1 class = "section-headline"> 書き込み </h1>
<form action="PostServlet" method="post">
<table class="form-table">
<tr class = "table-row">
<th class="table-headline" >名前</th>
<td class="table-data">
<input type ="text" class="input" name = "name"/>
</td>
</tr>
<tr class = "table-row">
<th class="table-headline" >メール</th>
<td class="table-data">
<input type ="text" class="input" name = "email"/>
</td>
</tr>
<tr class = "table-row">
<th class="table-headline" >タイトル</th>
<td class="table-data">
<input type ="text" class="input" name = "title"/>
</td>
<tr class = "table-row">
<th class="table-headline" >内容</th>
<td class="table-data">
<textarea
                class="textarea"
                cols="30"
                rows="10"
                id="detail"
                name="text"
              ></textarea>
</td>
</tr>
<tr class = "table-row">
<th class="table-headline" >URL</th>
<td class="table-data">
<input type ="text" class="input" name = "url"/>
</td>
</tr>
</table>
<div class="form-button">
          <button type="submit" class="button button-submission">登録</button>
     </div>
</form>
</section>

<!--
 書き込み一覧↓
 -->

<section class="section section2">


<table class="contents-table">

			<% List<Contents> contentsList = (List<Contents>)request.getAttribute("contentsList"); %>
			<% if(contentsList != null){ %>
			<% for(int i= 0 ; i < contentsList.size(); i++) { %>
			<tr class="table-upperrow">
			<td style="width: 15%;">No.<%=i+1  %></td>
			<td style ="width: 50%"><span class="title">タイトル:</span><%=(contentsList.get(i)).getTitle()%> </td>
			<td style ="width: 35%">名前: <%=(contentsList.get(i)).getName() %> </td>
		</tr>
		<tr class="table-text">
			<td class="tabledata-text" colspan="3" ><%=(contentsList.get(i)).getText()%></td>
			<td> <input type="button" onclick="location.href='<%=request.getContextPath() %>/view/test.jsp'" value="削除" >
		</tr>
	<% } } %>

</table>



</section>




</body>
</html>