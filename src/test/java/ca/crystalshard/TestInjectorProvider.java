package ca.crystalshard;

import ca.crystalshard.ruby.boot.guice.module.AppModule;
import ca.crystalshard.ruby.boot.guice.module.ConfigModule;
import ca.crystalshard.ruby.boot.guice.module.DatabaseModule;
import ca.crystalshard.ruby.common.adapter.configuration.OverridePropertyFileLocation;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestInjectorProvider {
    public static Injector getInjector() {
        String overridePath = System.getenv("RUBY_TEST_PATH");
        return Guice.createInjector(new AppModule(), new ConfigModule(new OverridePropertyFileLocation(overridePath)), new DatabaseModule(), new TestModule());
    }
}
