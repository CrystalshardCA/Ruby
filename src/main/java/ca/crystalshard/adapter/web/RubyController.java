package ca.crystalshard.adapter.web;

import spark.Route;
import spark.RouteGroup;
import spark.Spark;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("SameParameterValue")
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

    void path(String path, RouteGroup group) {
        Spark.path(path, group);
    }

    Map<String, Object> emptyModel() {
        return new HashMap<>();
    }

    public abstract void register();
}

