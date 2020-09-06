package me.samuel.jenkinstest;

import me.samuel.jenkinstest.utils.DefaultProfileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class JenkinsTestApplication {

    private static Logger log = LoggerFactory.getLogger(JenkinsTestApplication.class);

    private static final String SERVER_SSL_KEY_STORE = "server.ssl.key-store";

    public static void main(String[] args) throws UnknownHostException {
//        SpringApplication.run(JenkinsTestApplication.class, args);
        SpringApplication app = new SpringApplication(JenkinsTestApplication.class);
        DefaultProfileUtil.addDefaultProfile(app);
        Environment env = app.run(args).getEnvironment();
        String protocol = "http";
        if (env.getProperty(SERVER_SSL_KEY_STORE) != null) {
            protocol = "https";
        }
        log.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\t{}://localhost:{}\n\t" +
                        "External: \t{}://{}:{}\n\t" +
                        "Profile(s): \t{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                protocol,
                env.getProperty("server.port"),
                protocol,
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"),
                env.getActiveProfiles());
    }

}
