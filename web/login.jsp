<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="style.css" rel="stylesheet" type="text/css">
    <title>Login</title>


</head>
<body>

<h1>MUM Library Login!</h1>

<form action="login" method="post" enctype="application/x-www-form-urlencoded">
    <div class="box">
        <div class="container">
            <span id="updatenewpw">Login to Library!</span>
            <br/>
            <%if (request.getAttribute("message") != null) { %>
            <p style="color: #DD0000;">${requestScope.get("message")}</p>
            <% } %>
            <label for="email"><b>Email</b></label><br/>
            <input type="text" name="email" placeholder="Enter your email" required/> <br/>

            <label for="password"><b>Password</b></label><br/>
            <input type="password" name="password" placeholder="Enter your password" required/> <br/>

            <button type="submit">Login</button>

        </div>



    </div>
</form>


</body>
</html>
