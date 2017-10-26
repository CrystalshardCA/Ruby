package ca.crystalshard.ruby.boot.guice.module;

import ca.crystalshard.ruby.common.adapter.persistance.repositories.mssql.MsSqlJobRepository;
import ca.crystalshard.ruby.common.domain.persistance.repositories.JobRepository;
import com.google.inject.Singleton;

public class MsSqlDatabaseModule extends AbstractDatabaseModule {
    @Override
    protected void configure() {
        super.configure();

        bind(JobRepository.class).to(MsSqlJobRepository.class).in(Singleton.class);
        //TODO Create BuildStep Repo for MsSQL
        //bind(BuildStepRepository.class).to(MsSqlBuildStepRepository.class).in(Singleton.class);
    }
}
