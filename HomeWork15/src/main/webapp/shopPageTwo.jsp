
<%@ page import="come.step.dubinin.Serves" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Shop</title>
     <style>
       ol {
        padding: 0;
        margin-left:40%;
       }
      </style>
</head>
<body>

    <h1  align="center">Dear     <%= request.getSession().getAttribute("name") %> </h1>
   <h1  align="center">
    <form action="/shopPageTwo.jsp" method="get">
    <select name="list" size="4" multiple>
        <option> lazgan 100$</option>
        <option> bolter 500$</option>
        <option> chainsword 500$</option>
        <option> power axe 700$</option>
    </select>
      <p>  <input type="submit" value="add"> </p>
     </form>
     </h1>
 <h1 >
      <form action="/shopPage3.jsp" method="get">
            <p align="center"> <%=  Serves.getUserScrol(request.getParameter("list")) %> </p>

     <p align="center"> <input type="submit" value="submit"></p>
      </form>
 </h1>

</body>

