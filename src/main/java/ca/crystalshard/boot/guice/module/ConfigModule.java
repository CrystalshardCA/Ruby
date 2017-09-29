package ca.crystalshard.boot.guice.module;

import ca.crystalshard.boot.guice.ConfigurationProvider;
import ca.crystalshard.domain.configuration.RubyWebConfiguration;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class ConfigModule extends AbstractModule {
    protected void configure() {
        bind(RubyWebConfiguration.class).toProvider(ConfigurationProvider.class).in(Singleton.class);
    }
}
