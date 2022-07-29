package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.ProjectConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public abstract class BaseTest {

    public static final ProjectConfig cfg = ConfigFactory.create(ProjectConfig.class);

    @Before
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "http://localhost:4444/wd/hub" ;
        DesiredCapabilities capabilities = new DesiredCapabilities() ;
        capabilities.setCapability( "enableVNC", true);
        capabilities.setCapability( "enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        //Configuration.remote = "http://localhost:4444/wd/hub";
    }

    @After
    public void turnDown() {
        Selenide.closeWebDriver();
    }
}