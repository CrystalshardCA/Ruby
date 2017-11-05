package ca.crystalshard.ruby.common.adapter.persistance.sql2o;

import ca.crystalshard.ruby.common.adapter.persistance.StorageConnection;
import ca.crystalshard.ruby.common.adapter.persistance.StorageQuery;
import org.sql2o.Connection;

public class Sql2oStorageConnection implements StorageConnection {
    private Connection connection;

    Sql2oStorageConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public StorageQuery createQuery(String queryText) {
        return new Sql2oStorageQuery(connection, connection.createQuery(queryText));
    }

    @Override
    public StorageQuery createQuery(String queryText, boolean returnGeneratedKeys) {
        return new Sql2oStorageQuery(connection, connection.createQuery(queryText, returnGeneratedKeys));
    }

    @Override
    public void close() {
        connection.close();
    }

    @Override
    public void commit() {
        connection.commit();
    }
}
