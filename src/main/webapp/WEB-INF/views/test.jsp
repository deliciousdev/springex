
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <form action="/test2" method="post">
    <div>
      stringParam : <input type="text" name="stringParam">
    </div>
      intParam : <input type="number" name="intParam">
    <div>
      localDateParam : <input type="date" name="localDateParam">
    </div>

    <div>
      booleanParam : <input type="checkbox" name="booleanParam">
    </div>

    <div>
      <button type="submit">send</button>
    </div>

  </form>
</body>
</html>
