package univek.com.semanticserver.utilities.propertyWorker;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

@PropertyResource(data = {"settings", "application", "local"})
public final class PropertyWorker {

    private static Logger logger = Logger.getLogger(PropertyWorker.class);
    private static Properties properties = new Properties();
    private static final String postfix = ".properties";

    static {
        try {
            PropertyResource resources =  PropertyWorker.class.getAnnotation(PropertyResource.class);
            for (String resource:resources.data())
                properties.load(PropertyWorker.class.getClassLoader().getResourceAsStream(resource+postfix));
        } catch (IOException e) {
            logger.error("Can't read properties files");
        }
    }

    public static String getString(String name) {
        return getString(name, null);
    }

    public static String getString(String name, String defaultValue) {
        String prop = properties.getProperty(name);
        if (prop == null || prop.equals(""))
            return defaultValue;
        return prop;
    }


    public static int getInt(String name) {
        return getInt(name, Integer.MIN_VALUE);
    }

    public static int getInt(String name, int defaultValue) {
        try {
            return Integer.parseInt(properties.getProperty(name));
        }
        catch (Exception e) {
            logger.error(String.format("ParseInt while property %s reading error", name));
        }
        return defaultValue;
    }

    public static void set(String name, String value) {
        properties.setProperty(name, value);
    }
}
