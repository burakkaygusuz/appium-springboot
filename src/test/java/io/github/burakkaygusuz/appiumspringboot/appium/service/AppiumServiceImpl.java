package io.github.burakkaygusuz.appiumspringboot.appium.service;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;

@Service("appiumService")
public class AppiumServiceImpl implements AppiumService {

    private final AppiumDriverLocalService localService;

    @Autowired
    AppiumServiceImpl(AppiumDriverLocalService localService) {
        this.localService = localService;
    }

    @Override
    public void start() {
        localService.start();
    }

    @Override
    public void stop() {
        localService.stop();
    }

    @Override
    public boolean isRunning() {
        return localService.isRunning();
    }

    @Override
    public URL getUrl() {
        return localService.getUrl();
    }
}
