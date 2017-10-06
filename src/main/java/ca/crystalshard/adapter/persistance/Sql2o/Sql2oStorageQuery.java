package ca.crystalshard.adapter.persistance.Sql2o;

import ca.crystalshard.adapter.persistance.StorageConnection;
import ca.crystalshard.adapter.persistance.StorageQuery;
import org.sql2o.Connection;
import org.sql2o.Query;

public class Sql2oStorageQuery implements StorageQuery {

    private Connection connection;
    private Query query;

    Sql2oStorageQuery(Connection connection, Query query) {
        this.connection = connection;
        this.query = query;
    }


    @Override
    public StorageQuery addParameter(String name, Object value) {
        query.addParameter(name, value);
        return this;
    }

    @Override
    public StorageConnection executeUpdate() {
        return new Sql2oStorageConnection(connection);
    }
}
