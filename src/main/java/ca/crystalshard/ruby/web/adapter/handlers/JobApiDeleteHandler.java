package ca.crystalshard.ruby.web.adapter.handlers;

import ca.crystalshard.ruby.common.domain.identifier.JobId;
import ca.crystalshard.ruby.common.domain.persistance.repositories.JobRepository;
import ca.crystalshard.ruby.web.adapter.views.ViewEnvelope;
import com.google.inject.Inject;
import spark.Request;
import spark.Response;
import spark.Route;

public class JobApiDeleteHandler implements Route {

    private JobRepository jobRepository;

    @Inject
    public JobApiDeleteHandler(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        JobId jobId = JobId.of(request.params("jobId"));

        jobRepository.deleteJob(jobId);

        return ViewEnvelope.of(jobId.getId());
    }
}
