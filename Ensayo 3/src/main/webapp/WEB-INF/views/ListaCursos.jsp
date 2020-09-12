<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Lista Cursos</title>
<!-- Jquery -->
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
 <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    
</head>
<body class="bg-light">

    <main role="main" class="container pt-3">
    
        <div class="py-4 text-center">
            <h2>Lista Cursos</h2>
        </div>

        <div class="container col-12 col-md-8 col-lg-6">
             
            <div class="row mb-3">
                <div class="col-12">
                    <table class="table table-hover table-bordered table-sm">
                    <thead class="thead-light">
                        <tr>
                            <th width="10%">
                                ID
                            </th>
                            <th width="55%">
                                Nombre
                            </th >
                            <th width="35%">
                                Cantidad alumnos
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="c" items="${cursos}">
                                <tr>
                                    <td > <a class="link1" href="${pageContext.request.contextPath}/detalleAlumnos/${c.getIdcurso()}">  <c:out value="${c.getIdcurso()}" /> </a> </td>
                                    <td ><c:out value="${c.getNombre()}" /> </td>
                                    <td ><c:out value="${c.getN_alumnos()}" /> </td>                              
                                </tr>
                      </c:forEach>
                    </tbody>
                    </table>
                </div>
            </div>
        
     <!-- Modal -->
        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog modal-lg modal-dialog-centered">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title"></h5>
                        <button type="button" class="close" data-dismiss="modal">×</button>
                    </div>
                    <div class="modal-body px-0">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
        

    </div>
    </main>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script type="text/javascript">

$('.link1').click(function (e) {
    e.preventDefault();
    var id = $(this).attr('href').split(/[./]/)[3];;
    $('.modal-title').html("Lista alumnos curso ID: " + id);
    $('.modal-body').load(this.href, function () {
        $('#myModal').modal({ show: true });
    });
});

</script>

</body>
</html>