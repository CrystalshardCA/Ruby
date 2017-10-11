package ca.crystalshard.boot.guice;

import ca.crystalshard.adapter.persistance.flyway.FlywayMigration;
import ca.crystalshard.domain.configuration.RubyDataConfiguration;
import com.google.inject.Inject;
import com.google.inject.Provider;

import javax.sql.DataSource;

public class FlywayMigrationProvider implements Provider<FlywayMigration> {

    private DataSource dataSource;
    private RubyDataConfiguration dataConfiguration;

    @Inject
    public FlywayMigrationProvider(DataSource dataSource, RubyDataConfiguration dataConfiguration) {
        this.dataSource = dataSource;
        this.dataConfiguration = dataConfiguration;
    }

    @Override
    public FlywayMigration get() {
        return new FlywayMigration(dataSource, dataConfiguration.getMigrationLocation());
    }
}
