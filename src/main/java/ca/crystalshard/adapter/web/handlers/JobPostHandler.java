package ca.crystalshard.adapter.web.handlers;

import ca.crystalshard.adapter.web.viewModels.JobPostView;
import ca.crystalshard.adapter.web.viewModels.mappers.JobPostViewMapper;
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

public class JobPostHandler implements Route {

    private JobRepository jobRepository;
    private JobPostViewMapper jobPostViewMapper;
    private JobViewMapper jobViewMapper;

    @Inject
    public JobPostHandler(JobRepository jobRepository, JobPostViewMapper jobPostViewMapper, JobViewMapper jobViewMapper) {
        this.jobRepository = jobRepository;
        this.jobPostViewMapper = jobPostViewMapper;
        this.jobViewMapper = jobViewMapper;
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {

        String body = request.body();
        JobPostView view = new Gson().fromJson(body, JobPostView.class);

        Job newJob = jobPostViewMapper.toDomain(view);

        JobId jobId = jobRepository.saveJob(newJob);
        Optional<Job> insertedJob = jobRepository.getJob(jobId);
        if (insertedJob.isPresent()) {
            return jobViewMapper.toView(insertedJob.get());
        }
        throw new ResourceNotFoundException(String.format("Inserted job was not found at id: %s", jobId.getId()));
    }
}
