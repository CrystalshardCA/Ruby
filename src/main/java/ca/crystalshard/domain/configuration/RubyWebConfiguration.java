package ca.crystalshard.domain.configuration;

public interface RubyWebConfiguration {
    int getPort();

    String getStaticFileLocation();

    String getViewFolder();
}
