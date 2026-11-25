package tests;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.RegisterPage;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest {
    @Test
    public void registerNewUserTest() {
        open("login");
        LoginPage loginPage = new LoginPage();
        RegisterPage registerPage = loginPage.pressNewUser();
        String successRegistrationText = registerPage
                .enterFirstName()
                .enterLastName()
                .enterUserName()
                .enterPassword()
                .clickButtonRegister()
                .getAlertTextAndAccept();
        Assertions.assertEquals("User Registered Successfully.", successRegistrationText, "Неправильный текст в алерте");
        String generatedUser = registerPage.getGeneratedUserName();
        String generatedPassword = registerPage.getGeneratedPassword();
        loginPage =  registerPage.clickBackLogin();
        loginPage
                .enterUserName(generatedUser)
                .enterPassword(generatedPassword)
                .pressLoginButton();
    }


}
