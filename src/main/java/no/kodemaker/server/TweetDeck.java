package no.kodemaker.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import no.kodemaker.Tweet;
import no.kodemaker.User;
import no.kodemaker.exception.UserExistException;

public class TweetDeck implements TweetServer{
    private SortedMap<String,User> users = new TreeMap<String, User>();
    private HashMap<User,List<Tweet>> tweets = new HashMap<User, List<Tweet>>();
    public SortedMap<String, User> register(User user) {
        if(users.get(user.getNick()) != null) throw new UserExistException(user.getNick());
        else users.put(user.getNick(),user);
        return users;
    }

    public boolean postNewTweet(Tweet tweet) {
        if(tweets.get(tweet.getTweeter()) == null) tweets.put(tweet.getTweeter(),new ArrayList<Tweet>());
        return tweets.get(tweet.getTweeter()).add(tweet);
    }

    public List<Tweet> fetchTweets(User user) {
        return tweets.get(user);
    }

    public boolean followUser(String nick, User follow) {
        return users.get(nick).getFollows().add(follow);
    }

    public User findUser(String nick) {
        return users.get(nick);
    }
}
