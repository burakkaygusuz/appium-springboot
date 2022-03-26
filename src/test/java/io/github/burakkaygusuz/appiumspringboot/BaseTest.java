package io.github.burakkaygusuz.appiumspringboot;

import io.github.burakkaygusuz.appiumspringboot.service.AppiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SpringBootTest
@TestPropertySource("classpath:application.properties")
public class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private AppiumService appiumService;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        appiumService.start();
    }

    @Test()
    void firstTest() {
        System.out.println("URL: " + appiumService.getUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (appiumService.isRunning()) {
            appiumService.stop();
        }
    }
}
