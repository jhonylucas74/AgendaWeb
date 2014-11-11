<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Adicionar contato</title>
    <c:import url="head.html" />
</head>
<body>
	<c:import url="header.jsp" /> 
    Contato ${param.nome} alterado com sucesso.
    
    <a href="lista-contatos.jsp" >Voltar</a>
  </body>
</html>
