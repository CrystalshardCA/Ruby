package ca.crystalshard.boot.guice;

import ca.crystalshard.adapter.persistance.sql2o.Sql2oStorage;
import com.google.inject.Inject;
import com.google.inject.Provider;

import javax.sql.DataSource;

public class Sql2oStorageProvider implements Provider<Sql2oStorage> {
    private DataSource dataSource;

    @Inject
    public Sql2oStorageProvider(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Sql2oStorage get() {
        return new Sql2oStorage(dataSource);
    }
}

