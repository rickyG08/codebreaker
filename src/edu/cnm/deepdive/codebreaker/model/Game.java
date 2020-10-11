package edu.cnm.deepdive.codebreaker.model;

import edu.cnm.deepdive.codebreaker.model.Code.Guess;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Starts the game for {@link edu.cnm.deepdive.codebreaker.controller.Codebreaker}. Which users can
 * guess a code from a set length of characters from a set POOL of characters.
 */
public class Game {

  private static final String BAD_GUESS_PATTERN_FORMAT = "^.*[^%s].*$";
  private static final String ILLEGAL_LENGTH_MESSAGE =
      "Invalid guess length: required=%d; provided=%d.";
  private static final String ILLEGAL_CHARACTER_MESSAGE =
      "Guess includes invalid characters: required=%s; provided=%s.";

  private final Code code;
  private final List<Guess> guesses;
  private final String pool;
  private final int length;
  private final String badGuessPattern;

  /**
   * Implements a new code for users to guess (starts new game). POOL and length have already been
   * preset.
   *
   * @param pool   consists of "ROYGBIV"
   * @param length is 4
   * @param rng    random code
   */
  public Game(String pool, int length, Random rng) {
    code = new Code(pool, length, rng);
    guesses = new LinkedList<>();
    this.pool = pool;
    this.length = length;
    badGuessPattern = String.format(BAD_GUESS_PATTERN_FORMAT, pool);
  }

  /**
   * Returns the secret for user to guess
   */
  public Code getCode() {
    return code;
  }

  /**
   * Returns list of guesses
   */
  public List<Guess> getGuesses() {
    return Collections.unmodifiableList(guesses);
  }

  /**
   * Returns POOL of valid characters for guess
   */
  public String getPool() {
    return pool;
  }

  /**
   * Returns length of characters for guess.
   */
  public int getLength() {
    return length;
  }

  /**
   * Returns the count of guesses the user has inputted.
   */
  public int getGuessCount() {
    return guesses.size();
  }

  /**
   * Implemented when user enters a non-valid guess with excluded characters from the pool and a
   * guess with the length != to the guess length then throws an Exception.
   *
   * @param text
   * @return A guess
   * @throws IllegalGuessLengthException
   * @throws IllegalGuessCharacterException
   */
  public Guess guess(String text)
      throws IllegalGuessLengthException, IllegalGuessCharacterException {
    if (text.length() != length) {
      throw new IllegalGuessLengthException(String.format(
          ILLEGAL_LENGTH_MESSAGE, length, text.length()));
    }
    if (text.matches(badGuessPattern)) {
      throw new IllegalGuessCharacterException(String.format(
          ILLEGAL_CHARACTER_MESSAGE, pool, text));
    }
    Guess guess = code.new Guess(text);
    guesses.add(guess);
    return guess;
  }

  /**
   * Game starts over with a new game with a new secret codeand all previous guesses get cleared
   * from game.
   */
  public void restart() {
    guesses.clear();
  }
}
