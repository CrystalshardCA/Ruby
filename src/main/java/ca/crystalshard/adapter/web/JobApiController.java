package ca.crystalshard.adapter.web;

import ca.crystalshard.adapter.web.handlers.JobApiDeleteHandler;
import ca.crystalshard.adapter.web.handlers.JobApiGetAllHandler;
import ca.crystalshard.adapter.web.handlers.JobApiGetHandler;
import ca.crystalshard.adapter.web.handlers.JobApiPostHandler;
import ca.crystalshard.adapter.web.handlers.JobApiPutHandler;
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

