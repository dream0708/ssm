<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<p> ${error}</p>  
<form  action="" method="post">
username:<input name="username" type="text" /><br>
password:<input name="password" type="password" /><br>
验证码:<input name="captcha" type="text" /><img src="<%=request.getContextPath() %>/captcha"  onclick="javascript:this.src='/ssm/captcha'"></img> <br>
记住我<input type="checkbox" id="rememberMe" name="rememberMe" />
<input type="submit" value="submit" /><br>
<br>
                                                                <br>
</form>
</body>
</html>