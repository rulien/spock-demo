package no.kodemaker;

import java.util.ArrayList;
import java.util.List;

import groovy.lang.Immutable;

public class User implements Comparable{
    private String nick;
    private String displayName;
    private List<User> follows = new ArrayList<User>();
    private List<User> followers = new ArrayList<User>();

    public User(String nick, String displayName) {
        this.nick = nick;
        this.displayName = displayName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (nick != null ? !nick.equals(user.nick) : user.nick != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return nick != null ? nick.hashCode() : 0;
    }

    public int compareTo(Object o) {
        User user = (User) o;
        return nick.compareTo(user.getNick());
    }

    public String getNick() {
        return nick;
    }

    public List<User> getFollows() {
        return follows;
    }
}
