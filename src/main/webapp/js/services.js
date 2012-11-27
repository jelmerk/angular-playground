'use strict';

/* Services */


angular.module('addressBook.services', ['ngResource']).
  factory('Address', ['$resource',function($resource) {

    var Address = $resource('/resources/addresses/:id', { id:'@id'}, {
        'update': { method: 'PUT' },
        'pagedQuery': { method: 'GET', isArray:false}
    });

	return Address;

  }]).
  value('version', '0.1.0');
  
  
