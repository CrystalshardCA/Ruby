package ca.crystalshard.ruby.web.adapter.controllers;

import ca.crystalshard.ruby.web.adapter.handlers.JobApiDeleteHandler;
import ca.crystalshard.ruby.web.adapter.handlers.JobApiGetAllHandler;
import ca.crystalshard.ruby.web.adapter.handlers.JobApiGetHandler;
import ca.crystalshard.ruby.web.adapter.handlers.JobApiPostHandler;
import ca.crystalshard.ruby.web.adapter.handlers.JobApiPutHandler;
import com.google.inject.Inject;
import spark.ResponseTransformer;

public class JobApiController extends RubyApiController {

    private JobApiGetHandler getHandler;
    private JobApiPostHandler postHandler;
    private JobApiPutHandler putHandler;
    private JobApiDeleteHandler deleteHandler;
    private JobApiGetAllHandler getAllHandler;

    @Inject
    public JobApiController(ResponseTransformer transformer,
                            JobApiGetHandler getHandler,
                            JobApiPostHandler postHandler,
                            JobApiPutHandler putHandler,
                            JobApiDeleteHandler deleteHandler,
                            JobApiGetAllHandler getAllHandler) {

        super(transformer);
        this.getHandler = getHandler;
        this.postHandler = postHandler;
        this.putHandler = putHandler;
        this.deleteHandler = deleteHandler;
        this.getAllHandler = getAllHandler;
    }

    @Override
    public void register() {
        path("/api/v1/job", () -> {
            get("/:jobId", getHandler);
            get("", getAllHandler);
            post("", postHandler);
            put("/:jobId", putHandler);
            delete("/:jobId", deleteHandler);
        });
    }
}

