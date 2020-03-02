import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class TestPocket {
    private int sum;

    Pocket pocket;

    public TestPocket(int sum){
        this.sum = sum;
    }

    @Before
    public void setUp(){
        pocket = new Pocket();
    }



    @Parameters
    public static Collection prepareData(){
        Object[][] objects = {{10},{55},{94},{90}};
        return Arrays.asList(objects);
    }


    @Test
    public void test(){
        assertTrue(pocket.getIf(sum));
    }
}
