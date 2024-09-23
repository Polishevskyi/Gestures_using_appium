package topics.dragDrop;

import base.AppDriver;
import base.AppFactory;
import base.Util;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;

public class IOSDragDrop {

    @Test
    public static void DD_Test() throws MalformedURLException, InterruptedException {
        XCUITestOptions options = new XCUITestOptions()
                .setDeviceName("iPhone 15 Pro")
                .setPlatformVersion("17.2")
                .setBundleId("org.reactjs.native.example.wdiodemoapp");
        AppFactory.ios_launchApp(options);

        Thread.sleep(2000);

        AppDriver.getDriver().findElement(AppiumBy.accessibilityId("Drag")).click();

        for(int i=0; i<getSourceItems().size();i++){
            Util.dragNDrop_gesture(getEl(getSourceItems().get(i)), getEl(getTargetItems().get(i)));
            Thread.sleep(500);
        }

        Thread.sleep(4000);
        AppDriver.getDriver().quit();
    }

    static ArrayList<String> getSourceItems(){
        ArrayList<String> sourceItems = new ArrayList<String>(
                Arrays.asList("drag-l1", "drag-l2", "drag-l3",
                        "drag-c1", "drag-c2", "drag-c3",
                        "drag-r1", "drag-r2", "drag-r3"));
        return sourceItems;
    }

    static ArrayList<String> getTargetItems() {
        ArrayList<String> targetItems = new ArrayList<String>(
                Arrays.asList("drop-l1", "drop-l2", "drop-l3",
                        "drop-c1", "drop-c2", "drop-c3",
                        "drop-r1", "drop-r2", "drop-r3"));
        return targetItems;
    }

    static WebElement getEl(String item){
        return AppDriver.getDriver().findElement(AppiumBy.accessibilityId(item));
    }
}
