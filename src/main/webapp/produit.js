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
//      $scope.debut = 0;
//      $scope.page = 1;

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
      
//      function lect(debut) {

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

//      lect(0);
//		1er affichage      
      
//      $scope.plusmoins = function (sens) {
//    	  if ("+" === sens) {
//    		  $scope.debut = $scope.debut + 10;
//    	  } else {
//    		  $scope.debut = $scope.debut - 10;
//    	  }
//    	  affich($scope.debut);      }
//      
//      $scope.acces = function (numpage) {
//    	  console.log(numpage);
//    	  $scope.debut = (numpage-1)*10;
//          affich($scope.debut);
//      }   	  
//      
//      function affich(debut) {
//          lect(debut);
//          $scope.page = (debut/10) + 1;
//          $scope.pages = [];
//          for (let numpage = 1; numpage < $scope.page ; numpage++) {
//        	  $scope.pages.push({npage: numpage});
//          }
//      }
    
  }])
  
  .service('LectProduits', LectProduits);
