package serialize.tweets.app;

import org.apache.log4j.BasicConfigurator;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class SerializeTweetsApp {

    public static void main(String[] args) {
        
        BasicConfigurator.configure();
        
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        
        java.awt.EventQueue.invokeLater(() -> {
            new AppWindow(new TweetConversor(twitter)).setVisible(true);
        });
        
    }

}
