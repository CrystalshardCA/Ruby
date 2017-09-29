package ca.crystalshard.adapter.configuration;

import ca.crystalshard.domain.configuration.RubyWebConfiguration;

public class StaticConfiguration implements RubyWebConfiguration {

    @Override
    public int getPort() {
        return 8080;
    }
}
