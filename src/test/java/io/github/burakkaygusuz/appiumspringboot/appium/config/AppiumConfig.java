package io.github.burakkaygusuz.appiumspringboot.appium.config;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
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

    @SneakyThrows
    @Bean
    File appiumJS() {
        String actualJSPath;
        if (System.getProperty("os.name").contains("Win")) {
            Process process = new ProcessBuilder("where appium").start();
            assert process.getInputStream().read() == -1;
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                actualJSPath = bufferedReader.lines()
                        .findFirst()
                        .map(jsPaths -> jsPaths.replace("appium", "node_modules\\appium\\build\\lib\\main.js"))
                        .orElse(null);
                process.waitFor();
                process.destroy();
            }

            if (actualJSPath == null)
                Runtime.getRuntime().exit(0);
        } else {
            actualJSPath = "/usr/local/lib/node_modules/appium/build/lib/main.js";
        }
        return new File(actualJSPath);
    }

    @Bean
    AppiumServiceBuilder serviceBuilder() {
        return new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withEnvironment(environment())
                .withAppiumJS(appiumJS())
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "info")
                .withArgument(GeneralServerFlag.RELAXED_SECURITY)
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withArgument(GeneralServerFlag.USE_DRIVERS, "uiautomator2,xcuitest")
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
