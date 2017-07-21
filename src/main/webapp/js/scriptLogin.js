// chamar a aplicacao
var applogin = angular.module('applogin', []);

// acionar controller e introducao as tarefas
applogin.controller("controllerLogin", ['$scope', function($scope, $window){

	$scope.logar = function(userName) {

		window.location = "home.html";
	}

}]);
