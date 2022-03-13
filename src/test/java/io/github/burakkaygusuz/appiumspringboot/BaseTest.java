package io.github.burakkaygusuz.appiumspringboot;

import io.github.burakkaygusuz.appiumspringboot.appium.service.AppiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest
@TestPropertySource("classpath:application.properties")
public class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private AppiumService appiumService;

    @Test
    void firstTest() {
        appiumService.start();
        System.out.println("URL: " + appiumService.getUrl());
        appiumService.stop();
    }
}
