package ca.crystalshard.ruby.boot.application.module;

import ca.crystalshard.ruby.common.adapter.persistance.Migration;
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
