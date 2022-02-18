package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Common {

    public String getTestData(String brand, String key) {
        String path = System.getProperty("user.dir") + "/src/test/java/test_data/" + brand + ".properties";
        return loadProperties(path, key);
    }

    private String loadProperties(String filePath, String key) {
        String value = "";
        try (InputStream input = new FileInputStream(filePath)) {
            Properties prop = new Properties();
            prop.load(input);
            value = prop.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
