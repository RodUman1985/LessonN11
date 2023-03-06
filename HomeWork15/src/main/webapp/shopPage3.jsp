<%@ page import="come.step.dubinin.Serves" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>shop2</title>
      <style>
           ol {
            padding: 0;
            margin-left:40%;
           }
          </style>
</head>
<body>
    <h1 align="center">Dear      <%= request.getSession().getAttribute("name") %> </h1>
    <h2 align="center"> Your order:    </h2>
    <h2 >   <%= Serves.setScrol() %></h2>
    <h2 align="center"> Total:   <%= Serves.Calc(Serves.List2.toArray(new String[0])) %> </h2>
     <h2 align="center">
        <a href="/shop.jsp">Return to start page</a>
      </h2>
</body>
</html>