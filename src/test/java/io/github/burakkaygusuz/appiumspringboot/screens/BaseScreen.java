package io.github.burakkaygusuz.appiumspringboot.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BaseScreen {

    @Autowired
    protected AppiumDriver driver;

    @Autowired
    protected WebDriverWait wait;

    @PostConstruct
    private void init() {
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }
}
