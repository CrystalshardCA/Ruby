package ca.crystalshard.adapter.web.handlers;

import ca.crystalshard.adapter.web.viewmodels.ViewEnvelope;
import ca.crystalshard.domain.identifier.JobId;
import ca.crystalshard.domain.persistance.repositories.JobRepository;
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
