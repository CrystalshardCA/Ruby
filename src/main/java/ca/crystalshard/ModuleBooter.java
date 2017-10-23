package ca.crystalshard;

import ca.crystalshard.application.module.MigrationModule;
import ca.crystalshard.application.module.WebModule;
import com.google.inject.Inject;

public class ModuleBooter {

    private WebModule webModule;
    private MigrationModule migrationModule;

    @Inject
    public ModuleBooter(WebModule webModule, MigrationModule migrationModule) {
        this.webModule = webModule;
        this.migrationModule = migrationModule;
    }

    public void init() {
        migrationModule.register();
        webModule.register();
    }
}
