<%@include file="/WEB-INF/pages/includedTags.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Struts 2</title>
    </head>
    <body>
    <center>
        <h3>Login with LDAP uid and password</h3>
        <form action="auth" method="post">
            <input type="text" name="username" placeholder="username"/>
            <br/>
            <input type="password" name="password" placeholder="password"/>
            <br/>
            <br/>
            <button type="submit">Process</button>
        </form>
    </center>
    </body>
</html>
