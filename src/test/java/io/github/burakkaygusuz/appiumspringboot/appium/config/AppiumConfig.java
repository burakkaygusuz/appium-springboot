package io.github.burakkaygusuz.appiumspringboot.appium.config;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class AppiumConfig {

    @Bean
    HashMap<String, String> environment() {
        final HashMap<String, String> env = new HashMap<>();
        env.put("PATH", "/usr/local/bin" + ":" + System.getenv("PATH"));
        env.put("JAVA_HOME", System.getProperty("java.home"));
        env.put("ANDROID_HOME", System.getenv("ANDROID_HOME"));
        return env;
    }

    @Bean
    AppiumServiceBuilder serviceBuilder() {
        return new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingAnyFreePort()
                .withEnvironment(environment())
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "info")
                .withArgument(GeneralServerFlag.RELAXED_SECURITY)
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withArgument(GeneralServerFlag.USE_PLUGINS, "images")
                .withArgument(() -> "-ka", "800");
    }

    @Bean
    public AppiumDriverLocalService service() {
        try (AppiumDriverLocalService localService = AppiumDriverLocalService.buildService(serviceBuilder())) {
            localService.clearOutPutStreams();
            localService.enableDefaultSlf4jLoggingOfOutputData();
            return localService;
        }
    }
}
