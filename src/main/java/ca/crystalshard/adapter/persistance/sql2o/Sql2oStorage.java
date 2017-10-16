package ca.crystalshard.adapter.persistance.sql2o;

import ca.crystalshard.adapter.persistance.Storage;
import ca.crystalshard.adapter.persistance.StorageConnection;
import org.sql2o.Sql2o;

import javax.sql.DataSource;

public class Sql2oStorage implements Storage {

    private Sql2o sql2o;

    public Sql2oStorage(DataSource dataSource) {
        this.sql2o = new Sql2o(dataSource);
    }

    @Override
    public StorageConnection beginTransaction() {
        return new Sql2oStorageConnection(sql2o.beginTransaction());
    }

    @Override
    public StorageConnection open() {
        return new Sql2oStorageConnection(sql2o.open());
    }
}
