// CONTROLLERS
ruby.controller('homeController', ['$scope', function($scope) {
    

    
}]);

ruby.controller('jobController', ['$scope', '$resource', 'Job', function($scope, $resource, Job) {

    $scope.jobs = Job.query();

    $scope.delete = function(job) {
        if (confirm("Clicking yes will delete this job. Press yes if you would like to proceed.")) {
            Job.delete({id : job.id});
            var index = $scope.jobs.indexOf(job);
            $scope.jobs.splice(index, 1);
            $scope.$emit('jobDeleted', job);
        }
    }

}]);

ruby.controller('jobEditController', ['$scope', '$resource', '$window', '$routeParams', 'Job', function($scope, $resource, $window, $routeParams, Job) {

    $scope.jobId = $routeParams.id !== "create" ? $routeParams.id : "";

    if ($scope.jobId !== "") {
        $scope.job = Job.get({id : $scope.jobId});
    }

    $scope.update = function() {
        Job.update({id:$scope.job.id}, $scope.job);
        $window.location.reload(true);
        $window.location.href = '#/job';
    };

    $scope.create = function() {
        Job.create({}, $scope.job);
        $window.location.reload(true);
        $window.location.href = '#/job';
    };

}]);