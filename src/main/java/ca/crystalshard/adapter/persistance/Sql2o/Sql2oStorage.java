package ca.crystalshard.adapter.persistance.Sql2o;

import ca.crystalshard.adapter.persistance.Storage;
import ca.crystalshard.adapter.persistance.StorageConnection;
import org.sql2o.Sql2o;

public class Sql2oStorage implements Storage {

    private Sql2o sql2o;

    public Sql2oStorage(Sql2o sql2o) {
        this.sql2o = sql2o;
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
