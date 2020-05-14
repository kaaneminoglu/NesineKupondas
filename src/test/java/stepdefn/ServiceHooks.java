package stepdefn;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ServiceHooks {
    public static AppiumDriver<MobileElement> driver;
    private static final String LOCALHOST = "http://127.0.0.1:4723/wd/hub";

    public void setup() throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap = getDesiredCapabilities();
        driver = new AppiumDriver<MobileElement>(new URL(LOCALHOST),cap);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Thread.sleep(3000);
    }

    private DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability("deviceName", "Pixel_XL");
        dc.setCapability("udid", "emulator-5554");
        dc.setCapability("platformName", "Android");
        dc.setCapability("appPackage", "com.pordiva.nesine.android");
        dc.setCapability("appActivity", "com.nesine.ui.taboutside.splash.SplashActivity");
        return dc;
    }
}
