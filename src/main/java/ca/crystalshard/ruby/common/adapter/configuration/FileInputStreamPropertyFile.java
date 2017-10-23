package ca.crystalshard.ruby.common.adapter.configuration;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileInputStreamPropertyFile implements PropertyFile {

    private Properties properties;

    public FileInputStreamPropertyFile(String propertyFileLocation) {
        InputStream input = null;

        Logger logger = Logger.getLogger(FileInputStreamPropertyFile.class);
        try {
            input = new FileInputStream(propertyFileLocation);

            properties.load(input);
        }
        catch (IOException ex) {
            logger.error("There was a problem loading the properties file.", ex);
        }
        finally {
            if (input != null) {
                try {
                    input.close();
                }
                catch (IOException e) {
                    logger.error("There was a problem closing the properties file.", e);
                }
            }
        }
    }

    @Override
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}

