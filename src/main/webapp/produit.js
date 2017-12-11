class LectProduits {

	constructor (http) {
		this.$http = http;
	}
  
	lecture () {
		return this.$http({method: 'GET', url: 'http://localhost:9080/courses/rest/produits'});
    }
	 
	retour () {
		return this.$http({method: 'GET', url: 'http://localhost:9080/courses'});
    }
}

LectProduits.$inject = ['$http'];

angular
  .module('produits', [])
  
  .controller('produitsCtrl', ['$scope', '$http', 'LectProduits', function ($scope, $http, LectProduits) {
      $scope.produits = [];

      LectProduits.lecture().then(successCallback, errorCallback);

      function successCallback(response) {
    	  $scope.produits = response.data;
      }
      function errorCallback(response) {
    	  console.error ("Erreur : ", arguments);
      }
      
      $scope.retour = function () {
    	  LectProduits.retour();
      }   	  

  }])
  
  .service('LectProduits', LectProduits);
