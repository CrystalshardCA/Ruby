package ca.crystalshard.domain.persistance.repositories;

import ca.crystalshard.TestInjectorProvider;

public class MySqlJobRepositoryTest extends JobRepositoryTest {
    public MySqlJobRepositoryTest() {
        super(TestInjectorProvider.getInjector());
    }
}
