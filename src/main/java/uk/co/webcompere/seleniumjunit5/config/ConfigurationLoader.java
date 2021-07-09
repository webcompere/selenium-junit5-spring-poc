package uk.co.webcompere.seleniumjunit5.config;

import uk.org.webcompere.lightweightconfig.ConfigLoader;

/**
 * Responsible for loading the configuration
 */
public class ConfigurationLoader {
    private static final String CONFIG_FILENAME = "config.yml";
    private static Configuration configuration;

    /**
     * Get or load the configuration
     * @return the configuration
     */
    public static synchronized Configuration getConfiguration() {
        if (configuration == null) {
            try {
                configuration = ConfigLoader.loadYmlConfigFromResource(CONFIG_FILENAME, Configuration.class);
            } catch (Throwable t) {
                throw new RuntimeException("Could not load configuration: " + t.getMessage(), t);
            }
        }
        if (configuration == null) {
            throw new RuntimeException("Configuration not loaded - can't be blank");
        }
        return configuration;
    }
}
