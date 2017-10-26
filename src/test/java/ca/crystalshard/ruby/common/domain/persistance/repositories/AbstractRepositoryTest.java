package ca.crystalshard.ruby.common.domain.persistance.repositories;

import com.google.inject.Injector;
import org.junit.AfterClass;

public class AbstractRepositoryTest {

    Injector injector;
    private static TestRepository testRepository;


    AbstractRepositoryTest(Injector injector) {
        this.injector = injector;
        testRepository = injector.getInstance(TestRepository.class);
    }

    @AfterClass
    public static void afterClass() {
        testRepository.cleanupDatabases();
    }

}
