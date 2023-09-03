package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {
    static Properties properties = new Properties();
    static FileInputStream fis;

    public static String getAgentIdEasy() throws IOException {
        initProperty();
        return properties.getProperty("agent_id_easy");
    }

    public static String getAgentIdNormal() throws IOException {
        initProperty();
        return properties.getProperty("agent_id_normal");
    }

    private static void initProperty() throws IOException {
        fis =  new FileInputStream("src/test/resources/testData.properties");
        properties.load(fis);
    }
}
