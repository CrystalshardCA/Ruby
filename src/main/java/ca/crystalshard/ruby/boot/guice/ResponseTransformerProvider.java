package ca.crystalshard.ruby.boot.guice;

import ca.crystalshard.ruby.common.adapter.spark.JsonResponseTransformer;
import com.google.inject.Provider;
import spark.ResponseTransformer;

public class ResponseTransformerProvider implements Provider<ResponseTransformer> {

    @Override
    public ResponseTransformer get() {
        return new JsonResponseTransformer();
    }
}


