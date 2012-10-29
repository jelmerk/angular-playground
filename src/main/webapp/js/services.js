'use strict';

/* Services */


angular.module('myApp.services', ['ngResource']).
  factory('Item', ['$resource',function($resource) {

    var Item = $resource('resources/todos/:id', {'id': '@_id'}, {
        'update': { method: 'PUT' }
    });

	return Item;



  
  }]).
  value('version', '0.2');
  
  
