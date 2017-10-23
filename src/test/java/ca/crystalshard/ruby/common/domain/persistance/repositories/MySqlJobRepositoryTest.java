package ca.crystalshard.ruby.common.domain.persistance.repositories;

import ca.crystalshard.TestInjectorProvider;

public class MySqlJobRepositoryTest extends JobRepositoryTest {
    public MySqlJobRepositoryTest() {
        super(TestInjectorProvider.getInjector());
    }
}
