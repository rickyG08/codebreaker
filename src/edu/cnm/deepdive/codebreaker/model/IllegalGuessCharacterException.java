package edu.cnm.deepdive.codebreaker.model;

/**
 * Constructs an expception in {@link Game#} when the user inputs a guess which is not a valid
 * character in the case anything other than "ROYGBIV". Game will let user know that there is an
 * invalid character.
 */
public class IllegalGuessCharacterException extends IllegalArgumentException {

  public IllegalGuessCharacterException() {
  }

  public IllegalGuessCharacterException(String message) {
    super(message);
  }

  public IllegalGuessCharacterException(String message, Throwable cause) {
    super(message, cause);
  }

  public IllegalGuessCharacterException(Throwable cause) {
    super(cause);
  }
}
