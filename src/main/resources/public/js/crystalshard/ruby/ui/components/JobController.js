namespace('crystalshard.ruby.ui.components');

crystalshard.ruby.ui.components.JobController = (function() {

    var $ = jQuery,
        Hb = Handlebars;

    var indexTemplate,
        editTemplate,
        parent;

    function JobController(baseController) {
        this.parent = baseController;
        this.indexTemplate = Hb.compile($("#job-template").html());
        this.editTemplate = Hb.compile($("#edit-job-template").html());
        this.setupRoutes();
        this.wireupEventHandlers();
    }
    
    JobController.prototype.setupRoutes = function() {
        var self = this;
        this.parent.getRouter().get("job\\/([0-9]+)", function (matches) {
            self.initEditPage(matches[1]);
        });
        
        this.parent.getRouter().get("job", function () {
            self.initNewPage();
        });
        
        this.parent.getRouter().get("", function () {
            self.initIndexPage();            
        });
    };
    
    JobController.prototype.wireupEventHandlers = function() {
        var self = this;
        
        self.parent.$page.on('click', 'button.row-edit', function(event) {
            event.preventDefault();
            var id = $(this).parent().parent().data("id");
            self.parent.changePage("job/" + id);
        });

        self.parent.$page.on('click', 'button.row-delete', function(event) {
            event.preventDefault();
            confirm("Clicking yes will delete this job. Press yes if you would like to proceed.");
            var id = $(this).parent().parent().data("id");
            self.deleteJob(id);
        });

        self.parent.$page.on('click', 'button.home,a.home', function(event) {
            event.preventDefault();
            self.parent.changePage("");
        });

        self.parent.$page.on('click', 'button.new', function(event) {
            event.preventDefault();
            var name = self.parent.$page.find("#inputName").val();
            self.newJob(name);
        });

        self.parent.$page.on('click', 'button.update', function(event) {
            event.preventDefault();
            var id = self.parent.$page.find("#updateId").html();
            var name = self.parent.$page.find("#inputName").val();
            self.editJob(id, name);
        });

        self.parent.$page.on("click", "button.create,a.create", function(event) {
            event.preventDefault();
            self.parent.changePage("job");
        });

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
            self.parent.changePage("");
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
            self.parent.refresh();
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
                self.parent.changePage("");
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
            self.parent.render(self.indexTemplate(data));
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
            self.parent.render(self.editTemplate(data.results));
        });
    };

    JobController.prototype.initNewPage = function() {
    var self = this;
        self.parent.render(self.editTemplate({id:"", name:"", createdDateUtc:"", updatedDateUtc:""}));
    };

    return JobController;

})();