package ca.crystalshard.ruby.common.adapter.persistance;

public interface Storage {
    StorageConnection beginTransaction();

    StorageConnection open();
}
