<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <title>Balanced Brackets</title>
</head>

<body>
<span style="color: red; ">${errorMessage}</span>
<span style="color: green;">${success}</span>
<form:form servletRelativeAction="/" method="post">
    <div>
        <label>isBalanced?: </label>
         <input type="text" name="input" />
    </div>
    <button type="submit">Verify</button>
</form:form>
</body>

</html>