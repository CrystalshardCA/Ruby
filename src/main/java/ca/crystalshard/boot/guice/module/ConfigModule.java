package ca.crystalshard.boot.guice.module;

import ca.crystalshard.boot.guice.DatabaseConfigurationProvider;
import ca.crystalshard.boot.guice.WebConfigurationProvider;
import ca.crystalshard.domain.configuration.RubyDataConfiguration;
import ca.crystalshard.domain.configuration.RubyWebConfiguration;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class ConfigModule extends AbstractModule {
    protected void configure() {
        bind(RubyWebConfiguration.class).toProvider(WebConfigurationProvider.class).in(Singleton.class);
        bind(RubyDataConfiguration.class).toProvider(DatabaseConfigurationProvider.class).in(Singleton.class);
    }
}
