package ca.crystalshard.ruby.web.adapter.handlers;

import ca.crystalshard.ruby.common.domain.Job;
import ca.crystalshard.ruby.common.domain.persistance.repositories.JobRepository;
import ca.crystalshard.ruby.web.adapter.views.ViewEnvelope;
import ca.crystalshard.ruby.web.adapter.views.mappers.JobViewMapper;
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
