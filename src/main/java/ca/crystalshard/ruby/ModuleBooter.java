package ca.crystalshard.ruby;

import ca.crystalshard.ruby.boot.application.module.MigrationModule;
import ca.crystalshard.ruby.boot.application.module.WebModule;
import com.google.inject.Inject;

public class ModuleBooter {

    private WebModule webModule;
    private MigrationModule migrationModule;

    @Inject
    public ModuleBooter(WebModule webModule, MigrationModule migrationModule) {
        this.webModule = webModule;
        this.migrationModule = migrationModule;
    }

    void init() {
        migrationModule.register();
        webModule.register();
    }
}
