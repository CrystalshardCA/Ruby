package ca.crystalshard.adapter.web.handlers;

import ca.crystalshard.adapter.web.viewmodels.ViewEnvelope;
import ca.crystalshard.adapter.web.viewmodels.mappers.JobViewMapper;
import ca.crystalshard.domain.Job;
import ca.crystalshard.domain.identifier.JobId;
import ca.crystalshard.domain.persistance.repositories.JobRepository;
import com.google.inject.Inject;
import org.apache.velocity.exception.ResourceNotFoundException;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Optional;

public class JobApiGetHandler implements Route {

    private JobRepository jobRepository;
    private JobViewMapper jobViewMapper;

    @Inject
    public JobApiGetHandler(JobRepository jobRepository, JobViewMapper jobViewMapper) {
        this.jobRepository = jobRepository;
        this.jobViewMapper = jobViewMapper;
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        JobId id = JobId.of(request.params("jobId"));
        Optional<Job> job = jobRepository.getJob(id);
        if (job.isPresent()) {
            return ViewEnvelope.of(jobViewMapper.toView(job.get()));
        }

        throw new ResourceNotFoundException(String.format("Job with id: %s was not found.", id));
    }
}

