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
 * Modelizes a generic game.
 * 
 * @version 07/01/2013
 * @author Mònica Ramírez Arceda
 */
public abstract class Game {

    /** The title of the game */
    private String title;
    /** The left number of lifes of the gamer */
    private int lifes;
    /** The initial number of lifes */
    private final static int INITIAL_LIFES = 5;

    /**
     * Creates a Game.
     * 
     * @param title the title of the game
     */
    public Game(String title) {
	this.lifes = Game.INITIAL_LIFES;
	this.title = title;
    }

    /**
     * Loose a life.
     */
    public void looseLife() {
	this.lifes--;
    }

    /**
     * Get the number of left lifes.
     * 
     * @return the number of lifes.
     */
    public int getLifes() {
	return this.lifes;
    }

    /**
     * Get the title of the game.
     * 
     * @return the title.
     */
    public String getTitle() {
	return title;
    }

    /**
     * Determines if a guess is a good guess or not.
     * 
     * @param guess a guess
     * @return true if it is good, false otherwise.
     */
    public abstract boolean goodGuess(String guess);

    /**
     * Gives a hint to help the gamer.
     * 
     * @return a hint
     */
    public abstract String hint();

    /**
     * Gets the solution of the game.
     * 
     * @return the solution
     */
    public abstract String getSolution();

}