package ca.crystalshard.adapter.persistance.repositories;

import ca.crystalshard.adapter.persistance.SqlTableNames;
import ca.crystalshard.adapter.persistance.Storage;
import com.google.inject.Inject;


public class MySqlJobRepository extends JobRepositoryBase {

    @Inject
    public MySqlJobRepository(Storage storage) {
        super(storage);

        this.saveQuery = String.format("" +
                        " INSERT INTO %s " +
                        " (name, createdDateUtc, updatedDateUtc) " +
                        " VALUES (:name, UTC_TIMESTAMP(), UTC_TIMESTAMP()) ",
                SqlTableNames.JOB
        );
        this.updateQuery = String.format("" +
                        " UPDATE %s " +
                        " SET name = :name, updatedDateUtc = UTC_TIMESTAMP() " +
                        " WHERE id = :id ",
                SqlTableNames.JOB
        );
        this.retrieveQuery = String.format("" +
                        " SELECT id, name, createdDateUtc, updatedDateUtc, deletedDateUtc " +
                        " FROM %s j " +
                        " WHERE j.id = :id " +
                        " AND j.deletedDateUtc IS NULL",
                SqlTableNames.JOB
        );
        this.deleteQuery = String.format("" +
                        " UPDATE %s " +
                        " SET deletedDateUtc = UTC_TIMESTAMP() " +
                        " WHERE id = :id ",
                SqlTableNames.JOB
        );
    }

}
