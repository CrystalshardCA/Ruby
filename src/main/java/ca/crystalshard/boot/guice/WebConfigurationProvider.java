package ca.crystalshard.boot.guice;

import ca.crystalshard.adapter.configuration.PropertyFile;
import ca.crystalshard.adapter.configuration.PropertyFileConfiguration;
import ca.crystalshard.domain.configuration.RubyWebConfiguration;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class WebConfigurationProvider implements Provider<RubyWebConfiguration> {

    private PropertyFile propertyFile;

    @Inject
    public WebConfigurationProvider(PropertyFile propertyFile) {

        this.propertyFile = propertyFile;
    }

    @Override
    public RubyWebConfiguration get() {
        return new PropertyFileConfiguration(propertyFile);
    }

}

