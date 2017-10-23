package ca.crystalshard.ruby.web.adapter.handlers;

import ca.crystalshard.ruby.common.domain.Job;
import ca.crystalshard.ruby.common.domain.identifier.JobId;
import ca.crystalshard.ruby.common.domain.persistance.repositories.JobRepository;
import ca.crystalshard.ruby.web.adapter.views.ViewEnvelope;
import ca.crystalshard.ruby.web.adapter.views.mappers.JobViewMapper;
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

