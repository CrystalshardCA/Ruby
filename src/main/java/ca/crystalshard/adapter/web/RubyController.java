package ca.crystalshard.adapter.web;

import spark.Route;
import spark.RouteGroup;
import spark.Spark;
import spark.TemplateEngine;
import spark.TemplateViewRoute;

public class RubyController {
    private TemplateEngine templateEngine;

    protected void delete(String path, TemplateViewRoute route) {
        Spark.delete(path, route, templateEngine);
    }

    protected void delete(String path, Route route) {
        Spark.delete(path, route);
    }

    protected void put(String path, TemplateViewRoute route) {
        Spark.put(path, route, templateEngine);
    }

    protected void put(String path, Route route) {
        Spark.put(path, route);
    }

    protected void post(String path, TemplateViewRoute route) {
        Spark.post(path, route, templateEngine);
    }

    protected void post(String path, Route route) {
        Spark.post(path, route);
    }

    protected void get(String path, TemplateViewRoute route) {
        Spark.get(path, route, templateEngine);
    }

    protected void get(String path, Route route) {
        Spark.get(path, route);
    }

    protected void path(String path, RouteGroup group)
    {
        Spark.path(path, group);
    }
}
