package ca.crystalshard.adapter.persistance.repositories;

class UnableToSaveException extends RuntimeException {
    UnableToSaveException(String exceptionMessage, Exception e) {
        super(exceptionMessage, e);
    }
}
