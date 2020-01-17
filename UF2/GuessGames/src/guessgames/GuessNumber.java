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
 * Modelizes the guess number game. The gamer must guess a secret number. HE/she
 * will be helped with hints that will inform if the number is greater or lesser
 * than the guessed number.
 * 
 * @version 07/01/2013
 * @author Mònica Ramírez Arceda
 */
public class GuessNumber extends Game {

    /** The secret number to be guessed */
    private int secretNumber;
    /** The last guess the gamer has done */
    private int lastGuess;
    /** The max number the secret number can be */
    private static final int MAX_NUMBER = 100;

    /**
     * Creates a guess number game. Puts the corresponding title and sets a
     * secret number.
     */
    public GuessNumber() {
	super("Endevina un nombre");
	this.secretNumber = (int) (MAX_NUMBER * Math.random() + 1);
    }

    /**
     * Determines if a guess is a good guess: it is a good guess if it is equal to
     * the secret number.
     * 
     * @param guess a guess
     * @return true if guess is the secret number, false otherwise.
     */
    @Override
    public boolean goodGuess(String guess) {
	this.lastGuess = Integer.parseInt(guess);
	return Integer.parseInt(guess) == secretNumber;
    }

    /**
     * Gives a hint: the hint is "El nombre és més petit" if the secret number
     * is lesser than the guessed number by the user or "El nombre és més gran"
     * if the secret number is greater than the secret number.
     * 
     * @return the hint
     */
    @Override
    public String hint() {
	return lastGuess > secretNumber ? "El nombre és més petit"
		: "El nombre és més gran";
    }

    /**
     * Gets the solution.
     * 
     * @return the solution
     */
    @Override
    public String getSolution() {
	return Integer.toString(this.secretNumber);
    }

}