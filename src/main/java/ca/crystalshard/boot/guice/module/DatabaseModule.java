package ca.crystalshard.boot.guice.module;

import ca.crystalshard.adapter.persistance.Migration;
import ca.crystalshard.adapter.persistance.Storage;
import ca.crystalshard.adapter.persistance.repositories.MsSqlJobRepository;
import ca.crystalshard.boot.guice.DataSourceProvider;
import ca.crystalshard.boot.guice.FlywayMigrationProvider;
import ca.crystalshard.boot.guice.Sql2oStorageProvider;
import ca.crystalshard.domain.persistance.repositories.JobRepository;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

import javax.sql.DataSource;

public class DatabaseModule extends AbstractModule {


    @Override
    protected void configure() {
        bind(DataSource.class).toProvider(DataSourceProvider.class).in(Singleton.class);
        bind(Migration.class).toProvider(FlywayMigrationProvider.class).in(Singleton.class);
        bind(Storage.class).toProvider(Sql2oStorageProvider.class).in(Singleton.class);

        bind(JobRepository.class).to(MsSqlJobRepository.class).in(Singleton.class);
    }
}
