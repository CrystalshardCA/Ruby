package ca.crystalshard.ruby.common.adapter.persistance.flyway;

import ca.crystalshard.ruby.common.adapter.persistance.Migration;
import com.google.inject.Inject;
import org.flywaydb.core.Flyway;

import javax.sql.DataSource;

public class FlywayMigration implements Migration {

    private Flyway flyway;

    @Inject
    public FlywayMigration(DataSource dataSource, String migrationLocations) {
        this.flyway = new Flyway();
        this.flyway.setDataSource(dataSource);
        this.flyway.setLocations(migrationLocations);
    }

    public FlywayMigration(DataSource dataSource) {
        this.flyway = new Flyway();
        this.flyway.setDataSource(dataSource);
    }

    @Override
    public int migrate() {
        return flyway.migrate();
    }
}
