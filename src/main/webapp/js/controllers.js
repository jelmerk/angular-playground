'use strict';

function AddressBookController($scope, Address) {
    var addresses = Address.query();

    $scope.addresses = addresses;

}
AddressBookController.$inject = ['$scope', 'Address'];

function AddressController($scope, $location, $routeParams, Address) {

    if ($routeParams.addressId === 'new') {
        $scope.address = new Address();
    } else {
        $scope.address = Address.get({id: $routeParams.addressId});
    }

    $scope.add = function(newAddress) {
        newAddress.$save();

        $location.path('/addressbook');
    }

    $scope.update = function(existingAddress) {
        existingAddress.$update();

        $location.path('/addressbook');
    }

    $scope.delete = function(existingAddress) {
        existingAddress.$delete();

        $location.path('/addressbook');
    }


}
AddressController.$inject = ['$scope', '$location', '$routeParams', 'Address'];