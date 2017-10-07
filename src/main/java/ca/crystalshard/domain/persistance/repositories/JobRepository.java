package ca.crystalshard.domain.persistance.repositories;

import ca.crystalshard.domain.Job;
import ca.crystalshard.domain.identifier.JobId;

import java.util.Optional;

public interface JobRepository {
    Optional<Job> getJob(JobId jobId);
    JobId saveJob(Job job);

    void updateJob(JobId id, Job job);

    void deleteJob(JobId jobId);
}
