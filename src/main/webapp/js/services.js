'use strict';

/* Services */


angular.module('addressBook.services', ['ngResource']).
  factory('Address', ['$resource',function($resource) {

    var Address = $resource('resources/addresses/:id', { id:'@id'}, {
        'update': { method: 'PUT' }
    });

	return Address;

  }]).
  value('version', '0.2');
  
  
