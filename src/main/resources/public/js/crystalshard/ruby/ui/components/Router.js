namespace('crystalshard.ruby.ui.components');

crystalshard.ruby.ui.components.Router = (function () {

    // Imports
    var Path = crystalshard.ruby.ui.components.Path;

    // Fields
    var paths;

    function Router() {
        this.paths = [];
    }

    Router.prototype.get = function(path, callback) {
        this.paths.push(new Path(path, callback));
    };

    Router.prototype.handleUrlChange = function(url, successCallback, notFoundCallback) {
        var foundRoute = false;
        for (var i = 0; i < this.paths.length; i++) {
            if (this.paths[i].checkRegex(url)) {
                foundRoute = true;
                var matches = this.paths[i].getMatches(url);
                this.paths[i].getCallback()(function (response) {
                    if (typeof successCallback === "function") {
                        successCallback(response);
                    }
                }, matches);
                break;
            }
        }
        if (!foundRoute && typeof notFoundCallback === "function") {
            notFoundCallback();
        }
    };

    return Router;

})();