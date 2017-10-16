namespace('crystalshard.ruby.ui.components');

crystalshard.ruby.ui.components.JobIndexForm = (function() {

    var $ = jQuery,
        Hb = Handlebars;

    var $form;
    var template;
    var jobPageRegex;

    function JobIndexForm($form) {
        this.$form = $form;
        var source = $("#job-template").html();
        this.template = Hb.compile(source);
        this.jobPageRegex = RegExp("job\\/");
    }

    JobIndexForm.prototype.init = function() {
        this.wireupEventHandlers();
        this.handleHashChange();
    };

    JobIndexForm.prototype.wireupEventHandlers = function() {
        var self = this;

        $(window).on("hashchange", self.handleHashChange);

    }

    JobIndexForm.prototype.handleHashChange = function(e) {

        var currentPage = this.getCurrentPage();

        if (this.jobPageRegex.test(currentPage)) {

        }
        else {
            this.initIndexPage();
        }
    };

    JobIndexForm.prototype.clearPage = function() {
        this.$form.empty();
    };

    JobIndexForm.prototype.initIndexPage = function() {
        var self = this;
            $.ajax({
                method: "GET",
                url: "/api/v1/job",
                dataType: "json"
            })
            .done(function (data) {
                self.renderTable(data);
            });
    };

    JobIndexForm.prototype.renderTable = function(data) {
        this.$form.html(this.template(data));
    };

    JobIndexForm.prototype.getCurrentPage = function() {
        var url = window.location.href;
        return url.substring(url.indexOf('#'));
    };

    return JobIndexForm;

})();