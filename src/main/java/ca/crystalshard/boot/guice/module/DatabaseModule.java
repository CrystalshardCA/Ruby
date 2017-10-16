package ca.crystalshard.boot.guice.module;

import ca.crystalshard.adapter.persistance.Migration;
import ca.crystalshard.adapter.persistance.Storage;
import ca.crystalshard.adapter.persistance.repositories.MySqlJobRepository;
import ca.crystalshard.boot.guice.DataSourceProvider;
import ca.crystalshard.boot.guice.MigrationProvider;
import ca.crystalshard.boot.guice.StorageProvider;
import ca.crystalshard.domain.persistance.repositories.JobRepository;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

import javax.sql.DataSource;

public class DatabaseModule extends AbstractModule {


    @Override
    protected void configure() {
        bind(DataSource.class).toProvider(DataSourceProvider.class).in(Singleton.class);
        bind(Migration.class).toProvider(MigrationProvider.class).in(Singleton.class);
        bind(Storage.class).toProvider(StorageProvider.class).in(Singleton.class);

        bind(JobRepository.class).to(MySqlJobRepository.class).in(Singleton.class);
    }
}
