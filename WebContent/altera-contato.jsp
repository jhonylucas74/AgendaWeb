<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="br.com.jhony.servlet.*, br.com.jhony.beans.*, br.com.jhony.db.*"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Alterar contato</title>
    <c:import url="head.html" />
</head>
<body>
<c:import url="header.jsp" />

 
 <% ContatoDAO dao = new ContatoDAO();
 	String idString = request.getParameter("id");
 	long id = Long.parseLong(idString); 	 
    Contato contato = dao.getContato(id); %>
        
    <form action="alteraContato">
      <input type="hidden" name="id"  value="<%= contato.getId() %>" /> <br />
      Nome: <input type="text" name="nome" value="<%= contato.getNome() %>"/><br />
      E-mail: <input type="text" name="email" value="<%= contato.getEmail() %>"/><br />
      Endereço: <input type="text" name="endereco" value="<%= contato.getEndereco() %>"/><br />
      Data de nascimento: <input type="text" name="dataNascimento" value="<%= contato.getDataNascimentoFormat() %>"/><br />      
      <input type="submit" value="submeter" />
    </form>  


</body>
</html>