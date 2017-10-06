package ca.crystalshard.adapter.persistance;

public interface StorageConnection {
    StorageQuery createQuery(String queryText);
}
