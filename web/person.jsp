<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/29/2021
  Time: 1:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/header.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/menu.jsp"/>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">ADD PERSON</div>
        <div class="panel-body">
            <form action="/action/person/save">
                <label>First Name</label>
                <input class="form-control" type="text" name="name" style="width: 100%"/>
                <br/>
                <label>Last Name</label>
                <input class="form-control" type="text" name="family" style="width: 100%"/>
                <br/>
                <label>Your gender</label>
                <input  class="form-control" type="text" name="gender" style="width: 100%"/>
                <br/>
                <label>Field of Study</label>
                <input class="form-control" type="text" name="education" style="width: 100%"/>
                <br/>
                <label>Your current job</label>
                <input class="form-control" type="text" name="job" style="width: 100%"/>
                <br/>
                <input class="btn btn-primary" type="submit" value="SAVE" style="width: 100%"/>
                <br/>
            </form>

            <table class="table table-striped hover-square" style="width: 100%">
                <tr>
                    <td>ID</td>
                    <td>NAME</td>
                    <td>FAMILY</td>
                    <td>GENDER</td>
                    <td>STUDY</td>
                    <td>JOB</td>
                </tr>
    <c:forEach items="${requestScope.list}" var="person">

        <tr>
            <form action="/action/person/update">
                <td><input  type="text" name="personId" value="${person.personId}" readonly/></td>
                <td><input style="width: 100%" class="form-control" type="text" name="name" value="${person.name}"/></td>
                <td><input style="width: 100%" class="form-control" type="text" name="family" value="${person.family}"/></td>
                <td><input style="width: 100%" class="form-control" type="text" name="gender" value="${person.gender}"/></td>
                <td><input style="width: 100%" class="form-control" type="text" name="education" value="${person.education}"/></td>
                <td><input style="width: 100%" class="form-control" type="text" name="job" value="${person.job}"/></td>
                <td><input style="width: 100%" class="btn btn-success" type="submit" value="UPDATE"/></td>
                <td><input style="width: 100%" class="btn btn-danger" type="button" value="REMOVE" onclick="removePerson(${person.personId})"/></td>
            </form>
        </tr>
    </c:forEach>
</table>
            <script>
                function removePerson(id) {
                    if (confirm('ARE YOU SURE?'))
                        window.location = "/action/person/remove?personId=" + id;
                }
            </script>
        </div>
    </div>
</div>
</body>
</html>
