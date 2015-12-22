var contactServices = angular.module('myApp.services', ['ngResource']);

var contactFactory = function($resource) {
    return $resource('', {}, {
        getContactList :{
            method: 'GET',
            params: {},
            url: 'http://localhost:8070/contacts',
            isArray: true
        },
        addContact: {
            method: 'POST',
            params: {},
            url: 'http://localhost:8070/contacts/add',
            isArray: false
        }
    });
}

contactServices.factory('ContactFactory', ['$resource', contactFactory]);
