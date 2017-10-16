package ca.crystalshard.adapter.web;

import spark.Spark;
import spark.TemplateEngine;
import spark.TemplateViewRoute;

abstract class RubyTemplateController extends RubyController {

    private TemplateEngine templateEngine;

    RubyTemplateController(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    void delete(String path, TemplateViewRoute route) {
        Spark.delete(path, route, templateEngine);
    }

    void put(String path, TemplateViewRoute route) {
        Spark.put(path, route, templateEngine);
    }

    void post(String path, TemplateViewRoute route) {
        Spark.post(path, route, templateEngine);
    }

    void get(String path, TemplateViewRoute route) {
        Spark.get(path, route, templateEngine);
    }
}
