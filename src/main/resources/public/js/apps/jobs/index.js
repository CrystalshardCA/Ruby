$(document).ready(function () {
    var $ = jQuery,
        BrowserContext = crystalshard.ruby.ui.components.BrowserContext,
        RequestHandler = crystalshard.ruby.ui.components.RequestHandler,
        JobController = crystalshard.ruby.ui.components.JobController;

    var $form = $("#jobIndex");
    var browserContext = new BrowserContext($(window), $form);
    var requestHandler = new RequestHandler(browserContext, function(html) {
        if (html === null && html.length === 0) {
            $form.empty();
        }
        else {
            $form.html(html);
        }
    });
    var router = requestHandler.getRouter();
    var jobController = new JobController(router, browserContext);

    requestHandler.init();
});