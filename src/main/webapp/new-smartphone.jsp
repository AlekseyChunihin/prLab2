<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin=“anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
    <form action="/edit" method="post"  role="form" data-toggle="validator" >
        <c:if test ="${empty action}">
            <c:set var="action" value="add"/>
        </c:if>
        <input type="hidden" id="action" name="action" value="${action}"/>

        <h2>Smartphone</h2>

        <c:if test="${not empty smartphone.id}">
        <div class="form-group col-xs-4">
            <label for="idSmartphone" class="control-label col-xs-4">ID:</label>
            <input type="number" id="idSmartphone" name="idSmartphone" value="${smartphone.id}"
                   required="true" readonly />
            </c:if>
            <c:if test="${empty smartphone.id}">
            <div class="form-group col-xs-4">
                <label for="idSmartphone" class="control-label col-xs-4">ID:</label>
                <input type="number" id="idSmartphone" name="idSmartphone" value="${smartphone.id}"
                       required="true" min="1"/>
                </c:if>
        <div class="form-group col-xs-4">
            <label for="model" class="control-label col-xs-4">Model:</label>
            <input type="text" name="model" id="model" class="form-control" value="${smartphone.model}"
                   required="true"/>

            <label for="name" class="control-label col-xs-4">Name:</label>
            <input type="text" name="name" id="name" class="form-control" value="${smartphone.name}"
                   required="true"/>

            <label for="diagonal" class="control-label col-xs-4">Diagonal:</label>
            <input type="number" name="diagonal" id="diagonal" class="form-control" value="${smartphone.diagonal}"
                   min="3" max="15" step="0.1" required="true"/>

            <label for="price" class="control-label col-xs-4">Price:</label>
            <input type="number" name="price" id="price" class="form-control" value="${smartphone.price}"
                   min="1" max="100000" required="true"/>

            <label for="memory" class="control-label col-xs-4">Memory:</label>
            <input type="number" name="memory" id="memory" class="form-control" value="${smartphone.memory}"
                   min="1" max="64" required="true"/>

            <label for="processor" class="control-label col-xs-4">Processor:</label>
            <input type="text" name="processor" id="processor" class="form-control" value="${smartphone.processor}"
                   required="true"/>

            <label for="versionOS" class="control-label col-xs-4">VersionOS:</label>
            <input type="text" name="versionOS" id="versionOS" class="form-control" value="${smartphone.versionOS}"
                   required="true"/>

            <br></br>
            <button type="submit" class="btn btn-primary  btn-md">Accept</button>
        </div>
    </form>
</div>
</body>
</html>