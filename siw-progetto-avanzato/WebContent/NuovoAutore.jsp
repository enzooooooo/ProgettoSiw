
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form action="controllerAutore" method="post">
       <div>*nome:<input type="text" name = "nome" value = "${nome}"/>
       </div>
       <div>*cognome:<input type="text" name = "cognome" value = "${desc}"/>
       </div>
<input type="submit" 
			name="sumbit" value="invia" />
</form>
</body>
</html>