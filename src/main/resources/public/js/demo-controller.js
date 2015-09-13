/**
 * 
 */
function loginController($scope, $http) {
	$scope.data = {};
	$scope.login = function() {
		$scope.response = {};
		$http.post(
				'/login',
				$scope.data,
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
				}).success(function(response) {
			$scope.response.data = response;
		});
	};
}