<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>登録ページ</title>
 <link rel="stylesheet" href="/bbs_sample/view/style.css" />
 <link rel="preconnect" href="https://fonts.googleapis.com" />
 <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
 <link
      href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP&family=Noto+Serif+JP&display=swap"
      rel="stylesheet"
 />
</head>
<body>


<section class="section">
	<h1 class = "section-headline"> 登録する </h1>


	<form action="<%=request.getContextPath() %>/SigninServlet" method="post">
	<table class="form-table">
	<tr class = "table-row">
		<th class="table-headline" ><label for="id">ID</label></th>
		<td class="table-data">
			<input type ="text" class="input" name = "signinId" id="id"/>
		</td>
	</tr>
		<tr class = "table-row">
		<th class="table-headline" ><label for="name"> UserNam</label></th>
		<td class="table-data">
			<input type ="text" class="input" name = "signinUserName" id="name" />
		</td>
	</tr>
	<tr class = "table-row">
		<th class="table-headline" ><label for="pass">Password</label></th>
		<td class="table-data">
			<input type ="text" class="input" name = "signinPassword" id="pass"/>
		</td>
	</tr>
	</table>
	<div class="form-button">
          <button type="submit" class="button button-submission">登録</button>
     </div>
	</form>


</section>


</body>
</html>