class CreerCourse {

	constructor (http) {
		this.$http = http;
	}
  
	lireEnseignes () {
//		return this.$http({method: 'GET', url: 'http://localhost:9080/courses/rest/enseignes'});
		return this.$http.get('http://localhost:9080/courses/rest/enseignes');
    }
	  
	lireProduits () {
//		return this.$http({method: 'GET', url: 'http://localhost:9080/courses/rest/produits'});
		return this.$http.get('http://localhost:9080/courses/rest/produits');
    }
	
	creCourse (idE, date) {
//		return this.$http({method: 'POST', url: 'http://localhost:9080/courses/rest/enseignes/' + idE + '/course', data: {date: date}});
		return this.$http.post('http://localhost:9080/courses/rest/enseignes/' + idE + '/course', {date: date});
	}
	
	creAchat (idC, idP, qte) {
		return this.$http.post('http://localhost:9080/courses/rest/courses/' + idC + '/achat/' + idP, {qte: qte});
	}

}

CreerCourse.$inject = ['$http'];

angular
  .module('creercourse', [])
  
  .controller('creercourseCtrl', ['$scope', '$http', 'CreerCourse', function ($scope, $http, CreerCourse) {
      $scope.listenseignes = [];
      $scope.idE = 0;
      $scope.date = 0;
      $scope.listproduits = [];
      $scope.achats = [];
      $scope.idC = 0;
      $scope.idP = 0;
      $scope.nomP;
      $scope.qte = 1;
      $scope.creationOK = false;

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
    	  rechnom($scope.idP);
    	  $scope.achats.push({"idP": $scope.idP, "nomP": $scope.nomP, "qte": $scope.qte});
    	  $scope.idP = 0;
    	  $scope.qte = 1;
      } 
  
  	  function rechnom(idP) {
  		  let trouve = false;
  		  $scope.nomP = "";
 		  for (let i = 0; i < $scope.listproduits.length && !trouve ; i++) {
  			  if ($scope.listproduits[i].idP == idP) {
  				  $scope.nomP = $scope.listproduits[i].nomP;
  				  trouve = true;
  			  };
  		  };
  	  }
      
      $scope.supprimer = function (idP) {
  		  let trouve = false;
 		  for (let i = 0; i < $scope.achats.length && !trouve ; i++) {
  			  if ($scope.achats[i].idP == idP) {
  				  $scope.achats.splice(i,1);
  				  trouve = true;
  			  };
  		  };
      }   	  
      
      $scope.creCourse = function () {
    	  $scope.idC = 0;
    	  CreerCourse.creCourse($scope.idE, $scope.date).then(successCCallback, errorCallback);
    	  $scope.idE = 0;
    	  $scope.date = 0;
    	  $scope.achats = [];
      }   	  

      function successCCallback(response) {
    	  $scope.idC = response.data;
 		  for (let i = 0; i < $scope.achats.length ; i++) {
			 CreerCourse.creAchat($scope.idC, $scope.achats[i].idP, $scope.achats[i].qte).then(successCallback, errorCallback);
		  };
	      $scope.creationOK = true;
      }

      function successCallback(response) {
      }

  }])
  
  .service('CreerCourse', CreerCourse);
