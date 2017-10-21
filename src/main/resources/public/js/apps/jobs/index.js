$(document).ready(function () {
    var $ = jQuery
        JobController = crystalshard.ruby.ui.components.JobController;

    var $form = $("#jobIndex");
    var jobController = new JobController($form);
    jobController.init();
});