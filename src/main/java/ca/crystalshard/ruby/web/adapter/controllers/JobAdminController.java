package ca.crystalshard.ruby.web.adapter.controllers;

import ca.crystalshard.ruby.common.domain.persistance.repositories.JobRepository;
import ca.crystalshard.ruby.web.adapter.spark.ModelAndView;
import com.google.inject.Inject;
import spark.TemplateEngine;
import spark.TemplateViewRoute;

public class JobAdminController extends RubyTemplateController {

    private JobRepository jobRepository;

    @Inject
    public JobAdminController(TemplateEngine templateEngine, JobRepository jobRepository) {
        super(templateEngine);
        this.jobRepository = jobRepository;
    }

    @Override
    public void register() {
        path("/job", () -> get("", (TemplateViewRoute) (request, response) -> {
            int i = 1;
            return new ModelAndView(emptyModel(), "jobs/index.vm");
        }));
    }
}
