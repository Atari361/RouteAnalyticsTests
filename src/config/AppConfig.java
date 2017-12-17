package config;

import utils.ConfigUtils;

import java.util.Properties;

public abstract class AppConfig {

    private static final String HOST;
    private static final String START_URL_MAIN;
    private static final String START_URL_SECURE;
//    private static final String TEAMCITY_URL;

    static {
        Properties properties = ConfigUtils.getProperties();
        assert properties != null;

        HOST = properties.getProperty("RA_START_URL");
        START_URL_MAIN = "http://" + HOST;
        START_URL_SECURE = "https://" + HOST;
    }

    public static String getHost() {
        return HOST;
    }

    public static String getStartUrl() {
        return START_URL_MAIN;
    }

    public static String getStartUrlSecure() {
        return START_URL_SECURE;
    }

}
