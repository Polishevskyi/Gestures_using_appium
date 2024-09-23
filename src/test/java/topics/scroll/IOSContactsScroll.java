package topics.scroll;

import base.AppDriver;
import base.AppFactory;
import base.AppiumServer;
import base.Util;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class IOSContactsScroll {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AppiumServer.start();
        XCUITestOptions options = new XCUITestOptions()
                .setDeviceName("iPhone 15 Pro")
                .setPlatformVersion("17.2")
                .setBundleId("com.apple.MobileAddressBook");
        AppFactory.ios_launchApp(options);

//        Util.scroll(Util.ScrollDirection.DOWN, 0.5);
//        Util.scrollNclick(By.xpath("//XCUIElementTypeOther[@name='ContactsListView']//XCUIElementTypeCell"), "name", "99999");
        Util.scrollNclick(By.name("99999"));
        Thread.sleep(2000);
        AppDriver.getDriver().quit();
    }
}
