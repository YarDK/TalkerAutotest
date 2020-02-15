import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TestStartApp extends MethodsForTesting {

    Capabilities capabilities = new Capabilities();

    @Before
    public void setUp() throws Exception
    {
        capabilities.setUp();
    }

    @After
    public void tearDown(){
        capabilities.tearDown();
    }


    @Test
    public void testStartApp()
    {
        System.out.println("Test starting");
        waitingForElement(10000);
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
}
