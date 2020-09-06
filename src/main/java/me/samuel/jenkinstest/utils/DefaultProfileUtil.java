package me.samuel.jenkinstest.utils;

import org.springframework.boot.SpringApplication;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.Map;

public class DefaultProfileUtil {
    public static final String SPRING_PROFILE_DEVELOPMENT = "dev";
    private static final String SPRING_PROFILE_DEFAULT = "spring.profiles.default";

    private DefaultProfileUtil() {
    }

    public static void addDefaultProfile(SpringApplication app) {
        Map<String, Object> defProperties = new HashMap<>();
        defProperties.put("spring.profiles.default", "dev");
        app.setDefaultProperties(defProperties);
    }

    public static String[] getActiveProfiles(Environment env) {
        String[] profiles = env.getActiveProfiles();
        return profiles.length == 0 ? env.getActiveProfiles() : profiles;
    }
}
