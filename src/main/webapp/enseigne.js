class LectEnseignes {

	constructor (http) {
		this.$http = http;
	}
  
	lecture () {
		return this.$http({method: 'GET', url: 'http://localhost:9080/courses/rest/enseignes'});
    }
}

LectEnseignes.$inject = ['$http'];

angular
  .module('enseignes', [])
  
  .controller('enseignesCtrl', ['$scope', '$http', 'LectEnseignes', function ($scope, $http, LectEnseignes) {
      $scope.enseignes = [];

      LectEnseignes.lecture().then(successCallback, errorCallback);

      function successCallback(response) {
    	  $scope.enseignes = response.data;
      }
	  
      function errorCallback(response) {
    	  console.error ("Erreur : ", arguments);
      }

  }])
  
  .service('LectEnseignes', LectEnseignes);
