package ca.crystalshard.adapter.web;

import spark.Route;

public class HomeController extends RubyController {

    public void register() {

        path("/", () -> {
            get("/", (Route) (request, response) -> {
                 return "Hello World!";
            });
        });

    }

}
