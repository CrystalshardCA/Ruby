package ca.crystalshard.adapter.persistance;

public interface StorageQuery {
    StorageQuery addParameter(String name, Object value);
    StorageConnection executeUpdate();
}
