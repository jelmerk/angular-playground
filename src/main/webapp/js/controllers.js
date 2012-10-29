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

