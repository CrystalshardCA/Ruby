package ca.crystalshard.domain.configuration;

import ca.crystalshard.domain.DatabaseTypeEnum;

public interface RubyDataConfiguration {
    String getUrl();

    String getUsername();

    String getPassword();

    String getServerName();

    String getMigrationLocation();

    DatabaseTypeEnum getDatabaseType();
}
