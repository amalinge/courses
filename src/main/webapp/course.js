class LectCourses {

	constructor (http) {
		this.$http = http;
	}
  
	lecture () {
		return this.$http({method: 'GET', url: 'http://localhost:9080/courses/rest/courses'});
    }
	  
	lectureAchats (idC) {
		return this.$http({method: 'GET', url: 'http://localhost:9080/courses/rest/achats/' + idC});
    }
	 
	retour () {
		return this.$http({method: 'GET', url: 'http://localhost:9080/courses'});
    }
}
LectCourses.$inject = ['$http'];

angular
  .module('courses', [])
  
  .controller('coursesCtrl', ['$scope', '$http', 'LectCourses', function ($scope, $http, LectCourses) {
      $scope.courses = [];
      $scope.detail = [];
      $scope.achats = [[]];

      LectCourses.lecture().then(successCCallback, errorCallback);

      function successCCallback(response) {
    	  $scope.courses = response.data;
 		  for (let i = 0; i < $scope.courses.length ; i++) {
 	          LectCourses.lectureAchats($scope.courses[i].idC)
 	      		.then(function(response) {
 	      			$scope.achats[i] = response.data;
 	      		}, errorCallback);
 		  };
      }
      
      function errorCallback(response) {
    	  console.error ("Erreur : ", arguments);
      }
 
      $scope.detail = function (idC) {
  		  let trouve = false;
 		  for (let i = 0; i < $scope.courses.length && !trouve ; i++) {
  			  if ($scope.courses[i].idC == idC) {
  				  $scope.detail[i] = true;
  				  trouve = true;
  			  };
		  };
      }   	  
      
      $scope.ifDetail = function (idC) {
  		  let trouve = false;
 		  for (let i = 0; i < $scope.courses.length&& !trouve  ; i++) {
  			  if ($scope.courses[i].idC == idC) {
  				  trouve = true;
  			  };
		  };
		  if (trouve && $scope.detail[i]) {
			  return true;
		  }
		  else {
			  return false;
		  }
      }   	  

      $scope.retour = function () {
          retour();
      }   	  

  }])
  
  .service('LectCourses', LectCourses);
