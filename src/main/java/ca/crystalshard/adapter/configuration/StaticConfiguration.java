package ca.crystalshard.adapter.configuration;

import ca.crystalshard.domain.configuration.RubyDataConfiguration;
import ca.crystalshard.domain.configuration.RubyWebConfiguration;

public class StaticConfiguration implements RubyWebConfiguration, RubyDataConfiguration {

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

    @Override
    public String getUrl() {
        return "jdbc:sqlserver://localhost:1433;DatabaseName=Ruby;InstanceName=MSSQLSERVER";
    }

    @Override
    public String getUsername() {
        return "ruby_user";
    }

    @Override
    public String getPassword() {
        return "password";
    }

    @Override
    public String getServerName() {
        return "localhost";
    }

    @Override
    public String getMigrationLocation() {
        return "/db/migration";
    }
}
