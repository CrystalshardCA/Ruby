package ca.crystalshard.ruby.web.adapter.controllers;

import spark.ResponseTransformer;
import spark.Route;
import spark.Spark;

abstract class RubyApiController extends RubyController {

    private ResponseTransformer transformer;

    RubyApiController(ResponseTransformer transformer) {
        this.transformer = transformer;
    }

    void delete(String path, Route route) {
        Spark.delete(path, route, transformer);
    }

    void put(String path, Route route) {
        Spark.put(path, route, transformer);
    }

    void post(String path, Route route) {
        Spark.post(path, route, transformer);
    }

    void get(String path, Route route) {
        Spark.get(path, route, transformer);
    }
}
