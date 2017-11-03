package ca.crystalshard.ruby.common.domain.persistance.repositories;

import ca.crystalshard.ruby.common.domain.Job;
import ca.crystalshard.ruby.common.domain.identifier.JobId;

import java.util.List;
import java.util.Optional;

public interface JobRepository {

    Optional<Job> getJob(JobId jobId);

    JobId saveJob(Job job);

    void updateJob(JobId id, Job job);

    void deleteJob(JobId jobId);

    List<Job> getAllJobs();
}
