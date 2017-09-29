package ca.crystalshard.adapter.web;

import ca.crystalshard.adapter.web.spark.ModelAndView;
import com.google.inject.Inject;
import spark.TemplateEngine;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;

public class HomeController extends RubyController {

    @Inject
    public HomeController(TemplateEngine templateEngine) {
        super(templateEngine);
    }

    public void register() {

        path("/", () -> {
            get("/", (TemplateViewRoute) (request, response) -> {
                 Map<String, Object> model = new HashMap<>();
                 model.put("firstName", "Blair");
                 model.put("lastName", "Stewart");

                 return new ModelAndView(model, "test.vm");
            });
        });

    }
}

