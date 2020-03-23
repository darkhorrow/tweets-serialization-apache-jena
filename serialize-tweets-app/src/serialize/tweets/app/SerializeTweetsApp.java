package serialize.tweets.app;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Properties;
import org.apache.log4j.BasicConfigurator;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class SerializeTweetsApp {

    public static void main(String[] args) {
        PropertyFileReader pr = new PropertyFileReader();
        Map<String, String> keys = pr.getProperties();

        BasicConfigurator.configure();

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(keys.get("ConsumerKey"))
                .setOAuthConsumerSecret(keys.get("ConsumerSecret"))
                .setOAuthAccessToken(keys.get("AccessToken"))
                .setOAuthAccessTokenSecret(keys.get("AccessTokenSecret"));
        
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        java.awt.EventQueue.invokeLater(() -> {
            new AppWindow(new TweetConversor(twitter)).setVisible(true);
        });

    }

}
