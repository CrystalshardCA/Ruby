package ca.crystalshard.domain.persistance.repositories;

import ca.crystalshard.TestInjectorProvider;

public class MsSqlJobRepositoryTest extends JobRepositoryTest {

    public MsSqlJobRepositoryTest() {
        super(TestInjectorProvider.getInjector());
    }
}