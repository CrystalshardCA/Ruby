package ca.crystalshard.ruby.boot.guice;

import ca.crystalshard.ruby.common.adapter.configuration.PropertyFile;
import ca.crystalshard.ruby.common.adapter.configuration.PropertyFileConfiguration;
import ca.crystalshard.ruby.common.domain.configuration.RubyDataConfiguration;
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
