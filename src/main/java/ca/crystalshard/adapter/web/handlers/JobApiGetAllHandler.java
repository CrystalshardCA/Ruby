package ca.crystalshard.adapter.web.handlers;

import ca.crystalshard.adapter.web.viewmodels.ViewEnvelope;
import ca.crystalshard.adapter.web.viewmodels.mappers.JobViewMapper;
import ca.crystalshard.domain.Job;
import ca.crystalshard.domain.persistance.repositories.JobRepository;
import com.google.inject.Inject;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.List;
import java.util.stream.Collectors;

public class JobApiGetAllHandler implements Route {

    private JobRepository jobRepository;
    private JobViewMapper jobViewMapper;

    @Inject
    public JobApiGetAllHandler(JobRepository jobRepository, JobViewMapper jobViewMapper) {
        this.jobRepository = jobRepository;
        this.jobViewMapper = jobViewMapper;
    }


    @Override
    public Object handle(Request request, Response response) throws Exception {

        List<Job> jobs = jobRepository.getAllJobs();

        return ViewEnvelope.of(jobs.stream().map(jobViewMapper::toView).collect(Collectors.toList()));
    }
}
