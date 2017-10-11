package ca.crystalshard.application.module;

import ca.crystalshard.adapter.web.HomeController;
import ca.crystalshard.adapter.web.JobController;
import ca.crystalshard.domain.configuration.RubyWebConfiguration;
import com.google.inject.Inject;

import static spark.Spark.port;
import static spark.Spark.staticFileLocation;

public class WebModule implements RubyModule {

    private RubyWebConfiguration webConfiguration;
    private HomeController homeController;
    private JobController jobController;

    @Inject
    public WebModule(RubyWebConfiguration webConfiguration,
                     HomeController homeController,
                     JobController jobController) {

        this.webConfiguration = webConfiguration;
        this.homeController = homeController;
        this.jobController = jobController;
    }

    @Override
    public void register() {
        port(webConfiguration.getPort());
        staticFileLocation(webConfiguration.getStaticFileLocation());
        homeController.register();
        jobController.register();
    }
}

