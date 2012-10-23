package edu.uml.project90308.businesslogic;

public class MoreThanOneUserFoundException extends Exception {

    public MoreThanOneUserFoundException() {
        super();
    }

    public MoreThanOneUserFoundException(String msg) {
        super(msg);
    }
}
