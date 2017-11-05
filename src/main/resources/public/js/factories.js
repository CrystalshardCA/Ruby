ruby.factory('Job', ['$resource', function($resource) {
    return $resource('/api/v1/job/:id', null, {
        query : {
            method: 'GET',
            isArray: true,
            transformResponse: function(data) {
                return angular.fromJson(data).results;
            }
        },
        get : {
            method: 'GET',
            transformResponse: function(data) {
                return angular.fromJson(data).results;
            }
        },
        delete : {
            method : 'DELETE',
            url : '/api/v1/job/:id'
        },
        update : {
            method : 'PUT'
        },
        create : {
            method : 'POST'
        }
    });
}]);