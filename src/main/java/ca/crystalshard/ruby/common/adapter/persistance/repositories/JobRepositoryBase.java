package ca.crystalshard.ruby.common.adapter.persistance.repositories;

import ca.crystalshard.ruby.common.adapter.persistance.Storage;
import ca.crystalshard.ruby.common.adapter.persistance.StorageConnection;
import ca.crystalshard.ruby.common.domain.Job;
import ca.crystalshard.ruby.common.domain.identifier.JobId;
import ca.crystalshard.ruby.common.domain.persistance.repositories.JobRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class JobRepositoryBase implements JobRepository {
    protected String retrieveQuery;
    protected String deleteQuery;
    protected String saveQuery;
    protected String updateQuery;

    private Storage storage;

    protected JobRepositoryBase(Storage storage) {
        this.storage = storage;
    }

    public Optional<Job> getJob(JobId jobId) {
        try (StorageConnection con = storage.open()) {

            JobDto jobDto = con.createQuery(String.format("%s%s", retrieveQuery, " AND j.id = :id"))
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
        } catch (Exception e) {
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

    public List<Job> getAllJobs() {
        try (StorageConnection con = storage.open()) {
            return con.createQuery(retrieveQuery)
                    .executeAndFetch(JobDto.class)
                    .stream().map(this::toJob).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve jobs", e);
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