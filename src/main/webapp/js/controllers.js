'use strict';

function AddressBookController($scope, page) {

    $scope.addresses = page;

    $scope.hasPreviousPage = function() {
        return !page.firstPage;
    }

    $scope.pages = function() {

        var range = function(start, end) {
            var result = [];
            for (var i = start; i <= end; i++) {
                result.push(i);
            }
            return result;
        };

        var firstPage = page.number - 5;

        if (firstPage < 0) {
            firstPage = 0;
        }

        var lastPage = page.number + 5;

        var largestPossiblePage = page.totalPages - 1;

        if (lastPage > largestPossiblePage) {
            lastPage = largestPossiblePage;
        }

        return range(firstPage, lastPage);
    }

    $scope.hasNextPage = function() {
        return !page.lastPage;
    }
}

AddressBookController.resolve = {
    page: function($q, $route, Address) {

        var pageStartIndex = $route.current.params.pageStartIndex;

        var deferred = $q.defer();

        Address.pagedQuery({ pageSize: 5, pageStartIndex: pageStartIndex }, function(result) {
            deferred.resolve(result);
        });

        return deferred.promise;
    }
}

// TODO fix inject for AddressBookController, and AddressBookController.resolve how does that work ?

// AddressBookController.$inject = ['$scope', '$routeParams', 'Address'];

function AddressController($scope, $location, $routeParams, Address) {

    var back = function() {
        $location.path('/addressbook');
    };

    if ($routeParams.addressId === 'new') {
        $scope.address = new Address();
    } else {
        $scope.address = Address.get({id: $routeParams.addressId});
    }

    $scope.add = function(newAddress) {
        newAddress.$save(back);
    }

    $scope.update = function(existingAddress) {
        existingAddress.$update(back);
    }

    $scope.delete = function(existingAddress) {
        if (confirm('Are you sure you want to delete this address?')) {
            existingAddress.$delete(back);
        }
    }
}
AddressController.$inject = ['$scope', '$location', '$routeParams', 'Address'];