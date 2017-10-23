package ca.crystalshard.domain.persistance.repositories;

import ca.crystalshard.TestInjectorProvider;
import org.junit.Ignore;

@Ignore
public class MySqlJobRepositoryTest extends JobRepositoryTest {
    public MySqlJobRepositoryTest() {
        super(TestInjectorProvider.getInjector());
    }
}
