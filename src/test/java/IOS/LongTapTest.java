package IOS;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import io.appium.java_client.touch.LongPressOptions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LongTapTest {
    IOSDriver driver;

    @Before
    public void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.4");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12 Pro");
        //IOS_XCUI_Test
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        capabilities.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 500000);
        capabilities.setCapability("commandTimeouts", "12000");
        capabilities.setCapability(MobileCapabilityType.APP, "Users/a18740877/Desktop/apps/longtap/longtap.app");

        //in terminal use command: % instruments -s devices
        //this command can help to know all versions on Iphone
        //1281CED1-C0B8-4EE0-9FA3-29CA5174C34A

        driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void turnOff(){
        driver.quit();
    }

    @Test
    public void longTapTest(){

        MobileElement element = (MobileElement) driver.findElement(By.name("Long tap"));
        IOSTouchAction touch = new IOSTouchAction(driver);
        touch.longPress(new LongPressOptions().withElement(element(element)).withDuration(ofSeconds(2)))
        .release().perform();

        MobileElement tap = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeSwitch[1]"));
        touch.tap(tapOptions().withElement(element(tap))).perform();
    }
}
