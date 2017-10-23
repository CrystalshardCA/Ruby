namespace('crystalshard.ruby.ui.components');

crystalshard.ruby.ui.components.JobController = (function() {

    var $ = jQuery,
        Hb = Handlebars;

    var $form,
        indexTemplate,
        editTemplate,
        jobPageRegex;

    function JobController($form) {
        this.$form = $form;
        this.indexTemplate = Hb.compile($("#job-template").html());
        this.editTemplate = Hb.compile($("#edit-job-template").html());
        this.jobPageRegex = RegExp("job\\/([0-9]+)");
        this.newJobPageRegex = RegExp("job");
    }

    JobController.prototype.init = function() {
        this.wireupEventHandlers();

        $(window).trigger("hashchange");

    };

    JobController.prototype.wireupEventHandlers = function() {
        var self = this;

        $(window).on("hashchange", function(e) {
            self.clearPage();
            var currentPage = self.getCurrentPage();

            if (self.jobPageRegex.test(currentPage)) {
                var id = currentPage.match(self.jobPageRegex)[1];
                self.initEditPage(id);
            }
            else if (self.newJobPageRegex.test(currentPage)) {
                self.initNewPage();
            }
            else {
               self.initIndexPage();
            }
        });

        self.$form.on('click', 'button.row-edit', function(event) {
            event.preventDefault();
            var id = $(this).parent().parent().data("id");
            window.location.hash = "job/" + id;
        });

        self.$form.on('click', 'button.row-delete', function(event) {
            event.preventDefault();
            confirm("Clicking yes will delete this job. Press yes if you would like to proceed.");
            var id = $(this).parent().parent().data("id");
            self.deleteJob(id);
        });

        self.$form.on('click', 'button.home,a.home', function(event) {
            event.preventDefault();
            window.location.hash = "";
        });

        self.$form.on('click', 'button.new', function(event) {
            event.preventDefault();
            var name = self.$form.find("#inputName").val();
            self.newJob(name);
        });

        self.$form.on('click', 'button.update', function(event) {
            event.preventDefault();
            var id = self.$form.find("#updateId").html();
            var name = self.$form.find("#inputName").val();
            self.editJob(id, name);
        });

        self.$form.on("click", "button.create,a.create", function(event) {
            event.preventDefault();
            window.location.hash = "job";
        });

    }

    JobController.prototype.clearPage = function() {
        this.$form.empty();
    };

    JobController.prototype.editJob = function(id, name) {
        var self = this;
        $.ajax({
            method: "PUT",
            url: "/api/v1/job/" + id,
            dataType: "json",
            data: JSON.stringify({name: name}),
            contentType:"application/json; charset=utf-8"
        })
        .done(function (data) {
            window.location.hash = "";
        });
    };

    JobController.prototype.deleteJob = function(id) {
        var self = this;
        $.ajax({
            method: "DELETE",
            url: "/api/v1/job/" + id,
            dataType: "json",
            contentType:"application/json; charset=utf-8"
        })
        .done(function (data) {
            $(window).trigger("hashchange");
        });
    };

    JobController.prototype.newJob = function(name) {
            var self = this;
            $.ajax({
                method: "POST",
                url: "/api/v1/job",
                dataType: "json",
                data: JSON.stringify({name: name}),
                contentType:"application/json; charset=utf-8"
            })
            .done(function (data) {
                window.location.hash = "";
            });
        };

    JobController.prototype.initIndexPage = function() {
        var self = this;
        $.ajax({
            method: "GET",
            url: "/api/v1/job",
            dataType: "json"
        })
        .done(function (data) {
            self.$form.html(self.indexTemplate(data));
        });
    };

    JobController.prototype.initEditPage = function(id) {
        var self = this;
        $.ajax({
            method: "GET",
            url: "/api/v1/job/" + id,
            dataType: "json"
        })
        .done(function (data) {
            self.$form.html(self.editTemplate(data.results));
        });
    };

    JobController.prototype.initNewPage = function() {
    var self = this;
        self.$form.html(self.editTemplate({id:"", name:"", createdDateUtc:"", updatedDateUtc:""}));
    };

    JobController.prototype.getCurrentPage = function() {
        var url = window.location.href;
        var index = url.indexOf('#');
        return index == -1 ? "" : url.substring(index);
    };

    return JobController;

})();