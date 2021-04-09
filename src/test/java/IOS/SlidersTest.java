package IOS;

import io.appium.java_client.ios.IOSElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class SlidersTest extends BaseIOSTest{

    @Test
    public void slidersTest(){

        driver.findElementByAccessibilityId("Sliders").click();
        IOSElement slider = (IOSElement) driver.findElement(By.xpath("//XCUIElementTypeSlider"));
        slider.setValue("0%");
        slider.setValue("1%");
        String value = slider.getAttribute("value");
        Assert.assertEquals("100%", value);
    }
}
