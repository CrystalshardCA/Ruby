package ca.crystalshard.adapter.persistance.repositories;

import ca.crystalshard.adapter.persistance.SqlTableNames;
import ca.crystalshard.adapter.persistance.Storage;
import ca.crystalshard.adapter.persistance.StorageConnection;
import ca.crystalshard.domain.Job;
import ca.crystalshard.domain.identifier.JobId;
import ca.crystalshard.domain.persistance.repositories.JobRepository;
import com.google.inject.Inject;

import java.util.Optional;

public class MsSqlJobRepository extends JobRepositoryBase  {

    @Inject
    public MsSqlJobRepository(Storage storage) {
        super(storage);

        this.retrieveQuery = String.format("" +
            " SELECT id, name, createdDateUtc, updatedDateUtc, deletedDateUtc " +
            " FROM dbo.%s j " +
            " WHERE j.id = :id " +
            " AND j.deletedDateUtc IS NULL",
            SqlTableNames.JOB
        );

        this.deleteQuery = String.format("" +
            " UPDATE dbo.%s " +
            " SET deletedDateUtc = GETUTCDATE() " +
            " WHERE id = :id ",
            SqlTableNames.JOB
        );

        this.saveQuery = String.format("" +
            " INSERT INTO dbo.%s " +
            " (name) " +
            " VALUES (:name) ",
            SqlTableNames.JOB
        );

        this.updateQuery = String.format("" +
            " UPDATE dbo.%s " +
            " SET name = :name, updatedDateUtc = GETUTCDATE() " +
            " WHERE id = :id ",
            SqlTableNames.JOB
        );
    }
}
