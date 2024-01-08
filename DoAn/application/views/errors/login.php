<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Login</title>
</head>
<body>
	<form action="control/xlloginView" method="post">
	<table>
		<tr>
			<th colspan="2">ĐĂNG NHẬP HỆ THỐNG</th>
		</tr>
		<tr>
			<td>Username: </td>
			<td><input type="text" name="username"></td>
		</tr>
		<tr>
			<td>Password: </td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="checkbox" name="remember">Remember password</td>
		</tr>
		<tr>
			<td>Choose file:</td>
			<td><input type="file" name="fileupload"></td>
		</tr>
		<tr>
			<td><input type="submit" value="Login"></td>
			<td><input type="reset" value="Cancel"></td>
		</tr>
	</table>
	</form>
</body>
</html>
