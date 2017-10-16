$(document).ready(function () {
    var $ = jQuery
        JobIndexForm = crystalshard.ruby.ui.components.JobIndexForm;

    var $form = $("#jobIndex");
    var jobIndexForm = new JobIndexForm($form);
    jobIndexForm.init();
});