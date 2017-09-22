package ca.crystalshard.adapter.web;

import static spark.Spark.path;
import static spark.Spark.get;

public class HomeController {

    public void register() {

        path("/", () -> {
            get("/", (request, response) -> {
                 return "Hello World!";
            });
        });

    }

}
