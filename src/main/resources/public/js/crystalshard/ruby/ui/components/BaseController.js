namespace('crystalshard.ruby.ui.components');

crystalshard.ruby.ui.components.BaseController = (function () {

    // imports
    var $ = jQuery,
        Router = crystalshard.ruby.ui.components.Router;

    // fields
    var $page,
        router;

    function BaseController($page) {
        this.$page = $page;
        this.router = new Router()
    }

    BaseController.prototype.init = function() {
        this.wireupEventHandlers();
        $(window).trigger("hashchange");
    };

    BaseController.prototype.wireupEventHandlers = function() {
        var self = this;

        $(window).on("hashchange", function(e) {
            self.clearPage();
            var currentPage = self.getCurrentPage();

            if (!self.router.handleUrlChange(currentPage)) {
                window.alert("404");
            }
        });
    };

    BaseController.prototype.getCurrentPage = function() {
        var url = window.location.href;
        var index = url.indexOf('#');
        return index === -1 ? "" : url.substring(index);
    };

    BaseController.prototype.clearPage = function() {
        this.$page.empty();
    };

    BaseController.prototype.changePage = function(location) {
        window.location.hash = location;
    };

    BaseController.prototype.refresh = function () {
        $(window).trigger("hashchange");
    };

    BaseController.prototype.render = function(html) {
        this.$page.html(html);
    };

    BaseController.prototype.getRouter = function() {
        return this.router;
    };

    return BaseController;

})();