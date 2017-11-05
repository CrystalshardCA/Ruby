package ca.crystalshard.ruby.common.domain.persistance.repositories;

import ca.crystalshard.ruby.common.adapter.persistance.SqlTableNames;
import ca.crystalshard.ruby.common.adapter.persistance.Storage;
import ca.crystalshard.ruby.common.adapter.persistance.StorageConnection;
import com.google.inject.Inject;

public class TestRepository {

    private Storage storage;

    private String cleanupJobsQuery;

    @Inject
    public TestRepository(Storage storage) {
        this.storage = storage;

    }

    void cleanupDatabases() {
        try (StorageConnection con = storage.beginTransaction()) {
            con.createQuery("SET FOREIGN_KEY_CHECKS = 0", false)
                    .executeUpdate();
            con.createQuery(String.format("TRUNCATE TABLE %s", SqlTableNames.BUILD_STEP), false)
                    .executeUpdate();
            con.createQuery(String.format("TRUNCATE TABLE %s", SqlTableNames.JOB), false)
                    .executeUpdate();
            con.createQuery("SET FOREIGN_KEY_CHECKS = 1", false)
                    .executeUpdate();

            con.commit();
        }
        catch (Exception e) {
            throw new RuntimeException("There was a problem during cleanup.", e);
        }
    }

}
