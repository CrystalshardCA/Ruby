package ca.crystalshard;

import ca.crystalshard.boot.guice.module.ConfigModule;
import ca.crystalshard.boot.guice.module.AppModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.apache.log4j.Logger;

public class App
{

    private static Logger log = Logger.getLogger(App.class);

    public static void main( String[] args )
    {
        try {
            Injector injector = Guice.createInjector(new AppModule(), new ConfigModule());
            ModuleBooter booter = injector.getInstance(ModuleBooter.class);
            booter.init();
        } catch (Exception e) {
            log.error("Failed to start application", e);
            throw e;
        }
    }
}

