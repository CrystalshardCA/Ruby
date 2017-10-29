namespace('crystalshard.ruby.ui.components');

crystalshard.ruby.ui.components.BrowserContext = (function () {

    function BrowserContext($window, $page) {
        this.$window = $window;
        this.$page = $page;
    }

    BrowserContext.prototype.refresh = function() {
        this.$window.trigger("hashchange");
    };

    BrowserContext.prototype.changePage = function(location) {
        window.location.hash = location;
    };

    BrowserContext.prototype.onHashChange = function(callback) {
        var self = this;
        this.$window.on("hashchange", function () {
            var currentPage = self._getCurrentPage();
            callback(currentPage);
        });
    };

    BrowserContext.prototype.onPage = function(eventType, selector, callback) {
        var self = this;
        this.$page.on(eventType, selector, function (event) {
            callback.call(this, event);
        });
    };

    BrowserContext.prototype.findPage = function(selector) {
        return this.$page.find(selector);
    };

    BrowserContext.prototype._getCurrentPage = function() {
        var url = window.location.href;
        var index = url.indexOf('#');
        return index === -1 ? "" : url.substring(index);
    };

    return BrowserContext;

})();
