package ca.crystalshard;

import ca.crystalshard.ruby.boot.guice.module.AppModule;
import ca.crystalshard.ruby.boot.guice.module.ConfigModule;
import ca.crystalshard.ruby.boot.guice.module.MySqlDatabaseModule;
import ca.crystalshard.ruby.common.adapter.configuration.OverridePropertyFileLocation;
import ca.crystalshard.ruby.common.domain.DatabaseTypeEnum;
import ca.crystalshard.ruby.common.domain.configuration.RubyDataConfiguration;
import ca.crystalshard.ruby.common.domain.exceptions.InvalidApplicationConfigurationException;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestInjectorProvider {
    public static Injector getInjector() {
        String overridePath = System.getenv("RUBY_TEST_PATH");
        Injector injector = Guice.createInjector(new AppModule(), new ConfigModule(new OverridePropertyFileLocation(overridePath)), new TestModule());
        RubyDataConfiguration config = injector.getInstance(RubyDataConfiguration.class);
        return getChildInjector(injector, config);
    }

    private static Injector getChildInjector(Injector injector, RubyDataConfiguration config) {
        Injector childInjector;
        if (config.getDatabaseType().equals(DatabaseTypeEnum.MsSql)) {
            childInjector = injector.createChildInjector(new MySqlDatabaseModule());
        }
        else if(config.getDatabaseType().equals(DatabaseTypeEnum.MySql)) {
            childInjector = injector.createChildInjector(new MySqlDatabaseModule());
        }
        else {
            throw new InvalidApplicationConfigurationException(String.format("Unable to initialize selected database type: %s", config.getDatabaseType()));
        }
        return childInjector;
    }
}
