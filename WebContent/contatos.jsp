<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
				
<html>
<head>
</head>
<body>
 JSP :D JSTL
  <ul>
  <jsp:useBean id="dao" class="model.ContatoDAO"/>
  
  <c:forEach var="contato" items="${dao.list}">  
  	<li> nome: ${contato.nome} email: <a href="mailto:${contato.email}" > Enviar</a></li>
  </c:forEach>
	
	
  
  </ul>
  

</body>

</html>