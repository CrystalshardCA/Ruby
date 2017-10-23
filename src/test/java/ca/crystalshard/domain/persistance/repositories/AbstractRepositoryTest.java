package ca.crystalshard.domain.persistance.repositories;

import com.google.inject.Injector;
import org.junit.AfterClass;

public class AbstractRepositoryTest {

    private static TestRepository testRepository;

    AbstractRepositoryTest(Injector injector) {
        testRepository = injector.getInstance(TestRepository.class);
    }

    @AfterClass
    public static void afterClass() {
        testRepository.cleanupDatabases();
    }

}
