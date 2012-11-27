'use strict';


// Declare app level module which depends on filters, and services
angular.module('addressBook', ['addressBook.filters', 'addressBook.services', 'addressBook.directives']).
  config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
    $locationProvider.html5Mode(true);

    $routeProvider.when('/angular-playground/addressbook/:pageStartIndex', {templateUrl: '/angular-playground/partials/addressbook.html', controller: AddressBookController});
    $routeProvider.when('/angular-playground/addressbook/entry/:addressId', {templateUrl: '/angular-playground/partials/address.html', controller: AddressController});

    $routeProvider.otherwise({redirectTo: '/angular-playground/addressbook/0'});
  }]);
