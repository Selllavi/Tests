/**
 * Created by Anna on 28.06.2016.
 */
import converter.ContrConverter;
import org.junit.Test;
import static junit.framework.Assert.*;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class ContrConverteTest {


    private static double round(double number, int scale) {
        int pow = 10;
        for (int i = 1; i < scale; i++)
            pow *= 10;
        double tmp = number * pow;
        return (double) (int) (tmp) / pow;
    }

    public int firstParameter;


    public ContrConverteTest (int firstParameter) {
        this.firstParameter = firstParameter;

    }

    @Test
    public void checkContrConverter  () {
        ContrConverter converter = new ContrConverter(firstParameter);
        double result = converter.getResult();

        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.sberbank.ru/ru/person");
        try{
            TimeUnit.SECONDS.sleep(5);}
        catch( InterruptedException e)
        {}
        WebElement convert = driver.findElement(By.className("currency-converter-result"));
        String path[]= convert.getText().split(" ");
        double  second = Double.parseDouble (path[path.length-2]);

        driver.close();
        double expectedResult;

        if(firstParameter<0) firstParameter=(-1)*firstParameter;
        expectedResult=(result*second);
        expectedResult=round(expectedResult,2);

        assertTrue("Результат(" + firstParameter + ") не равен " + expectedResult, firstParameter==expectedResult);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
                {10},
                {-200},
                {0}

        });
    }

}