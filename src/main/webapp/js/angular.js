var app = angular.module('app', []);

app.controller('getfoodController', function($scope, $http, $location) {
	
	$scope.showFood = false;
	
	$scope.getFood = function() {
		var url = $location.absUrl() + "food/" + $scope.foodId;

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}

		$http.get(url, config).then(function(response) {

			if (response.data.status == "Done") {
				$scope.food = response.data;
				$scope.showFood = true;

			} else {
				$scope.getResultMessage = "Food Data Error!";
			}

		}, function(response) {
			$scope.getResultMessage = "Fail!";
		});

	}
});

app.controller('getfoodsbyfoodController', function($scope, $http, $location) {
	
	$scope.showFoodsByFoodType = false;
	
	$scope.getFoodsByFoodType = function() {
		var url = $location.absUrl() + "foodType";

		var config = {
			headers : {	'Content-Type' : 'application/json;charset=utf-8;' },
		
			params: { 'foodType' : $scope.foodType, 'pageNumber' : $scope.pageNumber}
		}

		$http.get(url, config).then(function(response) {

			if (response.data.status == "Done") {
				$scope.allfoodsbyfood = response.data;
				$scope.showFoodsByFoodType = true;

			} else {
				$scope.getResultMessage = "Food Data Error!";
			}

		}, function(response) {
			$scope.getResultMessage = "Fail!";
		});

	}
});
