package ca.crystalshard;

import ca.crystalshard.application.module.WebModule;
import com.google.inject.Inject;

public class ModuleBooter {

    private WebModule webModule;

    @Inject
    public ModuleBooter(WebModule webModule) {
        this.webModule = webModule;
    }

    public void init() {
        webModule.register();
    }
}
