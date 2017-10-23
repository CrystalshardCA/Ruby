package ca.crystalshard.application.module;

import ca.crystalshard.adapter.web.HomeController;
import ca.crystalshard.adapter.web.JobAdminController;
import ca.crystalshard.adapter.web.JobApiController;
import ca.crystalshard.domain.configuration.RubyWebConfiguration;
import com.google.inject.Inject;

import static spark.Spark.port;
import static spark.Spark.staticFileLocation;

public class WebModule implements RubyModule {

    private RubyWebConfiguration webConfiguration;
    private HomeController homeController;
    private JobApiController jobApiController;
    private JobAdminController jobAdminController;

    @Inject
    public WebModule(RubyWebConfiguration webConfiguration,
                     HomeController homeController,
                     JobApiController jobApiController,
                     JobAdminController jobAdminController) {

        this.webConfiguration = webConfiguration;
        this.homeController = homeController;
        this.jobApiController = jobApiController;
        this.jobAdminController = jobAdminController;
    }

    @Override
    public void register() {
        port(webConfiguration.getPort());
        staticFileLocation(webConfiguration.getStaticFileLocation());
        homeController.register();
        jobApiController.register();
        jobAdminController.register();
    }
}

