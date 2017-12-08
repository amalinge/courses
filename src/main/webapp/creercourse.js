class CreerCourse {

	constructor (http) {
		this.$http = http;
	}
  
	lireEnseignes () {
		return this.$http({method: 'GET', url: 'http://localhost:9080/courses/rest/enseignes'});
    }
	  
	lireProduits () {
		return this.$http({method: 'GET', url: 'http://localhost:9080/courses/rest/produits'});
    }
	
	creCourse() {}
}

CreerCourse.$inject = ['$http'];

angular
  .module('creercourse', [])
  
  .controller('creercourseCtrl', ['$scope', '$http', 'CreerCourse', function ($scope, $http, CreerCourse) {
      $scope.listenseignes = [];
      $scope.ide;
      $scope.date;
      $scope.listproduits = [];
      $scope.achats = [];
      $scope.produit;
      $scope.qte;

      
//      $http({method: 'GET', url: 'http://localhost:9080/cities-rest-backend/rest/villes?from=0&limit=10'})
////			method, pas obligatoire, car GET par défaut
//      	.then(function(response) {
//    		$scope.cities = response.data;
//        }, function() {
//    		console.error ("Erreur : ", arguments);
////			cas d'erreur : affichage des arguments de response
//     	});
      
//		avec extraction des fonctions :
//        $http({method: 'GET', url: 'http://localhost:9080/cities-rest-backend/rest/villes?from=0&limit=10'})
//    		.then(successCallback, errorCallback);
      
      CreerCourse.lireEnseignes().then(successECallback, errorCallback);

      function successECallback(response) {
    	  $scope.listenseignes = response.data;
      }
      
      CreerCourse.lireProduits().then(successPCallback, errorCallback);

      function successPCallback(response) {
    	  $scope.listproduits = response.data;
      }
      
      function errorCallback(response) {
    	  console.error ("Erreur : ", arguments);
      }
      
      $scope.retour = function () {
          retour();
      }   	  
      
      $scope.ajouter = function () {
    	  creCourse();
      }   	  
    
  }])
  
  .service('CreerCourse', CreerCourse);
