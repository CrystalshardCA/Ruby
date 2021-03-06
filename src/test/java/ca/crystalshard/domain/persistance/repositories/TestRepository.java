package ca.crystalshard.domain.persistance.repositories;

import ca.crystalshard.adapter.persistance.SqlTableNames;
import ca.crystalshard.adapter.persistance.Storage;
import ca.crystalshard.adapter.persistance.StorageConnection;
import com.google.inject.Inject;

public class TestRepository {

    private Storage storage;

    private String cleanupJobsQuery;

    @Inject
    public TestRepository(Storage storage) {
        this.storage = storage;

        this.cleanupJobsQuery = String.format("" +
            "TRUNCATE TABLE %s",
            SqlTableNames.JOB);
    }

    void cleanupDatabases() {
        try (StorageConnection con = storage.beginTransaction()) {
            con.createQuery(cleanupJobsQuery, false)
                    .executeUpdate();

            con.commit();
        }
        catch (Exception e) {
            throw new RuntimeException("There was a problem during cleanup.", e);
        }
    }

}
