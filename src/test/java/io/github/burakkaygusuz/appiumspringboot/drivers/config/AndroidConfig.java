package io.github.burakkaygusuz.appiumspringboot.drivers.config;

import io.appium.java_client.android.options.UiAutomator2Options;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.net.URL;

@Configuration
@PropertySource("classpath:device.properties")
public class AndroidConfig {

    @Value("${android.version}")
    private String version;

    @Value("${android.app.path}")
    private URL app;

    @Value("${android.device.name}")
    private String deviceName;

    @Value("${android.udid}")
    private String udid;

    @Value("${android.avd.name}")
    private String avdName;

    @Value("${app.activity}")
    private String appActivity;

    @Value("${app.package}")
    private String appPackage;

    @Bean
    public UiAutomator2Options uiAutomator2Options() {
        return new UiAutomator2Options()
                .setPlatformVersion(version)
                .setApp(app)
                .setDeviceName(deviceName)
                .setUdid(udid)
                .setAvd(avdName)
                .setAppActivity(appActivity)
                .setAppPackage(appPackage)
                .setNoReset(false)
                .skipUnlock()
                .setAutoGrantPermissions(true)
                .setIsHeadless(true);
    }
}
