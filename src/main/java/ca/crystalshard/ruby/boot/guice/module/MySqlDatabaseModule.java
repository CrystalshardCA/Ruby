package ca.crystalshard.ruby.boot.guice.module;

import ca.crystalshard.ruby.common.adapter.persistance.repositories.MySqlBuildStepRepository;
import ca.crystalshard.ruby.common.adapter.persistance.repositories.MySqlJobRepository;
import ca.crystalshard.ruby.common.domain.persistance.repositories.BuildStepRepository;
import ca.crystalshard.ruby.common.domain.persistance.repositories.JobRepository;
import com.google.inject.Singleton;

public class MySqlDatabaseModule extends AbstractDatabaseModule {

    @Override
    protected void configure() {
        super.configure();

        bind(JobRepository.class).to(MySqlJobRepository.class).in(Singleton.class);
        bind(BuildStepRepository.class).to(MySqlBuildStepRepository.class).in(Singleton.class);
    }
}

