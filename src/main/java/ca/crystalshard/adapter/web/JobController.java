package ca.crystalshard.adapter.web;

import ca.crystalshard.adapter.web.handlers.JobDeleteHandler;
import ca.crystalshard.adapter.web.handlers.JobGetHandler;
import ca.crystalshard.adapter.web.handlers.JobPostHandler;
import ca.crystalshard.adapter.web.handlers.JobPutHandler;
import com.google.inject.Inject;
import spark.ResponseTransformer;

public class JobController extends RubyApiController {

    private JobGetHandler getHandler;
    private JobPostHandler postHandler;
    private JobPutHandler putHandler;
    private JobDeleteHandler deleteHandler;

    @Inject
    public JobController(ResponseTransformer transformer,
                         JobGetHandler getHandler,
                         JobPostHandler postHandler,
                         JobPutHandler putHandler,
                         JobDeleteHandler deleteHandler) {

        super(transformer);
        this.getHandler = getHandler;
        this.postHandler = postHandler;
        this.putHandler = putHandler;
        this.deleteHandler = deleteHandler;
    }

    @Override
    public void register() {
        path("/api/v1/job", () -> {
            get("/:jobId", getHandler);
            post("", postHandler);
            put("/:jobId", putHandler);
            delete("/:jobId", deleteHandler);
        });
    }
}

