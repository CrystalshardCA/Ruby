package ca.crystalshard.adapter.web;

import spark.Route;
import spark.RouteGroup;
import spark.Spark;
import spark.TemplateEngine;
import spark.TemplateViewRoute;

public class RubyController {
    private TemplateEngine templateEngine;

    RubyController(TemplateEngine templateEngine) {

        this.templateEngine = templateEngine;
    }

    void delete(String path, TemplateViewRoute route) {
        Spark.delete(path, route, templateEngine);
    }

    void delete(String path, Route route) {
        Spark.delete(path, route);
    }

    void put(String path, TemplateViewRoute route) {
        Spark.put(path, route, templateEngine);
    }

    void put(String path, Route route) {
        Spark.put(path, route);
    }

    void post(String path, TemplateViewRoute route) {
        Spark.post(path, route, templateEngine);
    }

    void post(String path, Route route) {
        Spark.post(path, route);
    }

    void get(String path, TemplateViewRoute route) {
        Spark.get(path, route, templateEngine);
    }

    void get(String path, Route route) {
        Spark.get(path, route);
    }

    void path(String path, RouteGroup group)
    {
        Spark.path(path, group);
    }
}
