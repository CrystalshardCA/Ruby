package ca.crystalshard.ruby.common.domain.configuration;

public interface RubyWebConfiguration {
    int getPort();

    String getStaticFileLocation();

    String getViewFolder();
}

