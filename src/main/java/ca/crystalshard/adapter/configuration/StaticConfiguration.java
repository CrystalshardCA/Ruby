package ca.crystalshard.adapter.configuration;

import ca.crystalshard.domain.configuration.RubyWebConfiguration;

public class StaticConfiguration implements RubyWebConfiguration {

    @Override
    public int getPort() {
        return 8080;
    }

    @Override
    public String getStaticFileLocation() {
        return "/public";
    }

    @Override
    public String getViewFolder() {
        return "/views";
    }
}
