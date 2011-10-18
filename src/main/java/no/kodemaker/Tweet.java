package no.kodemaker;

public class Tweet {
    private String content;
    private User tweeter;

    public Tweet(String content, User tweeter) {
        this.content = content;
        this.tweeter = tweeter;
    }

    public User getTweeter() {
        return tweeter;
    }
}
