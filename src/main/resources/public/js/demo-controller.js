/**
 * 
 */
function loginController($scope, $http) {
	$scope.formData = {};
	$scope.login = function() {
		$scope.response = {};
		$http.post(
				'/login',
				$scope.formData,
				{
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					},
					transformRequest : function(postData) {
						var str = [];
						angular.forEach(postData, function(value, key) {
							this.push(encodeURIComponent(key) + '='
									+ encodeURIComponent(value));
						}, str);
						return str.join('&');
					}
				}).then(function(response) {
			$scope.response.data = response;
		});
	};
}
function AccountController1($scope, $http) {
	$scope.formData = {};
	$scope.create = function() {
		$http.post('/api/v1/account', $scope.formData, {}).then(
				function(response) {
					$scope.response.data = response;
				});
	};
}
function AccountController2($scope, $http) {
	$scope.formData = {
		account : {},
		page : 1
	};
	$scope.search = function() {
		$http.get('/api/v1/account', $scope.formData, {}).then(
				function(response) {
					$scope.items = response.data;
				});
	};
}