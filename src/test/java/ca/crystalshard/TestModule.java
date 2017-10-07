package ca.crystalshard;

import ca.crystalshard.domain.persistance.repositories.TestRepository;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class TestModule extends AbstractModule {


    @Override
    protected void configure() {
        //bind(TestRepository.class).to(TestRepository.class).in(Singleton.class);
    }
}
