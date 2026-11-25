package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage  {
    private final SelenideElement userNameField= $ ("#userName");
    private final SelenideElement userPasswordField= $ ("#password");
    private final SelenideElement buttonNewUser = $("#newUser");
    private final SelenideElement buttonLogin = $("#login");

    public LoginPage enterUserName (String userName){
        userNameField.setValue(userName);
        return this;
    }
    public LoginPage enterPassword(String password){
        userPasswordField.setValue(password);
        return this;
    }
    public RegisterPage pressNewUser(){
        buttonNewUser.click();
        return new RegisterPage();
    }
    public LoginPage pressLoginButton(){
        buttonLogin.click();
        return this;
    }

}
