package ca.crystalshard.adapter.web.handlers;

import ca.crystalshard.adapter.web.viewModels.JobPostView;
import ca.crystalshard.adapter.web.viewModels.ViewEnvelope;
import ca.crystalshard.adapter.web.viewModels.mappers.JobViewMapper;
import ca.crystalshard.domain.Job;
import ca.crystalshard.domain.identifier.JobId;
import ca.crystalshard.domain.persistance.repositories.JobRepository;
import com.google.gson.Gson;
import com.google.inject.Inject;
import org.apache.velocity.exception.ResourceNotFoundException;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Optional;

public class JobApiPutHandler implements Route {
    private JobRepository jobRepository;
    private JobViewMapper jobViewMapper;

    @Inject
    public JobApiPutHandler(JobRepository jobRepository, JobViewMapper jobViewMapper) {
        this.jobRepository = jobRepository;
        this.jobViewMapper = jobViewMapper;
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {

        JobId id = JobId.of(request.params("jobId"));

        Optional<Job> updateJobOptional = jobRepository.getJob(id);
        if (updateJobOptional.isPresent()) {
            Job updateJob = updateJobOptional.get();

            JobPostView jobPostView = new Gson().fromJson(request.body(), JobPostView.class);

            if (!updateJob.getName().equals(jobPostView.name)) {
                updateJob.setName(jobPostView.name);

                jobRepository.updateJob(id, updateJob);
            }

            return ViewEnvelope.of(jobViewMapper.toView(updateJob));
        }
        throw new ResourceNotFoundException(String.format("Unable to find job with id %s", id));
    }
}
