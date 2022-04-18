package io.github.burakkaygusuz.appiumspringboot.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class LoginScreen extends BaseScreen {

    @AndroidFindBy(xpath = "android.widget.TextView[contains(@text, 'Login')]")
    @iOSXCUITFindBy(accessibility = "Login")
    private WebElement title;

    @AndroidFindBy(accessibility = "username")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == \"username\"`]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"username\" AND name == \"username\" AND value == \"Username\"")
    private WebElement usernameInput;

    @AndroidFindBy(accessibility = "password")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSecureTextField[`label == \"password\"`]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"password\" AND name == \"password\" AND value == \"Password\"")
    private WebElement passwordInput;

    @AndroidFindBy(accessibility = "loginBtn")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"loginBtn\"`][2]")
    private WebElement loginButton;

    public String getTitle(){
        return title.getText();
    }

    public LoginScreen setUsernameAndPassword(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        return this;
    }

    public void clickLoginButton(){
        loginButton.click();
    }
}
