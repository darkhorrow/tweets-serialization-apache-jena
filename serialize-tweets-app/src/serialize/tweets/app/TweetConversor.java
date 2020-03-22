/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialize.tweets.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DC_10;
import org.apache.jena.vocabulary.DC_11;
import org.apache.jena.vocabulary.VCARD;
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
    private final String TWITTER_URI = "https://twitter.com/";
    private final String MY_URI = "https://custom-uri.com/";

    public TweetConversor(Twitter twitter) {
        this.twitter = twitter;
    }

    public Model toRDF(String search, int limit) {
        Model model = ModelFactory.createDefaultModel();
        Query query = new Query(search);

        long lastID = Long.MAX_VALUE;
        List<Status> tweets = new ArrayList();
        while(tweets.size() < limit) {
            if(limit - tweets.size() > 100) {
                query.setCount(100);
            } else {
                query.setCount(limit - tweets.size());
            }
            try {
                QueryResult result = twitter.search(query);
                tweets.addAll(result.getTweets());
                if(tweets.size() == 0) break;
                System.out.println("Gathered " + tweets.size() + " tweets");
                for(Status t : tweets) {
                    if (t.getId() < lastID) {
                        lastID = t.getId();
                    }
                }

            } catch(TwitterException te) {
                System.out.println("Couldn't connect: " + te);
                break;
            }
            query.setMaxId(lastID - 1);
        }

        for(int i = 0; i < tweets.size(); i++) {
            addTweetToModel(model, tweets.get(i));
        }

        return model;
    }

    private void addTweetToModel(Model model, Status t) {
        String userURI = TWITTER_URI + t.getUser().getScreenName();
        String tweetURI = userURI + "/status/" + t.getId();

        Resource tweet = model.createResource(tweetURI);
        Resource user = model.createResource(userURI);
        Resource language = model.createResource(DC_11.language.getURI());

        tweet.addLiteral(DC_11.date, t.getCreatedAt().toString());
        tweet.addLiteral(DC_11.description, t.getText());
        tweet.addLiteral(DC_11.identifier, t.getId());

        user.addLiteral(VCARD.FN, t.getUser().getName());
        user.addLiteral(VCARD.ADR, t.getUser().getLocation());
        tweet.addProperty(DC_11.creator, user);

        Locale languageName = new Locale(t.getLang());
        language.addLiteral(model.createProperty(DC_11.language.getURI()
                + "/code"), t.getLang());
        language.addLiteral(model.createProperty(DC_11.language.getURI()
                + "/name"), languageName.getDisplayLanguage());
        tweet.addProperty(DC_11.language, language);
        
        long replyToID = t.getInReplyToStatusId();
        
        if(replyToID != -1) {
            System.out.println("--------------------REPLIES-------------------");
            try {
                Status tr = twitter.showStatus(replyToID);
                String userResponseURI =
                        TWITTER_URI + t.getUser().getScreenName();
                String tweetResponseURI =
                        userResponseURI + "/status/" + tr.getId();
                if(tr != null) {
                    Resource tweetResponse =
                            model.createResource(tweetResponseURI);
                    tweet.addProperty(model.createProperty(DC_11.relation.getURI()),
                            tweetResponse);
                }  
            } catch(TwitterException te) {
                System.out.println("Couldn't connect: " + te);
            }
        }
    }
}
