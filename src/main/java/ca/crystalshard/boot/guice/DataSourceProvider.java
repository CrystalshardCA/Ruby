package ca.crystalshard.boot.guice;

import ca.crystalshard.domain.configuration.RubyDataConfiguration;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.sql.DataSource;

public class DataSourceProvider implements Provider<DataSource> {

    private RubyDataConfiguration configuration;

    @Inject
    public DataSourceProvider(RubyDataConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public DataSource get() {

        switch(configuration.getDatabaseType()) {
            case MsSql:
                return getSqlServerDataSource();
            case MySql:
                return getMySqlServerDataSource();
            default:
                throw new NotImplementedException();
        }
    }

    private MysqlDataSource getMySqlServerDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser(configuration.getUsername());
        dataSource.setPassword(configuration.getPassword());
        dataSource.setServerName(configuration.getServerName());
        dataSource.setPortNumber(3306);
        dataSource.setDatabaseName("Ruby");
        return dataSource;
    }

    private SQLServerDataSource getSqlServerDataSource() {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setUser(configuration.getUsername());
        dataSource.setPassword(configuration.getPassword());
        dataSource.setServerName(configuration.getServerName());
        dataSource.setPortNumber(1433);
        dataSource.setInstanceName("MSSQLSERVER");
        dataSource.setDatabaseName("Ruby");
        return dataSource;
    }


}
