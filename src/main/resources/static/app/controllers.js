angular.module('myApp.controllers')
    .controller('AppController',function($scope, ContactFactory) {

    ContactFactory.getContactList(function(response) {
        $scope.contacts = response;
    });

    //copy the references (you could clone ie angular.copy but then have to go through a dirty checking for the matches)
    $scope.displayedcontacts = [].concat($scope.contacts);

    $scope.addContact = function(firstName, lastName, emailAddress) {

        var data = {
            "firstName" : firstName,
            "lastName" : lastName,
            "emailAddress" : emailAddress
        }

        ContactFactory.addContact(data, function(contact) {
            console.log(contact);
            $scope.contacts.push(contact)
        });

        $scope.firstName = "";
        $scope.lastName = "";
        $scope.emailAddress = "";

    };
});
