angular.module('myApp.controllers')
    .controller('AppController',function($scope, ContactFactory) {

    ContactFactory.getContactList(function(response) {
        console.log(response);
        $scope.contacts = response;
    }); //query() returns all the entries

   /* $scope.addContact = function(firstName, lastName, emailAddress) {

        new ContactFactory({
          firstName: firstName,
          lastName: lastName,
          emailAddress: emailAddress

        }).addContact().save(function(contact) {
            $scope.contacts.push(contact)
        });
    };
       */

   /* $scope.contactFactory = new ContactFactory(); //You can instantiate resource class

    $scope.contactFactory.data = {"firstName": "Some Name",
                                   "lastName" : "Some LastName",
                                    "emailAddress": "some email"};

    var savedContact = ContactFactory.save($scope.contactFactory, function() {
       console.log(savedContact);

       $scope.savedContact = savedContact;

        //data saved. do something here.
    }); //saves an entry. Assuming $scope.entry is the Entry object    */
});