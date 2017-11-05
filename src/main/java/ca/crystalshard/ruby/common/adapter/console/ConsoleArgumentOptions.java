package ca.crystalshard.ruby.common.adapter.console;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class ConsoleArgumentOptions {

    public Options getOptions() {

        Options options = new Options();

        Option test = new Option("t", "test", false, "a test argument");
        test.setRequired(false);
        options.addOption(test);

        Option propertyOverride = new Option("p", "properties", true, "Location of override property file.");
        propertyOverride.setRequired(false);
        options.addOption(propertyOverride);

        return options;

    }

}
