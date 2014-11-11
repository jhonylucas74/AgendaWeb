<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="br.com.jhony.servlet.*, br.com.jhony.beans.*, br.com.jhony.db.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Remover contato</title>
</head>
<body>

 <% ContatoDAO dao = new ContatoDAO();
	String idString = request.getParameter("id");
	long id = Long.parseLong(idString);
	Contato c = new Contato();
	c.setId(id);
	dao.remove(c); %>
	
	<h3> Contato removido com sucesso </h3>
	<a href="lista-contatos.jsp" >Voltar</a>

</body>
</html>