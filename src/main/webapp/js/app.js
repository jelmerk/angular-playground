'use strict';


// Declare app level module which depends on filters, and services
angular.module('myApp', ['myApp.filters', 'myApp.services', 'myApp.directives']).
  config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
//    $locationProvider.html5Mode(true);
    $routeProvider.when('/view1', {templateUrl: 'partials/partial1.html', controller: MyCtrl1});
    $routeProvider.when('/view2', {templateUrl: 'partials/partial2.html', controller: MyCtrl2});
    $routeProvider.when('/todo-list', {templateUrl: 'partials/todolist.html', controller: TodoListController});

    $routeProvider.when('/addressbook', {templateUrl: 'partials/addressbook.html', controller: AddressBookController});
    $routeProvider.when('/addressbook/:addressId', {templateUrl: 'partials/address.html', controller: AddressController});

    $routeProvider.otherwise({redirectTo: '/view1'});
  }]);
