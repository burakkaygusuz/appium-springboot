package io.github.burakkaygusuz.appiumspringboot.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class MainScreen extends BaseScreen {

    @AndroidFindBy(accessibility = "Login Screen")
    @iOSXCUITFindBy(accessibility = "Login Screen")
    private WebElement loginScreen;

    public void getLoginScreen() {
        loginScreen.click();
    }
}
