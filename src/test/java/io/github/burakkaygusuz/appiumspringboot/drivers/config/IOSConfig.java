package io.github.burakkaygusuz.appiumspringboot.drivers.config;

import io.appium.java_client.ios.options.XCUITestOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.TestPropertySource;

import java.net.URL;

@Configuration
@TestPropertySource("classpath:application.properties")
public class IOSConfig {

    @Value("${ios.version}")
    private String version;

    @Value("${ios.app.path}")
    private URL app;

    @Value("${ios.device.name}")
    private String deviceName;

    @Value("${ios.udid}")
    private String udid;

    @Value("${bundle.id}")
    private String bundleId;

    @Bean
    public XCUITestOptions xcuiTestOptions() {
        return new XCUITestOptions()
                .setPlatformVersion(version)
                .setApp(app)
                .setDeviceName(deviceName)
                .setUdid(udid)
                .setBundleId(bundleId)
                .setNoReset(false)
                .setAbsoluteWebLocations(true)
                .setAutoAcceptAlerts(true)
                .setIsHeadless(true);
    }
}
