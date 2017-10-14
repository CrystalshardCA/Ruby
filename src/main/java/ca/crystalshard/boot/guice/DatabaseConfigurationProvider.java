package ca.crystalshard.boot.guice;

import ca.crystalshard.adapter.configuration.PropertyFile;
import ca.crystalshard.adapter.configuration.PropertyFileConfiguration;
import ca.crystalshard.domain.configuration.RubyDataConfiguration;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class DatabaseConfigurationProvider implements Provider<RubyDataConfiguration> {

    private PropertyFile propertyFile;

    @Inject
    public DatabaseConfigurationProvider(PropertyFile propertyFile) {

        this.propertyFile = propertyFile;
    }

    @Override
    public RubyDataConfiguration get() {
        return new PropertyFileConfiguration(propertyFile);
    }

}
