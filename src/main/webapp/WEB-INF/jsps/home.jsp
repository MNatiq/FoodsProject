<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Spring Boot Example</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.6.0/angular.min.js"></script>
<script src="/js/angular.js"></script>
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" />
</head>
<body>
	<div class="container" ng-app="app">
		<h1>Food information</h1>

			<div ng-controller="getfoodController" class="col-md-6">
				<h3>Food by ID</h3>

				<input type="text" class="form-control" style="width: 100px;"
					ng-model="foodId" /> <br />
				<button ng-click="getFood()">Get Food</button>

        <div ng-show="showFood">
          <ul class="list-group">
            <li ng-repeat="custom in food.data.servings"><h4 class="list-group-item">
                <strong>Serving {{$index}}</strong><br />
                Id: {{custom.servingId}}<br />
                ServingDescription: {{custom.servingDescription}}<br />
  ServingUrl: {{custom.servingUrl}};
  MetricServingAmount: {{custom.metricServingAmount}};
  metricServingUnit: {{custom.metricServingUnit}};
  numberOfUnits: {{custom.numberOfUnits}};
  measurementDescription: {{custom.measurementDescription}};
  calories: {{custom.calories}};
  carbohydrate: {{custom.carbohydrate}};
  protein: {{custom.protein}};
  fat: {{custom.fat}};
  saturatedFat: {{custom.saturatedFat}};
  polyunsaturatedFat: {{custom.polyunsaturatedFat}};
  monounsaturatedFat: {{custom.monounsaturatedFat}};
  transFat: {{custom.transFat}};
  cholesterol: {{custom.cholesterol}};
  sodium: {{custom.sodium}};
  potassium: {{custom.potassium}};
  fiber: {{custom.fiber}};
  sugar: {{custom.sugar}};
  vitaminA: {{custom.vitaminA}};
  vitaminC: {{custom.vitaminC}};
  calcium: {{custom.calcium}};
  iron: {{custom.iron}};
            </h4></li>
          </ul>
        </div>


				<p>{{getResultMessage}}</p>
			</div>

			<div ng-controller="getfoodsbyfoodController" class="col-md-4">
				<h3>Foods by type</h3>

				<input type="text" class="form-control" style="width: 100px;" ng-model="foodType" /><br />
				<h3>Page number</h3>
				<input type="text" class="form-control" style="width: 100px;" ng-model="pageNumber" /><br />
				<button ng-click="getFoodsByFoodType()">Get Foods</button>

				<div ng-show="showFoodsByFoodType">

					<ul class="list-group">
						<li ng-repeat="food in allfoodsbyfood.data"><h4	class="list-group-item">
								<strong>Food {{$index}}</strong><br />

								  name: {{food.name}};
                  url: {{food.url}};
                  type: {{food.type}};
                  id: {{food.id}};
                  description: {{food.description}};
                  brandName: {{food.brandName}};
						</h4></li>
					</ul>
				</div>
				<p>{{getResultMessage}}</p>
			</div>

		</div>
	</div>
</body>
</html>