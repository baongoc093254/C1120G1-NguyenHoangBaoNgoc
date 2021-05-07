<%--
  Created by IntelliJ IDEA.
  User: tynguyen
  Date: 3/18/21
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

    <title>Create New Customer</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../assert/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="../assert/fontawesome/css/all.min.css" type="text/css">

</head>
<body>
<div class="jumbotron text-center" style="margin-bottom:0">
    <h1>Furama Resort</h1>
    <div class="row" >
        <div class="col-sm-3">
            <a href="home">
                <img src="https://nhanlucnganhluat.vn/uploads/images/051D288B/logo/2018-12/Logo-FURAMA-RESORT.jpg" alt="logo" class="img-fluid" width="100" height="200">
            </a>
        </div>
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <h3 class="float-right" style="display:inline;">Nguyen Hoang Bao Ngoc</h3>
        </div>


    </div>


</div>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="home"><i class="fas fa-home"></i></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/home">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Employee</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="customer">Customer</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Service</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Contract</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" method="get">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" name="search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="action" value="search">Search</button>

        </form>
    </div>
</nav>
<div>
    <a href="/customer?action=create">
        <button type="button" class="btn btn-primary">Create New Customer</button>
    </a>
<table id ="customer" class="table table-dark">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Birth Day</th>
        <th scope="col">Gender</th>
        <th scope="col">Id Card</th>
        <th scope="col">Phone</th>
        <th scope="col">Email</th>
        <th scope="col">Address</th>
        <th scope="col">CustomerType</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customerList}" var="customer">
        <tr>
            <td><c:out value="${customer.getCustomer_id()}"></c:out></td>
            <td><a href="/customer?action=view&id=${user.getCustomer_id()}"><c:out value="${customer.getCustomer_name()}"></c:out></a></td>
            <td><c:out value="${customer.getCustomer_birthday()}"></c:out></td>
            <td><c:out value="${customer.isCustomer_gender() ? 'Male' : 'Female'}"></c:out>
            </td>
            <td><c:out value="${customer.getCustomer_id_card()}"></c:out></td>
            <td><c:out value="${customer.getCustomer_phone()}"></c:out></td>
            <td><c:out value="${customer.getCustomer_email()}"></c:out></td>
            <td><c:out value="${customer.getCustomer_address()}"></c:out></td>
            <td><c:out value="${customer.getCustomerType().getCustomer_type_name()}"></c:out></td>
            <td><a href="/customer?action=update&id=${customer.getCustomer_id()}" ><button type="button" class="btn btn-warning"><i class="fas fa-user-edit" ></i></button></a></td>
            <td><button class="btn btn-danger" type="button" onclick="customerSetId('${customer.getCustomer_id()}','${customer.getCustomer_name()}')"
                   data-toggle="modal" data-target="#modaldelete"><i class="fas fa-user-slash"></i></button></td>
<%--            <td><a href="/customer?action=delete&id=${customer.getCustomer_id()}" ><button type="button" class="btn btn-danger" ><i class="fas fa-user-slash"></i></button></a></td>--%>
<%--            onclick="customerSetId('${customer.getCustomer_id()}','${customer.getCustomer_name()}')"--%>
        </tr>
    </c:forEach>

    </tbody>
</table>
    <div class="modal fade" id="modaldelete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <input type="text" id="modelId" size="50" disabled style="border: none;background: white">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary" onclick="submitDelete()">Delete</button>
                </div>
            </div>
        </div>
    </div>
    <form action="/customer?action=delete" method="post" id="deleteCustomer">
        <input type="hidden" name="action" value="delete">
        <input type="hidden" name="idCustomer" id="idCustomer">
    </form>
</div>






<script src="assert/jquery/jquery-3.5.1.min.js"></script>
<script src="assert/bootstrap413/js/popper.min.js"></script>
<script src="assert/datatables/js/jquery.dataTables.min.js"></script>
<script src="assert/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="assert/bootstrap413/js/bootstrap.bundle.js"></script>
<script>
    $(document).ready(function () {
        $('#customer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        })
    })
</script>
<script>
    $(document).ready(function () {
        $('#customer').DataTable();
        $('.dataTables_length').addClass('bs-select');
    });

</script>
<script>
    function customerSetId(id, name) {
        document.getElementById("idCustomer").value = id;
        document.getElementById("modelId").value = "Do you want delete customer name: " + name;
    }
    function submitDelete() {
        document.getElementById("deleteCustomer").submit();
    }
</script>
<script type="text/javascript">
    function myFunction(message) {
        if (message) {
            $('#exampleModal').modal('show');
        }
    }
</script>

    </body>
</html>

