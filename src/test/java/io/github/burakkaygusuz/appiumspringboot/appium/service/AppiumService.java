package io.github.burakkaygusuz.appiumspringboot.appium.service;

import java.net.URL;

public interface AppiumService {

    void start();

    void stop();

    boolean isRunning();

    URL getUrl();
}
