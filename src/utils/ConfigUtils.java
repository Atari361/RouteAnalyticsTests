package utils;

import com.sun.org.apache.bcel.internal.util.ClassLoader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class ConfigUtils {

    private static Properties PROPERTIES = new Properties();

    static {
        InputStream input = null;
        try {
            URL resource = ConfigUtils.class.getResource("/config.properties");
            input = new FileInputStream(resource.getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            PROPERTIES.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Properties getProperties(){
        return PROPERTIES;
    }
}
