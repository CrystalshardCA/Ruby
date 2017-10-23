package ca.crystalshard.boot.guice.module;

import ca.crystalshard.adapter.configuration.OverridePropertyFileLocation;
import ca.crystalshard.adapter.configuration.PropertyFile;
import ca.crystalshard.boot.guice.DatabaseConfigurationProvider;
import ca.crystalshard.boot.guice.PropertyFileProvider;
import ca.crystalshard.boot.guice.WebConfigurationProvider;
import ca.crystalshard.domain.configuration.RubyDataConfiguration;
import ca.crystalshard.domain.configuration.RubyWebConfiguration;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class ConfigModule extends AbstractModule {

    private OverridePropertyFileLocation overridePropertyFileLocation;

    public ConfigModule(OverridePropertyFileLocation overridePropertyFileLocation) {
        this.overridePropertyFileLocation = overridePropertyFileLocation;
    }

    protected void configure() {
        bind(OverridePropertyFileLocation.class).toInstance(overridePropertyFileLocation);
        bind(PropertyFile.class).toProvider(PropertyFileProvider.class).in(Singleton.class);
        bind(RubyWebConfiguration.class).toProvider(WebConfigurationProvider.class).in(Singleton.class);
        bind(RubyDataConfiguration.class).toProvider(DatabaseConfigurationProvider.class).in(Singleton.class);
    }
}
