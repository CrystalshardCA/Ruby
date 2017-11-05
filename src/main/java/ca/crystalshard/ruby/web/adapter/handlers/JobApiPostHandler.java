package ca.crystalshard.ruby.web.adapter.handlers;

import ca.crystalshard.ruby.common.domain.Job;
import ca.crystalshard.ruby.common.domain.identifier.JobId;
import ca.crystalshard.ruby.common.domain.persistance.repositories.JobRepository;
import ca.crystalshard.ruby.web.adapter.views.JobPostView;
import ca.crystalshard.ruby.web.adapter.views.ViewEnvelope;
import ca.crystalshard.ruby.web.adapter.views.mappers.JobPostViewMapper;
import ca.crystalshard.ruby.web.adapter.views.mappers.JobViewMapper;
import com.google.gson.Gson;
import com.google.inject.Inject;
import org.apache.velocity.exception.ResourceNotFoundException;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Optional;

public class JobApiPostHandler implements Route {

    private JobRepository jobRepository;
    private JobPostViewMapper jobPostViewMapper;
    private JobViewMapper jobViewMapper;

    @Inject
    public JobApiPostHandler(JobRepository jobRepository, JobPostViewMapper jobPostViewMapper, JobViewMapper jobViewMapper) {
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
            return ViewEnvelope.of(jobViewMapper.toView(insertedJob.get()));
        }
        throw new ResourceNotFoundException(String.format("Inserted job was not found at id: %s", jobId.getId()));
    }
}
