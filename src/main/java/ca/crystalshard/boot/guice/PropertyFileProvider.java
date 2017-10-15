package ca.crystalshard.boot.guice;

import ca.crystalshard.adapter.configuration.OverridePropertyFileLocation;
import ca.crystalshard.adapter.configuration.PropertyFileClassLoader;
import ca.crystalshard.adapter.configuration.PropertyFile;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class PropertyFileProvider implements Provider<PropertyFile> {

    private OverridePropertyFileLocation overridePropertyFileLocation;

    @Inject
    public PropertyFileProvider(OverridePropertyFileLocation overridePropertyFileLocation) {
        this.overridePropertyFileLocation = overridePropertyFileLocation;
    }

    @Override
    public PropertyFile get() {

        if (overridePropertyFileLocation.getLocation() != null) {
            return new PropertyFileClassLoader("ruby.properties", overridePropertyFileLocation.getLocation());
        }
        else {
            return new PropertyFileClassLoader("ruby.properties");
        }

    }
}
