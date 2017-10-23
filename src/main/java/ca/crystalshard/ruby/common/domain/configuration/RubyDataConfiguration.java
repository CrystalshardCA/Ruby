package ca.crystalshard.ruby.common.domain.configuration;

import ca.crystalshard.ruby.common.domain.DatabaseTypeEnum;

public interface RubyDataConfiguration {
    String getUrl();

    String getUsername();

    String getPassword();

    String getServerName();

    String getMigrationLocation();

    DatabaseTypeEnum getDatabaseType();
}
