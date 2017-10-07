package ca.crystalshard.application.module;

import ca.crystalshard.adapter.persistance.Migration;
import com.google.inject.Inject;

public class MigrationModule implements RubyModule {
    private Migration migration;

    @Inject
    public MigrationModule(Migration migration) {
        this.migration = migration;
    }

    @Override
    public void register() {
        migration.migrate();
    }
}
