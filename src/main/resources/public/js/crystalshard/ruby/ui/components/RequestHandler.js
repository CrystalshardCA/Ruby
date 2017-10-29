namespace('crystalshard.ruby.ui.components');

crystalshard.ruby.ui.components.RequestHandler = (function() {

    //Imports
    var Router = crystalshard.ruby.ui.components.Router;

    function RequestHandler(browserContext, responseCallback) {
        this.browserContext = browserContext;
        this.responseCallback = responseCallback;
        this.router = new Router();
    }

    RequestHandler.prototype.init = function() {
        this._wireupEventHandlers();
        this.browserContext.refresh();
    };

    RequestHandler.prototype.getRouter = function() {
        return this.router;
    };

    RequestHandler.prototype._wireupEventHandlers = function() {
        var self = this;

        self.browserContext.onHashChange(function(currentPage) {
            self._clearPage();

            if (!self.router.handleUrlChange(currentPage
                    , function(response) {
                        self._responseCallback(response);
                    }, function () {
                        window.alert("404");
                    })) {

            }
        });
    };

    RequestHandler.prototype._clearPage = function() {
        this._responseCallback("");
    };

    RequestHandler.prototype._responseCallback = function(html) {
        if (typeof this.responseCallback === "function") {
            this.responseCallback(html);
        }
    };

    return RequestHandler;

})();
