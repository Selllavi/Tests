/**
 * Created by Anna on 28.06.2016.
 */
import converter.Changer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.*;
import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class ChangeTest {
    public String firstParameter;
    public String secondParameter;


    public ChangeTest (String firstParameter,String secondParameter) {
        this.firstParameter = firstParameter;
        this.secondParameter = secondParameter;
    }


    @Test
    public void checkChanger   () {
        Changer mover = new Changer(firstParameter,secondParameter);
        String[] result = new String[2];
         result = mover.Change();
        String[] expectedResult = {firstParameter,secondParameter};
        assertTrue("Результат(" + result + ") не равен " + expectedResult, result[0].equals(expectedResult[0])&&result[1].equals(expectedResult[1]));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
                {"EUR","USD"},
                {"USD","EUR"},
                {"RUB","USD"},
                {"RUB","EUR"},
                {"EUR","RUB"},
                {"USD","RUB"}

        });
    }
}
