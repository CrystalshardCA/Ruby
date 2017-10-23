package ca.crystalshard.adapter.persistance;

public interface Storage {
    StorageConnection beginTransaction();

    StorageConnection open();
}
