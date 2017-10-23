package ca.crystalshard.adapter.configuration;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileInputStreamPropertyFile implements PropertyFile {

    Properties properties;
    Logger logger = Logger.getLogger(FileInputStreamPropertyFile.class);

    public FileInputStreamPropertyFile(String propertyFileLocation) {
        InputStream input = null;

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

