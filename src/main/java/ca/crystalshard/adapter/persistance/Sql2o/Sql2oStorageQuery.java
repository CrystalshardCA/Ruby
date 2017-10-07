package ca.crystalshard.adapter.persistance.Sql2o;

import ca.crystalshard.adapter.persistance.StorageQuery;
import org.sql2o.Connection;
import org.sql2o.Query;

import java.util.List;
import java.util.function.Function;

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
    public int executeUpdate() {

        return executeUpdate(Connection::getResult);
    }

    @Override
    public <T> T executeAndFetchFirst(Class<T> returnType) {
        return query.executeAndFetchFirst(returnType);
    }

    @Override
    public <T> List<T> executeAndFetch(Class<T> returnType) {
        return query.executeAndFetch(returnType);
    }

    @Override
    public <T> T executeUpdateWithKey(Class<T> keyClass) {

        return executeUpdate((connection1) -> connection1.getKey(keyClass));
    }

    private <T> T executeUpdate(Function<Connection, T> returnValueFn) {
        Connection conn = query.executeUpdate();

        return returnValueFn.apply(conn);
    }
}
