package ca.crystalshard.boot.guice;

import ca.crystalshard.adapter.configuration.StaticConfiguration;
import ca.crystalshard.domain.configuration.RubyWebConfiguration;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class ConfigurationProvider implements Provider<RubyWebConfiguration> {

    @Inject
    public ConfigurationProvider() {

    }

    @Override
    public RubyWebConfiguration get() {
        return new StaticConfiguration();
    }
}

