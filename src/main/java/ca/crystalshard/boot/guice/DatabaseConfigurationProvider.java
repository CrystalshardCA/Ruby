package ca.crystalshard.boot.guice;

import ca.crystalshard.adapter.configuration.StaticConfiguration;
import ca.crystalshard.domain.configuration.RubyDataConfiguration;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class DatabaseConfigurationProvider implements Provider<RubyDataConfiguration> {

    @Inject
    public DatabaseConfigurationProvider() {

    }

    @Override
    public RubyDataConfiguration get() {
        return new StaticConfiguration();
    }

}
