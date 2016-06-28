package converter;

/**
 * Created by Anna on 25.06.2016.
 */

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Converter {

    private int first;


    public  Converter (int first) {
        this.first = first;

    }

    public double  getResult(){
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.sberbank.ru/ru/person");
        try{
            TimeUnit.SECONDS.sleep(5);}
        catch( InterruptedException e)
        {}
        WebElement element_from = driver.findElement(By.id("from"));
        WebElement element_to = driver.findElement(By.id("to"));
        element_from.sendKeys((new Integer(first)).toString());
        try{TimeUnit.SECONDS.sleep(5);}
        catch( InterruptedException e)
        {}
        double result = Double.parseDouble (element_to.getAttribute("value"));
        driver.close();
        return result;
    }
}
