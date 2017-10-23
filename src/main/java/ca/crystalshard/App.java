package ca.crystalshard;

import ca.crystalshard.boot.guice.module.AppModule;
import ca.crystalshard.adapter.configuration.OverridePropertyFileLocation;
import ca.crystalshard.adapter.console.ConsoleArgumentOptions;
import ca.crystalshard.boot.guice.module.ConfigModule;
import ca.crystalshard.boot.guice.module.DatabaseModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.log4j.Logger;

public class App {

    private static Logger log = Logger.getLogger(App.class);

    public static void main(String[] args) {
        try {
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(new ConsoleArgumentOptions().getOptions(), args);

            Injector injector = Guice.createInjector(new AppModule(), new ConfigModule(new OverridePropertyFileLocation(cmd.getOptionValue("p"))), new DatabaseModule());
            ModuleBooter booter = injector.getInstance(ModuleBooter.class);
            booter.init();
        } catch (Exception e) {
            log.error("Failed to start application", e);
        }
    }
}

