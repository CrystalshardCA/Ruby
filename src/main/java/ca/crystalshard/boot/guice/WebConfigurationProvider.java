package ca.crystalshard.boot.guice;

import ca.crystalshard.adapter.configuration.StaticConfiguration;
import ca.crystalshard.domain.configuration.RubyWebConfiguration;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class WebConfigurationProvider implements Provider<RubyWebConfiguration> {

    @Inject
    public WebConfigurationProvider() {

    }

    @Override
    public RubyWebConfiguration get() {
        return new StaticConfiguration();
    }

}

