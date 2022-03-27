package io.github.burakkaygusuz.appiumspringboot.drivers.config;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class DriverConfig {

    private final AppiumDriverLocalService service;
    private final UiAutomator2Options uiAutomator2Options;
    private final XCUITestOptions xcuiTestOptions;

    public DriverConfig(AppiumDriverLocalService service, UiAutomator2Options uiAutomator2Options, XCUITestOptions xcuiTestOptions) {
        this.service = service;
        this.uiAutomator2Options = uiAutomator2Options;
        this.xcuiTestOptions = xcuiTestOptions;
    }

    @Bean
    @Scope("driverScope")
    @Primary
    @ConditionalOnProperty(name = "platform", havingValue = "android")
    public AndroidDriver androidDriver() {
        return new AndroidDriver(service, uiAutomator2Options);
    }

    @Bean
    @Scope("driverScope")
    @Primary
    @ConditionalOnProperty(name = "platform", havingValue = "iOS")
    public IOSDriver iosDriver() {
        return new IOSDriver(service, xcuiTestOptions);
    }
}
