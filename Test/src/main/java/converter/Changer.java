package converter;

/**
 * Created by Anna on 28.06.2016.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Changer {

    public String money_first;
    public String money_second;
    public  Changer  (String money_first, String money_second) {
        this.money_first = money_first;
        this.money_second = money_second;
    }

    public String[]  Change(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://www.sberbank.ru/ru/person");

        try{TimeUnit.SECONDS.sleep(5);}
        catch( InterruptedException e)
        {}

        List<WebElement> list_Elem = driver.findElements(By.className("select2-arrow"));
        WebElement Elem_first = list_Elem.get(0);
        Elem_first.click();

        try{TimeUnit.SECONDS.sleep(5);}
        catch( InterruptedException e)
        {}

        WebElement chose_first = driver.findElement(By.id("select2-result-label-7"));
        if(money_first .equals("USD"))  chose_first = driver.findElement(By.id("select2-result-label-5"));
        if(money_first .equals("EUR"))  chose_first = driver.findElement(By.id("select2-result-label-6"));

        chose_first.click();

        List<WebElement> list_current_elem = driver.findElements(By.className("select2-chosen"));
        WebElement current_first = list_current_elem.get(0);

        String[] result =  new String[2];
          result[0]=  current_first.getText();

        list_Elem = driver.findElements(By.className("select2-arrow"));
        WebElement Elem_second = list_Elem.get(1);
        Elem_second.click();

        try{TimeUnit.SECONDS.sleep(5);}
        catch( InterruptedException e)
        {}

        if(money_first .equals("RUB")) {
            WebElement  chose_second = driver.findElement(By.id("select2-result-label-10"));

            if (money_second.equals("USD")) chose_second = driver.findElement(By.id("select2-result-label-8"));
            if (money_second.equals("EUR")) chose_second = driver.findElement(By.id("select2-result-label-9"));
            chose_second.click();
        }

        if(money_first .equals("USD")) {
            WebElement chose_second = driver.findElement(By.id("select2-result-label-12"));

            if (money_second.equals("USD")) chose_second = driver.findElement(By.id("select2-result-label-10"));
            if (money_second.equals("EUR")) chose_second = driver.findElement(By.id("select2-result-label-11"));
            chose_second.click();
        }

        if(money_first .equals("EUR")) {
            WebElement chose_second = driver.findElement(By.id("select2-result-label-14"));


            if (money_second.equals("USD")) chose_second = driver.findElement(By.id("select2-result-label-12"));
            if (money_second.equals("EUR")) chose_second = driver.findElement(By.id("select2-result-label-13"));
            chose_second.click();
        }


        list_current_elem = driver.findElements(By.className("select2-chosen"));
        WebElement current_second = list_current_elem.get(1);
        result[1]=  current_second.getText();


        driver.close();
        return result;
    }
}
