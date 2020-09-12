<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Lista Alumnos</title>
 <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    
</head>
<body>

    <main role="main" class="container-fluid">
           
        <div class="container col-12">
             
            <div class="row">
                <div class="col-12">
                    <table class="table table-hover table-bordered table-sm">
                    <thead class="thead-light">
                        <tr>
                            <th width="25%">
                                ID Alumno
                            </th>
                            <th width="75%">
                                Nombre
                            </th >
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="a" items="${alumnos}">
                                <tr>
                                    <td ><c:out value="${a.getIdalumno()}" /> </td>
                                    <td ><c:out value="${a.getNombre()}" /> </td>                          
                                </tr>
                      </c:forEach>
                    </tbody>
                    </table>
                </div>
            </div>
        

        

    </div>
    </main>

</body>
</html>