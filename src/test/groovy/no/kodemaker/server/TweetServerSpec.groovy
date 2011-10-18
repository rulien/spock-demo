package no.kodemaker.server

import spock.lang.Specification
import spock.lang.Shared
import spock.lang.Stepwise
import no.kodemaker.User
import no.kodemaker.exception.UserExistException
import no.kodemaker.Tweet


@Stepwise
class TweetServerSpec extends Specification {
    @Shared TweetServer tweetDeck = new TweetDeck()

    def "should be possible to register a user against server"() {
        given :
            User user = new User(nick,displayName)
        when :
            def users = tweetDeck.register(user)
        then :
            users[nick]
        where :
            nick     | displayName
            "rulien" | "Rune Lien"
            "mette"  | "Mette Lien"
    }

    def "should not be possible to register two users with same nick"(){
        given :
            User user = new User("rulien","Rune Lien")
        when :
            tweetDeck.register(user)
        then :
            thrown(UserExistException)
    }

    def "should be possible for a registered user to post a tweet"() {
        given :
            User user = new User("rulien","Rune Lien")
            Tweet tweet = new Tweet("Hallo der ute", user)
        when :
            def ok = tweetDeck.postNewTweet(tweet)
        then :
            ok
            tweetDeck.fetchTweets(user) != null
    }

    def "should be possible for a registered user to follow another user"() {
        given :
            User follow = new User("rulien", "Rune Lien")
        when :
            def success = tweetDeck.followUser("mette",follow)
        then :
            success
            tweetDeck.findUser("mette").follows.contains(follow)
    }

}
