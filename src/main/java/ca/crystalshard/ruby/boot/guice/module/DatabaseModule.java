package ca.crystalshard.ruby.boot.guice.module;

import ca.crystalshard.ruby.boot.guice.DataSourceProvider;
import ca.crystalshard.ruby.boot.guice.MigrationProvider;
import ca.crystalshard.ruby.boot.guice.StorageProvider;
import ca.crystalshard.ruby.common.adapter.persistance.Migration;
import ca.crystalshard.ruby.common.adapter.persistance.Storage;
import ca.crystalshard.ruby.common.adapter.persistance.repositories.MsSqlJobRepository;
import ca.crystalshard.ruby.common.domain.persistance.repositories.JobRepository;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

import javax.sql.DataSource;

public class DatabaseModule extends AbstractModule {


    @Override
    protected void configure() {
        bind(DataSource.class).toProvider(DataSourceProvider.class).in(Singleton.class);
        bind(Migration.class).toProvider(MigrationProvider.class).in(Singleton.class);
        bind(Storage.class).toProvider(StorageProvider.class).in(Singleton.class);

        bind(JobRepository.class).to(MsSqlJobRepository.class).in(Singleton.class);
    }
}
