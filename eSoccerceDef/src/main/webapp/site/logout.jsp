<%@ page language="java" contentType="text/html; 
charset=UTF-8" pageEncoding="UTF-8" import= "java.util.*" %>
<%
    HttpSession sessione = request.getSession(false);
	sessione.invalidate();
	response.sendRedirect(response.encodeURL("../site/index.jsp"));
%>