package ca.crystalshard.ruby.common.adapter.persistance.repositories;

class UnableToSaveException extends RuntimeException {
    UnableToSaveException(String exceptionMessage, Exception e) {
        super(exceptionMessage, e);
    }
}
