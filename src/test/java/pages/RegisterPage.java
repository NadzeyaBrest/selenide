package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Alert;
import static com.codeborne.selenide.Selenide.$;
public class RegisterPage {


    private final SelenideElement firstNameField = $("#firstname");
    private final SelenideElement lastNameField = $("#lastname");
    private final SelenideElement userNameField = $("#userName");
    private final SelenideElement passwordField = $("#password");
    private final SelenideElement buttonRegister = $("#register");
    private final SelenideElement buttonBackToLogin = $("#gotologin");
    private String generatedUserName;
    private String generatedPassword = "Test12345!";

    public String getGeneratedPassword() {
        return generatedPassword;
    }

    public String getGeneratedUserName() {
        return generatedUserName;
    }

    public RegisterPage enterFirstName() {
        Selenide.sleep(2000);
        String unique = String.valueOf(System.currentTimeMillis()).substring(8);
        generatedUserName = "User" + unique;
        firstNameField.setValue(generatedUserName);

        System.out.println("first "+generatedUserName);
        return this;
    }

    public RegisterPage enterLastName() {

        lastNameField.setValue("SecondName");

        System.out.println("last "+"SecondName");
        return this;
    }

    public RegisterPage enterUserName() {

        userNameField.setValue(generatedUserName);

        System.out.println("UserName "+generatedUserName);
        return this;
    }

    public RegisterPage enterPassword() {

        passwordField.setValue(generatedPassword);
        System.out.println("password "+generatedPassword);
        return this;
    }

    public LoginPage clickBackLogin() {
        buttonBackToLogin.click();
        return new LoginPage();
    }

    public String getAlertTextAndAccept() {

            Alert alert = Selenide.switchTo().alert();
            String text = alert.getText().trim();
            alert.accept();
            return text;

    }

    public RegisterPage clickButtonRegister() {

        buttonRegister.click();
        return this;
    }


}
