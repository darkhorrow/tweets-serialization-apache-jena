package serialize.tweets.app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.swing.JOptionPane;

public class PropertyFileReader {
    
    InputStream inputStream;
    private final String propFileName = "config.properties";

    public Map<String, String> getProperties() {
        try {
            Properties properties = new Properties();
            inputStream = getClass()
                    .getClassLoader()
                    .getResourceAsStream(propFileName);

            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + 
                        propFileName + "' not found in the classpath");
            }
            
            Map<String, String> propertiesMap = new HashMap<>();

            propertiesMap.put("ConsumerKey", 
                    properties.getProperty("ConsumerKey"));
            propertiesMap.put("ConsumerSecret", 
                   properties.getProperty("ConsumerSecret"));
            propertiesMap.put("AccessToken", 
                    properties.getProperty("AccessToken"));
            propertiesMap.put("AccessTokenSecret", 
                    properties.getProperty("AccessTokenSecret"));
            
            return propertiesMap;
        } catch (IOException e) {
            System.out.println("Error reading properties: " + e);
            JOptionPane.showMessageDialog(null, "Properties file "
                    + "could not be found.");
            System.exit(-1);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                System.out.println("InputStream error: " + ex);
            }
        }
        return null;
    }

}
