import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.URL;

public class Capabilities {

    private AppiumDriver driver;

    public AppiumDriver getDriver(){
        return this.driver;
    }

    public void setUp() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.1");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "com.mangotele.mtalker");
        capabilities.setCapability("appActivity", "com.mango.talker.LaunchActivity");
        capabilities.setCapability("app", "D:\\IdeaProjects\\TalkerAutotest\\apks\\M.TALKER_com.mangotele.mtalker.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }


    public void tearDown()
    {
        driver.quit();
    }




}
