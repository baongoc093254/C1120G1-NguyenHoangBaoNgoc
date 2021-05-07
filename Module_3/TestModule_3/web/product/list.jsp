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
                <a class="nav-link" href="/product">Product</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="#">Employee</a>
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
    <a href="/product?action=create">
        <button type="button" class="btn btn-primary">Create New Product</button>
    </a>
<table id ="product" class="table table-dark">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Price</th>
        <th scope="col">Discount</th>
        <th scope="col">Stock</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${productList}" var="product">
        <tr>
            <td><c:out value="${product.getIdProduct()}"></c:out></td>
            <td><a href="/room?action=view&id=${product.getIdProduct()}"><c:out value="${product.getNameProduct()}"></c:out></a></td>
            <td><c:out value="${product.getPrice()}"></c:out></td>
            <td><c:out value="${product.getDiscount()}"></c:out>
            </td>
            <td><c:out value="${product.getStock()}"></c:out></td>
            <td><a href="/customer?action=update&id=${product.getIdProduct()}" ><button type="button" class="btn btn-warning"><i class="fas fa-user-edit" ></i></button></a></td>
            <td><button class="btn btn-danger" type="button" onclick="customerSetId('${product.getIdProduct()}','${product.getNameProduct()}')"
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
<div class="footer-left" style="margin-bottom:0">
    <footer class="bg-dark text-center text-white">
        <!-- Grid container -->
        <div class="container p-4 pb-0">
            <!-- Section: Social media -->
            <section class="mb-4">
                <!-- Facebook -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                ><i class="fab fa-facebook-f"></i
                ></a>

                <!-- Twitter -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                ><i class="fab fa-twitter"></i
                ></a>

                <!-- Google -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                ><i class="fab fa-google"></i
                ></a>

                <!-- Instagram -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                ><i class="fab fa-instagram"></i
                ></a>

                <!-- Linkedin -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                ><i class="fab fa-linkedin-in"></i
                ></a>

                <!-- Github -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                ><i class="fab fa-github"></i
                ></a>
            </section>
            <!-- Section: Social media -->
        </div>
        <!-- Grid container -->

        <!-- Copyright -->
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
            © 2020 Copyright:
            <a class="text-white" href="https://mdbootstrap.com/">Bao Ngoc</a>
        </div>
        <!-- Copyright -->
    </footer>
</div>





<script src="../assert/jquery/jquery-3.5.1.min.js"></script>
<script src="../assert/bootstrap413/js/popper.min.js"></script>
<script src="../assert/datatables/js/jquery.dataTables.min.js"></script>
<script src="../assert/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="../assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="../assert/bootstrap413/js/bootstrap.bundle.js"></script>
<script>
    $(document).ready(function () {
        $('#product').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        })
    })
</script>
<script>
    $(document).ready(function () {
        $('#product').DataTable();
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

