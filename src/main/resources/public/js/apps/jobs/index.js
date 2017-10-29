$(document).ready(function () {
    var $ = jQuery,
        BaseController = crystalshard.ruby.ui.components.BaseController,
        JobController = crystalshard.ruby.ui.components.JobController;

    var $form = $("#jobIndex");
    var baseController = new BaseController($form);
    var jobController = new JobController(baseController);

    baseController.init();
});