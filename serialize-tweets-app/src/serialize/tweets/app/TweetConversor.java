/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialize.tweets.app;

import java.util.ArrayList;
import java.util.List;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 *
 * @author Darkhorrow
 */
public class TweetConversor {

    private Twitter twitter;

    public TweetConversor(Twitter twitter) {
        this.twitter = twitter;
    }

    public Model toRDF(String search, int limit) {
        Model model = ModelFactory.createDefaultModel();
        Query query = new Query(search);

        long lastID = Long.MAX_VALUE;
        List<Status> tweets = new ArrayList();
        while (tweets.size() < limit) {
            if (limit - tweets.size() > 100) {
                query.setCount(100);
            } else {
                query.setCount(limit - tweets.size());
            }
            try {
                QueryResult result = twitter.search(query);
                tweets.addAll(result.getTweets());
                System.out.println("Gathered " + tweets.size() + " tweets");
                for (Status t : tweets) {
                    if (t.getId() < lastID) {
                        lastID = t.getId();
                    }
                }

            } catch (TwitterException te) {
                System.out.println("Couldn't connect: " + te);
            }
            query.setMaxId(lastID - 1);
        }

        for (int i = 0; i < tweets.size(); i++) {
            Status t = tweets.get(i);
        }

        return model;
    }
}
