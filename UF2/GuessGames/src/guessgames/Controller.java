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
 * Modelizes the controller of the app.
 * 
 * @version 07/01/2013
 * @author Mònica Ramírez Arceda
 */
public class Controller {

    /** The Terminal User Interface */
    private TUI tui;

    /**
     * Creates a Controller.
     * 
     * @param tui the terminal user interface.
     */
    public Controller(TUI tui) {
	this.tui = tui;
    }

    /**
     * Executes the flow of the app.
     */
    public void play() {
	String[] gamesTitles = new String[2];
	gamesTitles[0] = new GuessNumber().getTitle();
	gamesTitles[1] = new Hangman().getTitle();

	this.tui.printMenu(gamesTitles);
	int option = this.tui.askOption();
	while (option != 0) {
	    this.tui.printTitleGame(gamesTitles, option);
	    Game g = null;
	    switch (option) {
	    case 1:
		g = new GuessNumber();
		break;
	    case 2:
		g = new Hangman();
		break;
	    }
	    boolean win = false;

	    while (!win && g.getLifes() > 0) {
		String guess = this.tui.askGuess();
		if (g.goodGuess(guess)) {
		    win = true;
		} else {
		    g.looseLife();
		    if (g.getLifes() > 0) {
			this.tui.printHint(g.hint());
		    }
		}
	    }
	    if (win) {
		this.tui.printWin();
	    } else {
		this.tui.printLoose();
		this.tui.printSolution(g.getSolution());
	    }

	    this.tui.printMenu(gamesTitles);
	    option = this.tui.askOption();
	}
    }
}