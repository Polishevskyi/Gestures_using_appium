package topics.longParassing;

import base.AppDriver;
import base.AppFactory;
import base.Util;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class AndroidLongPress {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("emulator-5554")
                .setPlatformVersion("14.0")
                .setAppPackage("com.google.android.dialer")
                .setAppActivity("com.google.android.dialer.extensions.GoogleDialtactsActivity");

        AppFactory.android_launchApp(options);
        AppDriver.getDriver().findElement(AppiumBy.accessibilityId("key pad")).click();
        WebElement zero = AppDriver.getDriver().findElement(AppiumBy.accessibilityId("0"));
        Util.longPress(zero);
        Thread.sleep(1000);
        zero.click();
        AppDriver.getDriver().findElement(AppiumBy.accessibilityId("8,TUV")).click();
        Thread.sleep(1000);

        AppDriver.getDriver().findElement(AppiumBy.accessibilityId("8,TUV")).click();
        zero.click();
        Thread.sleep(1000);

        WebElement backSpase = AppDriver.getDriver().findElement(AppiumBy.accessibilityId("backspace"));
        backSpase.click();
        Thread.sleep(2000);

        Util.longPress(backSpase);
        Thread.sleep(4000);
        AppDriver.getDriver().quit();
    }
}
