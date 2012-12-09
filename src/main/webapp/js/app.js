'use strict';


// Declare app level module which depends on filters, and services
angular.module('addressBook', ['addressBook.filters', 'addressBook.services', 'addressBook.directives']).
  config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
    $locationProvider.html5Mode(true);

    $routeProvider.when('/addressbook/:pageStartIndex', {templateUrl: '/partials/addressbook.html', controller: AddressBookController,resolve: AddressBookController.resolve});
    $routeProvider.when('/addressbook/entry/:addressId', {templateUrl: '/partials/address.html', controller: AddressController});

    $routeProvider.otherwise({redirectTo: '/addressbook/0'});
  }]);
