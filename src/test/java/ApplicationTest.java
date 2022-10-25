import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ApplicationTest {
    private final Application application = new Application();

    @Test
    public void migratoryBirds(){
        Integer[] ids = {1, 4, 4, 4, 5, 3};
        int actual = application.migratoryBirds(Arrays.asList(ids));
        Assert.assertEquals(actual,4);
    }
}