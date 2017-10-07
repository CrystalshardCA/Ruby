package ca.crystalshard.adapter.persistance;

import java.util.List;

public interface StorageQuery {
    StorageQuery addParameter(String name, Object value);
    int executeUpdate();

    <T> T executeAndFetchFirst(Class<T> returnType);
    <T> List<T> executeAndFetch(Class<T> returnType);
    <T> T executeUpdateWithKey(Class<T> keyClass);
}
