package ca.crystalshard.ruby.processor.adapter.io;

public class ProcessAlreadyRunningException extends RuntimeException {
    public ProcessAlreadyRunningException(String message) {
        super(message);
    }
}
