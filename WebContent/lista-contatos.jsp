<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Lista de contatos</title>
    <c:import url="head.html" />
</head>
<body>
<c:import url="header.jsp" />

<jsp:useBean id="dao" class="br.com.jhony.db.ContatoDAO"/>

<table>
	<td>Nome</td>
	<td>E-mail</td>
	<td>Endereço</td>
	<td>Data de Nascimento</td>

  <c:forEach var="contato" items="${dao.lista}">  	
    <tr> 
        <td> ${contato.nome} </td>
        <td> ${contato.email} </td>
        <td> ${contato.endereco} </td>
        <td> ${contato.dataNascimentoFormat} </td> 
        <td><a href="altera-contato.jsp?id=${contato.id}">Alterar</a></td>
        <td><a href="remove-contato.jsp?id=${contato.id}">Remover</a></td>
    </tr>
  </c:forEach>
</table>

</body>
</html>