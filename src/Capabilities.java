import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class Capabilities {

    private AppiumDriver driver;

    @Before
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

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLogin()
    {
        String sipId = "test86@talk.mangosip.ru";
        String passForLogin = "123456aB";

        waitForElementAndSendKeys(
                By.id("com.mangotele.mtalker:id/loginInput"),
                sipId,
                "Element 'loginInput' not find by id",
                5
        );

        waitForElementAndSendKeys(
                By.id("com.mangotele.mtalker:id/password_edittext_input"),
                passForLogin,
                "Element 'password_edittext_input' not find by id",
                5
        );

        waitForElementAndClick(
                By.id("com.mangotele.mtalker:id/signIn"),
                "Element 'signIn' not find by id",
                5
        );

        try{
            Thread.sleep(10000);
        } catch (Exception e){
            System.out.println(e);
        }

        for(int i = 0; i<4; i++)
        {
            waitForElementAndClick(
                    By.id("com.android.packageinstaller:id/permission_allow_button"),
                    "Element 'Настройки' not found",
                    10
            );
        }

        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc=\"Open\"]"),
                "Element 'Menu' not found",
                10
        );

        try{
            Thread.sleep(5000);
        } catch (Exception e){
            System.out.println(e);
        }

        waitForElementAndClick(
                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.TextView"),
                "Element 'Настройки' not found",
                5
        );



        waitForElementAndClick(
                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView"),
                "Element 'Учетная запись' not found",
                5
        );

        waitForElementAndClick(
                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView"),
                "Element 'Выйти' not found",
                5
        );

        waitForElementAndClick(
                By.id("android:id/button1"),
                "Element 'button1' not found",
                5
        );

        try{
            Thread.sleep(10000);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    // Метод для ожидания появления элемента
    public WebElement waitForElementPresents(By by, String error_massage, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_massage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    // Перегруженный метод для ожидания появления элемента, таймаут задан по умолчанию 5 секунд
    public WebElement waitForElementPresents(By by, String error_massage) {
        return waitForElementPresents(by, error_massage, 5);
    }

    // Метод для совершения клика по элементу
    public WebElement waitForElementAndClick(By by, String error_massage, long timeoutInSeconds) {
        WebElement element = waitForElementPresents(by, error_massage, timeoutInSeconds);
        element.click();
        return element;
    }

    // Метод для ввода значения в выбранный элемент
    public WebElement waitForElementAndSendKeys(By by, String value, String error_massage, long timeoutInSeconds) {
        WebElement element = waitForElementPresents(by, error_massage, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    // Метод для проверки отсутствия элемента
    public boolean waitForElementNotPresent(By by, String error_massage, long timeInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.withMessage(error_massage +"\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    // Метод для удаления текста
    public WebElement waitElementAndClear(By by, String error_massage, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresents(by, error_massage, timeoutInSeconds);
        element.clear();
        return element;
    }

    // Кастомный метод скрола. Делает свайп от элемента From к элементу To
    public void customSwipe(By from, By to)
    {
        WebElement resource = driver.findElement(from);
        WebElement openid = driver.findElement(to);
        TouchAction action = new TouchAction(driver);
        action.press(resource).moveTo(openid).release();
        action.perform();
    }
}
