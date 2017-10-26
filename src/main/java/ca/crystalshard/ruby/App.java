package ca.crystalshard.ruby;

import ca.crystalshard.ruby.boot.guice.module.AppModule;
import ca.crystalshard.ruby.boot.guice.module.ConfigModule;
import ca.crystalshard.ruby.boot.guice.module.MySqlDatabaseModule;
import ca.crystalshard.ruby.common.adapter.configuration.OverridePropertyFileLocation;
import ca.crystalshard.ruby.common.adapter.console.ConsoleArgumentOptions;
import ca.crystalshard.ruby.common.domain.DatabaseTypeEnum;
import ca.crystalshard.ruby.common.domain.configuration.RubyDataConfiguration;
import ca.crystalshard.ruby.common.domain.exceptions.InvalidApplicationConfigurationException;
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

            Injector injector = Guice.createInjector(new AppModule(), new ConfigModule(new OverridePropertyFileLocation(cmd.getOptionValue("p"))));
            RubyDataConfiguration config = injector.getInstance(RubyDataConfiguration.class);
            Injector childInjector = getChildInjector(injector, config);
            ModuleBooter booter = childInjector.getInstance(ModuleBooter.class);
            booter.init();
        } catch (Exception e) {
            log.error("Failed to start application", e);
        }
    }

    private static Injector getChildInjector(Injector injector, RubyDataConfiguration config) {
        Injector childInjector;
        if (config.getDatabaseType().equals(DatabaseTypeEnum.MsSql)) {
            childInjector = injector.createChildInjector(new MySqlDatabaseModule());
            log.info("*************************************************************************");
            log.info("*                                                                       *");
            log.info("*          Initializing Database in Microsoft SQL Mode                  *");
            log.info("*                                                                       *");
            log.info("*************************************************************************");
        }
        else if(config.getDatabaseType().equals(DatabaseTypeEnum.MySql)) {
            childInjector = injector.createChildInjector(new MySqlDatabaseModule());
            log.info("*************************************************************************");
            log.info("*                                                                       *");
            log.info("*             Initializing Database in MySQL Mode                       *");
            log.info("*                                                                       *");
            log.info("*************************************************************************");
        }
        else {
            throw new InvalidApplicationConfigurationException(String.format("Unable to initialize selected database type: %s", config.getDatabaseType()));
        }
        return childInjector;
    }
}