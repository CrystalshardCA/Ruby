package ca.crystalshard.ruby.common.adapter.persistance.repositories.mssql;

import ca.crystalshard.ruby.common.adapter.persistance.SqlTableNames;
import ca.crystalshard.ruby.common.adapter.persistance.Storage;
import ca.crystalshard.ruby.common.adapter.persistance.repositories.JobRepositoryBase;
import com.google.inject.Inject;


public class MsSqlJobRepository extends JobRepositoryBase {

    @Inject
    public MsSqlJobRepository(Storage storage) {
        super(storage);

        this.retrieveQuery = String.format("" +
                        " SELECT id, name, createdDateUtc, updatedDateUtc, deletedDateUtc " +
                        " FROM dbo.%s j " +
                        " WHERE j.deletedDateUtc IS NULL ",
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