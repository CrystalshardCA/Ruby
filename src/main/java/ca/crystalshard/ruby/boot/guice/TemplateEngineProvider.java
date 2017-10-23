package ca.crystalshard.ruby.boot.guice;

import ca.crystalshard.ruby.common.domain.configuration.RubyWebConfiguration;
import com.google.inject.Inject;
import com.google.inject.Provider;
import org.apache.velocity.app.VelocityEngine;
import spark.TemplateEngine;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.Properties;

public class TemplateEngineProvider implements Provider<TemplateEngine> {

    private RubyWebConfiguration webConfiguration;

    @Inject
    public TemplateEngineProvider(RubyWebConfiguration webConfiguration) {
        this.webConfiguration = webConfiguration;
    }

    @Override
    public TemplateEngine get() {
        return new VelocityTemplateEngine(getVelocityEngine());
    }

    private VelocityEngine getVelocityEngine() {
        VelocityEngine velocityEngine = new VelocityEngine();
        Properties properties = new Properties();
        properties.setProperty("resource.loader", "class");
        properties.setProperty(
                "class.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        velocityEngine.init(properties);
        return velocityEngine;
    }
}

