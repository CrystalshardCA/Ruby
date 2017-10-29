namespace('crystalshard.ruby.ui.components');

crystalshard.ruby.ui.components.JobController = (function() {

    // TODO Remove Jquery call from controller
    var $ = jQuery,
        Hb = Handlebars;

    function JobController(router, browserContext) {
        this.router = router;
        this.browserContext = browserContext;
        this.indexTemplate = Hb.compile($("#job-template").html());
        this.editTemplate = Hb.compile($("#edit-job-template").html());
        this._setupRoutes();
        this._wireupEventHandlers();
    }
    
    JobController.prototype._setupRoutes = function() {
        var self = this;
        this.router.get("job\\/([0-9]+)", function (response, request) {
            var id = request[1];
            $.ajax({
                method: "GET",
                url: "/api/v1/job/" + id,
                dataType: "json"
            })
            .done(function (data) {
                if (typeof response === "function") {
                    response(self.editTemplate(data.results));
                }
            });
        });

        this.router.get("job", function (response) {
            if (typeof response === "function") {
                response(self.editTemplate({id:"", name:"", createdDateUtc:"", updatedDateUtc:""}));
            }
        });

        this.router.get("", function (response) {
            $.ajax({
                method: "GET",
                url: "/api/v1/job",
                dataType: "json"
            })
            .done(function (data) {
                if (typeof response === "function") {
                    response(self.indexTemplate(data));
                }
            });

        });
    };
    
    JobController.prototype._wireupEventHandlers = function() {
        var self = this;
        
        self.browserContext.onPage('click', 'button.row-edit', function(event) {
            event.preventDefault();
            var id = $(this).parent().parent().data("id");
            self.browserContext.changePage("job/" + id);
        });

        self.browserContext.onPage('click', 'button.row-delete', function(event) {
            event.preventDefault();
            confirm("Clicking yes will delete this job. Press yes if you would like to proceed.");
            var id = $(this).parent().parent().data("id");
            self._deleteJob(id);
        });

        self.browserContext.onPage('click', 'button.home,a.home', function(event) {
            event.preventDefault();
            self.browserContext.changePage("");
        });

        self.browserContext.onPage('click', 'button.new', function(event) {
            event.preventDefault();
            var name = self.browserContext.findPage("#inputName").val();
            self._newJob(name);
        });

        self.browserContext.onPage('click', 'button.update', function(event) {
            event.preventDefault();
            var id = self.browserContext.findPage("#updateId").html();
            var name = self.browserContext.findPage("#inputName").val();
            self._editJob(id, name);
        });

        self.browserContext.onPage("click", "button.create,a.create", function(event) {
            event.preventDefault();
            self.browserContext.changePage("job");
        });

    };

    JobController.prototype._editJob = function(id, name) {
        var self = this;
        $.ajax({
            method: "PUT",
            url: "/api/v1/job/" + id,
            dataType: "json",
            data: JSON.stringify({name: name}),
            contentType:"application/json; charset=utf-8"
        })
        .done(function (data) {
            self.browserContext.changePage("");
        });
    };

    JobController.prototype._deleteJob = function(id) {
        var self = this;
        $.ajax({
            method: "DELETE",
            url: "/api/v1/job/" + id,
            dataType: "json",
            contentType:"application/json; charset=utf-8"
        })
        .done(function (data) {
            self.browserContext.refresh();
        });
    };

    JobController.prototype._newJob = function(name) {
            var self = this;
            $.ajax({
                method: "POST",
                url: "/api/v1/job",
                dataType: "json",
                data: JSON.stringify({name: name}),
                contentType:"application/json; charset=utf-8"
            })
            .done(function (data) {
                self.browserContext.changePage("");
            });
        };
    
    return JobController;

})();