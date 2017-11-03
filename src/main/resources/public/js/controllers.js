// CONTROLLERS
ruby.controller('homeController', ['$scope', function($scope) {
    

    
}]);

ruby.controller('jobController', ['$scope', '$resource', function($scope, $resource) {

    $scope.jobAPI = $resource('/api/v1/job');

    $scope.jobs = $scope.jobAPI.get();

}]);