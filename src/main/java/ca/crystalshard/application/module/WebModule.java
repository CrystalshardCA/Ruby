package ca.crystalshard.application.module;

import ca.crystalshard.adapter.web.HomeController;
import ca.crystalshard.domain.configuration.RubyWebConfiguration;
import com.google.inject.Inject;

import static spark.Spark.port;

public class WebModule implements RubyModule {

    private RubyWebConfiguration webConfiguration;
    private HomeController homeController;

    @Inject
    public WebModule(RubyWebConfiguration webConfiguration,
                     HomeController homeController) {
        this.webConfiguration = webConfiguration;
        this.homeController = homeController;
    }

    @Override
    public void register() {
        port(webConfiguration.getPort());
        homeController.register();
    }
}
