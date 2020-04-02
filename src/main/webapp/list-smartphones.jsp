<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
    <h2>Search by model</h2>
    <!--Search Form -->
    <form action="/smartphones" method="get" id="seachSmartphoneForm" role="form" >
        <input type="hidden" id="searchAction" name="searchAction" value="getListByModel"/>
        <div class="form-group col-xs-5">
            <input type="text" name="modelSmartphone" id="modelSmartphone" class="form-control" required="true"
                   placeholder="Input model for search, please!"/>
        </div>
        <button type="submit" class="btn btn-info">
            <span class="glyphicon glyphicon-search"></span> Search
        </button>
    </form>
</div>
<div class="container">
    <h2>Search by price</h2>
    <!--Search Form -->
    <form action="/smartphones" method="get" id="seachSmartphonePriceForm" role="form" >
        <input type="hidden" id="searchActionPrice" name="searchAction" value="getListByPrice"/>
        <div class="form-group col-xs-5">
            <input type="text" name="priceSmartphone" id="priceSmartphone" class="form-control" required="true"
                   placeholder="Input price for search, please!"/>
        </div>
        <button type="submit" class="btn btn-info">
            <span class="glyphicon glyphicon-search"></span> Search
        </button>
    </form>
</div>

<form action="/edit" method="post" id="showSmartphoneForm" role="form" >
    <input type="hidden" id="idSmartphone" name="idSmartphone">
    <input type="hidden" id="action" name="action">
    <c:if test="${not empty message}">
        <c:choose >
            <c:when test="${success}">
        <div class="alert alert-success">
                ${message}
        </div>
            </c:when>
            <c:when test="${success==false}">
            <div class="alert alert-danger">
                    ${message}
            </div>
            </c:when>
        </c:choose>
    </c:if>
    <c:choose>
        <c:when test="${not empty smartphoneList}">
            <table  class="table table-striped">
                <thead>
                <tr>
                    <td>Model</td>
                    <td>Name</td>
                    <td>Diagonal</td>
                    <td>Price</td>
                    <td>Memory</td>
                    <td>Processor</td>
                    <td>VersionOS</td>
                </tr>
                </thead>
                <c:forEach var="smartphone" items="${smartphoneList}">
                    <c:set var="classSucess" value=""/>
                    <tr class="${classSucess}">
                        <td>${smartphone.model}</td>
                        <td>${smartphone.name}</td>
                        <td>${smartphone.diagonal}</td>
                        <td>${smartphone.price}</td>
                        <td>${smartphone.memory}</td>
                        <td>${smartphone.processor}</td>
                        <td>${smartphone.versionOS}</td>
                        <td>
                            <a href="/edit?idSmartphone=${smartphone.id}">
                                <span class="glyphicon glyphicon-pencil"></span>
                            </a>

                        </td>
                        <td>
                            <button id="remove" class="btn btn-danger"
                               onclick="document.getElementById('idSmartphone').value='${smartphone.id}';
                                       document.getElementById('action').value='remove';
                                       document.getElementById('showSmartphoneForm').submit();">
                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <br>  </br>
            <div class="alert alert-info">
                No smartphones which you need!
            </div>
        </c:otherwise>
    </c:choose>

</form>
<div class="container">
    <!--Search Form -->
    <form action="/smartphones" method="get" id="allSmartphoneForm" role="form" >
        <button type="submit" class="btn btn-info">
            <span class="glyphicon glyphicon-search"></span> Show all
        </button>
    </form>
</div>

<div class="container">
<form action ="new-smartphone.jsp">
    <br></br>
    <button type="submit" class="btn btn-primary  btn-md">New smartphone</button>
</form>
</div>