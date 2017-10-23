package ca.crystalshard.domain.exceptions;

public class UnableToDetermineOperatingSystemException extends RuntimeException {
    public UnableToDetermineOperatingSystemException(String message) {
        super(message);
    }
}
