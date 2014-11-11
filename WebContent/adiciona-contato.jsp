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

    <form action="adicionaContato">
      Nome: <input type="text" name="nome" /><br />
      E-mail: <input type="text" name="email" /><br />
      Endereço: <input type="text" name="endereco" /><br />
      Data de nascimento: <input type="text" name="dataNascimento" /><br />
      
      <input type="submit" value="submeter" />
    </form>
  </body>
</html>