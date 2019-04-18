import com.geekbrains.lesson10.task1_2.ArrayOperations;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChangeTests {

    private ArrayOperations operations;

    @Before
    public void init() {
        operations = new ArrayOperations();
    }

    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[]{1, 7}, operations.change(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[]{}, operations.change(new int[]{1, 2, 3, 4}));
    }

    @Test
    public void test3() {
        Assert.assertArrayEquals(new int[]{1, 2, 3}, operations.change(new int[]{0, 0, 4, 1, 2, 3}));
    }
}
