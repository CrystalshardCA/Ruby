package ca.crystalshard;

import ca.crystalshard.adapter.configuration.OverridePropertyFileLocation;
import ca.crystalshard.boot.guice.module.AppModule;
import ca.crystalshard.boot.guice.module.ConfigModule;
import ca.crystalshard.boot.guice.module.DatabaseModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestInjectorProvider {
    public static Injector getInjector() {
        return Guice.createInjector(new AppModule(), new ConfigModule(new OverridePropertyFileLocation(null)), new DatabaseModule(), new TestModule());
    }
}
