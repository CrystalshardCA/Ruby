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
    .when('/job/:id', {
        templateUrl: 'pages/job/edit.htm',
        controller: 'jobEditController'
    })
    .when('/job/create', {
        templateUrl: 'pages/job/edit.htm',
        controller: 'jobEditController'
    })
});