package no.kodemaker.exception;


public class UserExistException extends RuntimeException{

    public UserExistException(String user) {
        super("User"+user+" already exist");
    }
}
