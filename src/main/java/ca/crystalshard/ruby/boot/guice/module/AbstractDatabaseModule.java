package ca.crystalshard.ruby.boot.guice.module;

import ca.crystalshard.ruby.boot.guice.DataSourceProvider;
import ca.crystalshard.ruby.boot.guice.MigrationProvider;
import ca.crystalshard.ruby.boot.guice.StorageProvider;
import ca.crystalshard.ruby.common.adapter.persistance.Migration;
import ca.crystalshard.ruby.common.adapter.persistance.Storage;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

import javax.sql.DataSource;

public abstract class AbstractDatabaseModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(DataSource.class).toProvider(DataSourceProvider.class).in(Singleton.class);
        bind(Migration.class).toProvider(MigrationProvider.class).in(Singleton.class);
        bind(Storage.class).toProvider(StorageProvider.class).in(Singleton.class);
    }
}
