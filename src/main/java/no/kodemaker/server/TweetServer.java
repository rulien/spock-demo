package no.kodemaker.server;

import java.util.List;
import java.util.Set;
import java.util.SortedMap;

import no.kodemaker.Tweet;
import no.kodemaker.User;

public interface TweetServer {
    
    SortedMap<String, User> register(User user);

    boolean postNewTweet(Tweet tweet);
    
    List<Tweet> fetchTweets(User user);
    
    boolean followUser(String nick, User follow);
    
    User findUser(String nick);
}
