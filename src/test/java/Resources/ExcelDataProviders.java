package Resources;
import Utils.ExcelDataUtil;
import org.testng.annotations.DataProvider;

import java.util.List;
import java.util.Map;

public class ExcelDataProviders {

    @DataProvider(name = "loginData")
    public static Object[][] loginDataProvider() {
        // Suppose you have a method to get all rows as a List<Map<String, String>>
        List<Map<String, String>> allRows = ExcelDataUtil.getAllRows("Sheet1");
        Object[][] data = new Object[allRows.size()][1];
        for (int i = 0; i < allRows.size(); i++) {
            data[i][0] = allRows.get(i);
        }
        return data;
    }
}
