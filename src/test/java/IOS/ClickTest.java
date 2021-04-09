package IOS;

import io.appium.java_client.ios.IOSDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ClickTest extends BaseIOSTest {

    @Test
    public void firstTest(){

        getElement(By.xpath(
                "//XCUIElementTypeStaticText[@name='Alert Views']"))
                .click();
        getElement(By.xpath(
                "//XCUIElementTypeStaticText[@name='Text Entry']"))
                .click();
        getElement(By.xpath("//XCUIElementTypeCell"))
                .sendKeys("hello");
        driver.findElementByAccessibilityId("OK").click();

        driver.findElementByAccessibilityId("Confirm / Cancel").click();

        String name = getElement(By.xpath("//*[contains(@name, 'message')]")).getText();
        System.out.println(name);
        driver.findElementByAccessibilityId("Confirm").click();

    }

    public WebElement getElement(By by){
        return driver.findElement(by);
    }
}
