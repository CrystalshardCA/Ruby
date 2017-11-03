package ca.crystalshard.ruby.web.adapter.controllers;

import ca.crystalshard.ruby.web.adapter.spark.ModelAndView;
import com.google.inject.Inject;
import spark.Spark;
import spark.TemplateEngine;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;

public class HomeController extends RubyTemplateController {

    @Inject
    public HomeController(TemplateEngine templateEngine) {
        super(templateEngine);
    }

    @Override
    public void register() {

        Spark.before((req, res) -> {
            String path = req.pathInfo();
            if (path.endsWith("/") && !path.equals("/")) {
                res.redirect(path.substring(0, path.length() - 1));
            }
        });

        path("/", () -> {
            get("/", (TemplateViewRoute) (request, response) -> {
                Map<String, Object> model = new HashMap<>();
                model.put("firstName", "First");
                model.put("lastName", "Last");

                return new ModelAndView(model, "home/index.vm");
            });
            get("/about", (TemplateViewRoute) (request, response) -> {
                int i = 1;

                return new ModelAndView(i, "home/index.vm");
            });
        });

    }
}

