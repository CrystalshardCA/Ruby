package ca.crystalshard.adapter.console;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class ConsoleArgumentOptions {

    public Options getOptions() {

        Options options = new Options();

        Option test = new Option("t", "test", false, "a test argument");
        test.setRequired(false);
        options.addOption(test);

        return options;

    }

}
