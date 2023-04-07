package dev.lfsoutello.persistencepoc.exception;

public class InvalidOrder extends RuntimeException {
    public InvalidOrder(String message) {
        super(message);
    }
}
