<%-- 
    Document   : showit
    Created on : 22 janv. 2015, 22:50:23
    Author     : nebrass
--%>

<%@page import="com.davidson.dev.qcm.entity.Question"%>
<%@page import="com.davidson.dev.qcm.facade.QuestionFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            QuestionFacade questionFacade = new QuestionFacade();
            for(Question question : questionFacade.listAll()){
                out.println("<p>"+ question.getRecommandation().get(0) +"</p>");
            }
            session.invalidate();
        %>
    </body>
</html>
