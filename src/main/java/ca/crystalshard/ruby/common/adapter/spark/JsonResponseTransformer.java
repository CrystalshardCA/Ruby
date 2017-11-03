package ca.crystalshard.ruby.common.adapter.spark;

import com.google.gson.GsonBuilder;
import spark.ResponseTransformer;

public class JsonResponseTransformer implements ResponseTransformer {

    @Override
    public String render(Object object) throws Exception {
        return new GsonBuilder().serializeNulls().create().toJson(object);
    }
}
