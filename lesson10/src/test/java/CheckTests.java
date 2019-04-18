import com.geekbrains.lesson10.task1_2.ArrayOperations;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CheckTests {

    private ArrayOperations operations;

    @Before
    public void init() {
        operations = new ArrayOperations();
    }

    @Test
    public void test1() {
        Assert.assertTrue(operations.check(new int[]{1, 1, 1, 4, 4, 1, 4, 4}));
    }

    @Test
    public void test2() {
        Assert.assertTrue(operations.check(new int[]{1, 1, 1, 1, 1, 1}));
    }

    @Test
    public void test3() {
        Assert.assertTrue(operations.check(new int[]{4, 4, 4, 4}));
    }

    @Test
    public void test4() {
        Assert.assertTrue(operations.check(new int[]{1, 4, 4, 1, 1, 4, 3}));
    }

    @Test
    public void test5() {
        Assert.assertTrue(operations.check(new int[]{1, 4, 8}));
    }
}
