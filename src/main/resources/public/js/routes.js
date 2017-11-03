// ROUTES
ruby.config(function ($routeProvider) {
   
    $routeProvider
    
    .when('/', {
        templateUrl: 'pages/home.htm',
        controller: 'homeController'
    })

    .when('/job', {
        templateUrl: 'pages/job/index.htm',
        controller: 'jobController'
    })

});