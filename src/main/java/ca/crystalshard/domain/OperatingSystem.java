package ca.crystalshard.domain;

import ca.crystalshard.domain.exceptions.UnableToDetermineOperatingSystemException;

public enum OperatingSystem {
    Windows("windows"),
    Linux("linux"),
    MacOsX("mac os x");

    private String key;

    public static OperatingSystem from(String key) {
        if (key != null && !key.isEmpty()) {
            String normalizedKey = key.toLowerCase();
            OperatingSystem[] values = OperatingSystem.values();
            for (OperatingSystem value : values) {
                if (value.key.equals(normalizedKey)) {
                    return value;
                }
            }
        }
        String message = String.format("Unable to determine the operating system of : %s", key);
        throw new UnableToDetermineOperatingSystemException(message);
    }

    OperatingSystem(String key) {

        this.key = key;
    }
}
