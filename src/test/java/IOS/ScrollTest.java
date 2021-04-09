package IOS;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.HashMap;

public class ScrollTest  extends BaseIOSTest{

    @Test
    public void scrollTest(){

        HashMap<String,Object>scrollObject = new HashMap<>();
        scrollObject.put("direction", "down");
        scrollObject.put("value", "Web View");

        driver.executeScript("mobile: scroll",scrollObject);
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Web View']")).click();

        //Picker view
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name='UIKitCatalog']")).click();
        driver.findElementByAccessibilityId("Picker View").click();
        driver.findElementByAccessibilityId("Red color component value").sendKeys("80");
        driver.findElementByAccessibilityId("Green color component value").sendKeys("220");

        String text = driver.findElementByAccessibilityId("Green color component value").getText();
        Assert.assertEquals("220",text);


    }
}
