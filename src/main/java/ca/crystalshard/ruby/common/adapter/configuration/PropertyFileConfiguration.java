package ca.crystalshard.ruby.common.adapter.configuration;

import ca.crystalshard.ruby.common.domain.DatabaseTypeEnum;
import ca.crystalshard.ruby.common.domain.configuration.RubyDataConfiguration;
import ca.crystalshard.ruby.common.domain.configuration.RubyWebConfiguration;
import com.google.inject.Inject;
import org.apache.commons.lang.NotImplementedException;

public class PropertyFileConfiguration implements RubyWebConfiguration, RubyDataConfiguration {

    private PropertyFile propertyFile;

    @Inject
    public PropertyFileConfiguration(PropertyFile propertyFile) {
        this.propertyFile = propertyFile;
    }

    @Override
    public int getPort() {
        return Integer.parseInt(propertyFile.getProperty("web.port"));
    }

    @Override
    public String getStaticFileLocation() {
        return propertyFile.getProperty("web.staticFileLocation");
    }

    @Override
    public String getViewFolder() {
        return propertyFile.getProperty("web.viewFolder");
    }

    @Override
    public String getUrl() {
        throw new NotImplementedException();
    }

    @Override
    public String getUsername() {
        return propertyFile.getProperty("database.username");
    }

    @Override
    public String getPassword() {
        return propertyFile.getProperty("database.password");
    }

    @Override
    public String getServerName() {
        return propertyFile.getProperty("database.serverName");
    }

    @Override
    public String getMigrationLocation() {
        return propertyFile.getProperty("database.migrationLocationPattern");
    }

    @Override
    public DatabaseTypeEnum getDatabaseType() {
        return DatabaseTypeEnum.valueOf(propertyFile.getProperty("database.type"));
    }

}

