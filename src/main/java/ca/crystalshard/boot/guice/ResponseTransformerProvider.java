package ca.crystalshard.boot.guice;

import ca.crystalshard.adapter.web.spark.JsonResponseTransformer;
import com.google.inject.Provider;
import spark.ResponseTransformer;

public class ResponseTransformerProvider implements Provider<ResponseTransformer> {

    @Override
    public ResponseTransformer get() {
        return new JsonResponseTransformer();
    }
}


