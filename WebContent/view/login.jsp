<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
  <head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Document</title>
  <link rel="stylesheet" href="/bbs_sample/view/style.css" />

 <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100..900&display=swap" rel="stylesheet">

	</head>
 <body>
    <section class="section">
      <h1 class="section-headline">ログイン</h1>
<%
		//エラー発生時の警告文
		String message = (String)request.getAttribute("message");
		String error = (String)request.getAttribute("error");

		if(message != null && error == null) { %>
		<div class="alert" >
				<%= message %>
		</div>
		<%
		// 異常終了した場合のメッセージを表示
		} else if(message != null && error != null) { %>
		<div class="alert">
			<%= message %><br>
			<%= error %>
		</div>
		<% } %>


      <form action="<%= request.getContextPath() %>/LoginServlet" method="post" class="form">
        <table class="form-table">
		<tr>
		<th class="table-headline">ID</th>
		<td class="table-data">
              <input type="text" class="input" name="loginId" />
            </td>
		</tr>
		<tr>
			<th class="table-headline">Password</th>
			<td class="table-data">
              <input type="text" class="input" name="loginPassword" />
            </td>
		</tr>
		</table>
        <div class="form-button">
          <button class="button button-submission" type="submit">
            ログイン
          </button>
        </div>
      </form>
    </section>
  </body>
</html>