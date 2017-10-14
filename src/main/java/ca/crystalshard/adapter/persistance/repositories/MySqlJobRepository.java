package ca.crystalshard.adapter.persistance.repositories;

import ca.crystalshard.adapter.persistance.SqlTableNames;
import ca.crystalshard.adapter.persistance.Storage;
import ca.crystalshard.adapter.persistance.StorageConnection;
import ca.crystalshard.domain.Job;
import ca.crystalshard.domain.identifier.JobId;
import ca.crystalshard.domain.persistance.repositories.JobRepository;
import com.google.inject.Inject;

import java.util.Optional;

public class MySqlJobRepository implements JobRepository {

    private Storage storage;

    private final String retrieveQuery;
    private final String deleteQuery;
    private final String saveQuery;
    private final String updateQuery;

    @Inject
    public MySqlJobRepository(Storage storage) {
        this.storage = storage;

        this.retrieveQuery = String.format("" +
                        " SELECT id, name, createdDateUtc, updatedDateUtc, deletedDateUtc " +
                        " FROM %s j " +
                        " WHERE j.id = :id " +
                        " AND j.deletedDateUtc IS NULL",
                SqlTableNames.JOB
        );

        this.deleteQuery = String.format("" +
                        " UPDATE %s " +
                        " SET deletedDateUtc = UTC_DATE() " +
                        " WHERE id = :id ",
                SqlTableNames.JOB
        );

        this.saveQuery = String.format("" +
                        " INSERT INTO %s " +
                        " (name, createdDateUtc, updatedDateUtc) " +
                        " VALUES (:name, UTC_DATE(), UTC_DATE()) ",
                SqlTableNames.JOB
        );

        this.updateQuery = String.format("" +
                        " UPDATE %s " +
                        " SET name = :name, updatedDateUtc = UTC_DATE() " +
                        " WHERE id = :id ",
                SqlTableNames.JOB
        );
    }

    @Override
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

    @Override
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

    @Override
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

    @Override
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
