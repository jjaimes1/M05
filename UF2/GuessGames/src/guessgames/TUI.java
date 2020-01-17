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

import java.util.Scanner;

/**
 * This class is the Terminal User Interface for GuessGames app.
 * 
 * @version 07/01/2013
 * @author Mònica Ramírez Arceda
 */
public class TUI {

    /** The controller */
    private Controller c;
    /** The scanner to collect gamer input */
    private Scanner sc;

    /**
     * Creates a TUI and starts the app.
     */
    public TUI() {
	sc = new Scanner(System.in);
	this.c = new Controller(this);
	c.play();
	sc.close();
    }

    /**
     * Prints the menu.
     * 
     * @param gamesTitles an array with the titles of the games.
     */
    public void printMenu(String[] gamesTitles) {
	System.out.println("GUESS GAMES");
	System.out.println("===========");
	for (int i = 0; i < gamesTitles.length; i++) {
	    System.out.println((i + 1) + ". " + gamesTitles[i]);
	}
	System.out.println("0. Sortir");
    }

    /**
     * Prints the menu item corresponding to a specific game.
     * 
     * @param gamestitles an array with all games titles
     * @param option the corresponding option of the name
     */
    public void printTitleGame(String[] gamestitles, int option) {
	System.out
		.printf("\n" + gamestitles[option - 1].toUpperCase() + "\n\n");
    }

    /**
     * Prints a hint.
     * 
     * @param hint a hint
     */
    public void printHint(String hint) {
	System.out.printf(hint + "\n\n");
    }

    /**
     * Prints a sentence informing the gamer has won.
     */
    public void printWin() {
	System.out.printf("Molt bé! Has guanyat! \\o/\n\n\n");
    }

    /**
     * Prints a sentence informing the gamer has lost.
     */
    public void printLoose() {
	System.out.println("Oooohhhh... Has perdut :(((\n");
    }

    /**
     * Prints the solution of the game.
     * 
     * @param solution the solution
     */
    public void printSolution(String solution) {
	System.out.printf("La solució era: " + solution + "\n\n\n");
    }

    /**
     * Asks the gamer for what game he/she wants to play.
     * 
     * @return the number of the chosen option
     */
    public int askOption() {
	System.out.print("Opció : ");
	String optionS = sc.next();
	int option = Integer.parseInt(optionS);
	return option;
    }

    /**
     * Asks the gamer for a guess.
     * 
     * @return the guess of the gamer
     */
    public String askGuess() {
	System.out.print("Intent : ");
	String guess = sc.next();
	return guess;
    }

    /**
     * Main program.
     * 
     * @param args Not used
     */
    public static void main(String[] args) {
	new TUI();
    }

}