import com.geekbrains.lesson10.task3.CsvReaderWriter;
import com.geekbrains.lesson10.task3.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CsvTests {

    private CsvReaderWriter readerWriter;
    private List<Student> list;

    @Before
    public void init() {
        readerWriter = new CsvReaderWriter();
        list = new ArrayList<>();
        list.add(new Student(1, "Bob", 5));
        list.add(new Student(2, "Alex", 4));
        list.add(new Student(3, "Johny", 4));
    }

    @Test
    public void test1() {
        Assert.assertEquals(list, readerWriter.readCsv("data.csv"));
    }
}
