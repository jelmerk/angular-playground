<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en" ng-app="addressBook">
<head>
    <meta charset="utf-8">
    <title>Address book</title>

    <link rel="stylesheet" href="<c:url value="/css/bootstrap.css" />"/>
    <link rel="stylesheet" href="<c:url value="/css/app.css" />"/>


</head>
<body>

    <form class="navbar-search pull-right">
        <input type="text" class="search-query" placeholder="Search">
    </form>

    <div ng-view></div>

    <div>Address book: v<span app-version></span></div>

    <!-- In production use:
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.0.2/angular.min.js"></script>
    -->
    <script src="<c:url value="/lib/angular/angular.js"/>"></script>
    <script src="<c:url value="/lib/angular/angular-resource.js"/>"></script>
    <script src="<c:url value="/lib/bootstrap/bootstrap.js"/>"></script>
    <script src="<c:url value="/js/app.js"/>"></script>
    <script src="<c:url value="/js/services.js"/>"></script>
    <script src="<c:url value="/js/controllers.js"/>"></script>
    <script src="<c:url value="/js/filters.js"/>"></script>
    <script src="<c:url value="/js/directives.js"/>"></script>

</body>
</html>
