package ca.crystalshard.adapter.web;

import spark.Route;
import spark.RouteGroup;
import spark.Spark;
import spark.TemplateEngine;
import spark.TemplateViewRoute;

public abstract class RubyController {

    void delete(String path, Route route) {
        Spark.delete(path, route);
    }
    void put(String path, Route route) {
        Spark.put(path, route);
    }
    void post(String path, Route route) {
        Spark.post(path, route);
    }
    void get(String path, Route route) {
        Spark.get(path, route);
    }
    void path(String path, RouteGroup group)
    {
        Spark.path(path, group);
    }

    public abstract void register();
}

