'use strict';

/* Controllers */


function MyCtrl1() {
}
MyCtrl1.$inject = [];


function MyCtrl2() {
}
MyCtrl2.$inject = [];


function TodoListController($scope, Item) {

    var items = Item.query();
	
	$scope.items = items;
	
	$scope.remaining = function() {
		return items.reduce(function(count, item) {
			return item.done ? count : count+ 1
			}, 0);
	};
	
	$scope.add = function(newItem) {
		var item = new Item({ text : newItem.text, done: false });
		items.push(item);
		newItem.text = "";

        item.$save();
	}
}
TodoListController.$inject = ['$scope', 'Item'];

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