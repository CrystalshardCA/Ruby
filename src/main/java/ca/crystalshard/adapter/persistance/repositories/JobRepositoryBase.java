package ca.crystalshard.adapter.persistance.repositories;

import ca.crystalshard.adapter.persistance.SqlTableNames;
import ca.crystalshard.adapter.persistance.Storage;
import ca.crystalshard.adapter.persistance.StorageConnection;
import ca.crystalshard.domain.Job;
import ca.crystalshard.domain.identifier.JobId;
import ca.crystalshard.domain.persistance.repositories.JobRepository;

import java.util.Optional;

public class JobRepositoryBase implements JobRepository {
    String retrieveQuery;
    String deleteQuery;
    String saveQuery;
    String updateQuery;

    private Storage storage;

    JobRepositoryBase(Storage storage) {
        this.storage = storage;
    }

    public Optional<Job> getJob(JobId jobId) {
        try (StorageConnection con = storage.open()) {
            JobDto jobDto = con.createQuery(retrieveQuery)
                    .addParameter("id", jobId.getId())
                    .executeAndFetchFirst(JobDto.class);

            return jobDto != null
                    ? Optional.of(toJob(jobDto))
                    : Optional.empty();

        }
        catch (Exception e) {
            throw new RuntimeException(String.format("Failed to retrieve job with id: %s", jobId.toString()), e);
        }
    }

    public JobId saveJob(Job job) {
        try (StorageConnection con = storage.open()) {
            Integer jobId = con.createQuery(saveQuery, true)
                    .addParameter("name", job.getName())
                    .executeUpdateWithKey(Integer.class);

            return JobId.of(jobId);
        }
        catch(Exception e) {
            String exceptionMessage = String.format("Unable to save job: %s", job.getName());
            throw new UnableToSaveException(exceptionMessage, e);
        }
    }

    public void updateJob(JobId id, Job job) {
        try (StorageConnection con = storage.open()) {
            con.createQuery(updateQuery, false)
                    .addParameter("name", job.getName())
                    .addParameter("id", id.getId())
                    .executeUpdate();
        }
        catch (Exception e) {
            String exceptionMessage = String.format("Unable to update job id: %s to name: %s", id.getId(), job.getName());
            throw new UnableToSaveException(exceptionMessage, e);
        }
    }

    public void deleteJob(JobId jobId) {
        try (StorageConnection con = storage.open()) {
            con.createQuery(deleteQuery)
                    .addParameter("id", jobId.getId())
                    .executeUpdate();
        }
    }

    private Job toJob(JobDto jobDto) {
        return new Job(JobId.of(jobDto.id), jobDto.name, jobDto.createdDateUtc, jobDto.updatedDateUtc, jobDto.deletedDateUtc);
    }

    private class JobDto {
        String id;
        String name;
        String createdDateUtc;
        String updatedDateUtc;
        String deletedDateUtc;
    }
}
