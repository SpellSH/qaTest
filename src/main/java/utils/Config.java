package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    public String getFromEnv(String var) throws IOException {
        InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties");
        Properties prop = new Properties();
        prop.load(input);
        return prop.getProperty(var);
    }
}
