package core;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {
    @BeforeAll
   static public void setUp(){
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browser = "chrome";
        Configuration.browserSize="1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }
}
