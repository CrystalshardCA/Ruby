package ca.crystalshard.domain.persistance.repositories;

import ca.crystalshard.TestInjectorProvider;
import org.junit.Ignore;

@Ignore
public class MsSqlJobRepositoryTest extends JobRepositoryTest {

    public MsSqlJobRepositoryTest() {
        super(TestInjectorProvider.getInjector());
    }
}
