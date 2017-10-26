package ca.crystalshard.ruby.common.adapter.persistance.repositories;

import ca.crystalshard.ruby.common.adapter.persistance.SqlTableNames;
import ca.crystalshard.ruby.common.adapter.persistance.Storage;
import com.google.inject.Inject;

public class MySqlBuildStepRepository extends BuildStepRepositoryBase {

    @Inject
    public MySqlBuildStepRepository(Storage storage) {
        super(storage);

        this.retrieveQuery = String.format("" +
            " SELECT " +
            " id, name, jobId, buildTypeId, orderValue, isDisabled, createdDateUtc, updatedDateUtc, deletedDateUtc" +
            " FROM `%s` " +
            " WHERE id = :id ",
            SqlTableNames.BUILD_STEP);

        this.deleteQuery = String.format("" +
            " UPDATE `%s` " +
            " SET deletedDateUtc = UTC_TIMESTAMP() " +
            " WHERE id = :id ",
            SqlTableNames.BUILD_STEP);

        this.insertQuery = String.format("" +
            " INSERT INTO `%s` " +
            " (name, jobId, buildTypeId, orderValue, isDisabled, createdDateUtc, updatedDateUtc, deletedDateUtc) " +
            " VALUES " +
            " (:name, :jobId, :buildTypeId, , :isDisabled, UTC_TIMESTAMP(), UTC_TIMESTAMP()) ",
            SqlTableNames.BUILD_STEP);

        this.updateQuery = String.format("" +
            " UPDATE `%s` " +
            " SET name = :name, jobId = :jobId, buildTypeId = :buildTypeId, orderValue = :orderValue, " +
            " isDisabled = :isDisabled, updatedDateUtc = UTC_TIMESTAMP() ",
            SqlTableNames.BUILD_STEP);
    }
}
