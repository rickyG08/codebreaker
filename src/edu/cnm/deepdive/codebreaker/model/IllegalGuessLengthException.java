package edu.cnm.deepdive.codebreaker.model;

/**
 * \ Constructs an exception in {@link Game} when a user has entered too many characters for the
 * valid guess length.
 */
public class IllegalGuessLengthException extends IllegalArgumentException{

  public IllegalGuessLengthException() {
  }

  public IllegalGuessLengthException(String message) {
    super(message);
  }

  public IllegalGuessLengthException(String message, Throwable cause) {
    super(message, cause);
  }

  public IllegalGuessLengthException(Throwable cause) {
    super(cause);
  }
}
