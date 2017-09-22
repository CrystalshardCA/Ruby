package ca.crystalshard;

import ca.crystalshard.adapter.console.ConsoleArgumentOptions;
import ca.crystalshard.adapter.web.HomeController;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import static spark.Spark.get;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Options options = new ConsoleArgumentOptions().getOptions();
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("ruby", options);

            System.exit(1);
            return;
        }

        HomeController home = new HomeController();
        home.register();

        System.out.println( "Hello World!" );


    }
}

