package TestCases;

import Common.Constant;
import Common.Log;
import Common.WebDriverUtils;
import com.opencsv.CSVReader;
import org.testng.annotations.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestBase {

    @BeforeSuite
    @Parameters("browser")
    public void beforeSuite(@Optional("chrome") String browserName) {
        Constant.WEB_DRIVER = browserName;
    }

    @BeforeMethod
    public void setUp() {
        WebDriverUtils.initDriver();
        Log.info("Navigate to Safe Railway.");
        WebDriverUtils.navigate(Constant.PAGE_URL);
    }

    @AfterMethod
    public void exit() {
        Log.info("Quit browser.");
        WebDriverUtils.quitBrowse();
    }

    @DataProvider
    public Iterator<Object[]> getData() throws IOException {
        String path = "D:\\Hoan1\\Intern\\Project\\SeleniumLV1\\src\\test\\java\\DataObjects\\" + this.getClass().getSimpleName() + ".csv";
        Reader reader = new FileReader(path);
        CSVReader csvReader = new CSVReader(reader);

        List<Object[]> list = new ArrayList<>();
        String[] nextLine = csvReader.readNext();
        while (nextLine != null) {
            Object[] objLine = nextLine;
            list.add(objLine);
            nextLine = csvReader.readNext();
        }

        Iterator<Object[]> data = list.iterator();
        return data;
    }
}