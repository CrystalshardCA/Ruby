package ca.crystalshard.adapter.persistance;

public interface StorageConnection extends AutoCloseable {
    StorageQuery createQuery(String queryText);

    StorageQuery createQuery(String queryText, boolean returnGeneratedKeys);

    @Override
    void close();

    void commit();
}
