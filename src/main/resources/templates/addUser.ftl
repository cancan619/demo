<html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title>Document</title>
 </head>
 <body>
<form method="post" action="${request.contextPath}/seve">
		<table border="1" color="pink">
		<input type="hidden" name="userId" value="${emp.userId}">
		<tr>
			<td>用户名称</td>
			<td><input type="text" name="userName" value="${emp.userName}"></td>
		</tr>
		<tr>
			<td>用户年龄</td>
			<td><input type="text" name="userAge" value="${emp.userAge}"></td>
		</tr>
		<tr>
			<td>用户性别</td>
			<td>
				<input type="radio" name="userSex" value="1">男
				<input type="radio" name="userSex" value="2">女
			</td>
		</tr>
		<tr>
			<td>用户出生日期</td>
			<td><input type="text" name="userDate" value="${emp.userDate}"></td>
		</tr>
		<tr>
			<td>操作</td>
			<td>
				<input type="submit" value="修改">
			</td>
		</tr>
		</table>
	</form>
</body>
</html>