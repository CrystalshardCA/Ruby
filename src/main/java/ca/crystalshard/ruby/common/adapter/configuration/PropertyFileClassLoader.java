package ca.crystalshard.ruby.common.adapter.configuration;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class PropertyFileClassLoader implements PropertyFile {

    private Logger logger = Logger.getLogger(PropertyFileClassLoader.class);
    private Properties properties;

    public PropertyFileClassLoader(String propertyFileLocation, String overrideFileLocation) {
        this.properties = loadPropertyFile(propertyFileLocation);
        Properties overrideFile = loadPropertyFileFromFS(overrideFileLocation);
        overrideProperties(overrideFile);
    }

    private void overrideProperties(Properties overrideFile) {
        for (Map.Entry<Object, Object> entrySet : overrideFile.entrySet()) {
            properties.setProperty((String) entrySet.getKey(), (String) entrySet.getValue());
        }
    }

    public PropertyFileClassLoader(String propertyFileLocation) {
        this.properties = loadPropertyFile(propertyFileLocation);
    }

    private Properties loadPropertyFileFromFS(String propertyFileLocation) {
        InputStream input = null;
        Properties properties = new Properties();

        try {
            input = new FileInputStream(propertyFileLocation);
            properties.load(input);

        } catch (Exception ex) {
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

        return properties;
    }

    private Properties loadPropertyFile(String propertyFileLocation) {
        InputStream input = null;
        Properties properties = new Properties();

        try {
            input = getClass().getClassLoader().getResourceAsStream(propertyFileLocation);
            if (input == null) {
                logger.error(String.format("Unable to find property file at: %s", propertyFileLocation));
            }
            else {
                properties.load(input);
            }
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

        return properties;
    }

    @Override
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
