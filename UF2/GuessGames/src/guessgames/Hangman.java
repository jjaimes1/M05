/*
 * Copyright 2012-2013 Mònica Ramírez Arceda <mramirez@escoladeltreball.org>
 *
 * This file is part of GuessGames.
 *
 * GuessGames is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * GuessGames is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with GuessGames. If not, see <http://www.gnu.org/licenses/>.
 */
package guessgames;

/**
 * Modelizes the hangman game. The user must guess a hidden word. He/she can
 * guess it character by character or by saying the whole word.
 * 
 * @version 07/01/2013
 * @author Mònica Ramírez Arceda
 */
public class Hangman extends Game {

    /** The secret word */
    private String secretWord;
    /**
     * The partial guessed word: the hit chars are shown, the other chars are
     * hidden by the '-' char.
     */
    private String partialWord;
    /** The possible words that can be the secret word */
    private static final String[] AVAILABLE_WORDS = { "gat", "gos", "vaca",
	    "gallina", "tigre" };

    /**
     * Creates a Hangman. Puts the corresponding title, sets a secret word and
     * fill the partial word with '-'.
     */
    public Hangman() {
	super("El penjat");
	int rnd = (int) (Hangman.AVAILABLE_WORDS.length * Math.random());
	this.secretWord = Hangman.AVAILABLE_WORDS[rnd];
	this.partialWord = "";
	for (int i = 0; i < this.secretWord.length(); i++) {
	    partialWord += "-";
	}
    }

    /**
     * Determines if a guess is a good guess: it is a good guess in two cases:
     * if the guess is a char and the char is in thw secret word and if the
     * guess is a word an it is equals the secret word.
     * 
     * @param guess a guess
     * @return true if it is a good guess, false otherwise.
     */
    @Override
    public boolean goodGuess(String guess) {
	if (guess.length() > 1) {
	    return secretWord.equals(guess);
	} else {
	    // Change good '-' for good char
	    for (int i = 0; i < secretWord.length(); i++) {
		if (this.secretWord.charAt(i) == guess.charAt(0)) {
		    this.partialWord = this.partialWord.substring(0, i)
			    + guess
			    + this.partialWord.substring(i + 1,
							 this.partialWord
								 .length());
		}
	    }
	    if (this.partialWord.indexOf('-') == -1) {
		return true;
	    }
	}
	return false;
    }

    /**
     * Gives the partial word.
     * 
     * @return the partial word
     */
    @Override
    public String hint() {
	return this.partialWord;
    }

    /**
     * Gets the solution.
     * 
     * @return the solution
     */
    @Override
    public String getSolution() {
	return this.secretWord;
    }

}