package de.ostfalia.prog.ws21.iterator;
 
import de.ostfalia.prog.ws21.enums.Farbe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
 

public class PlayerIterator implements Iterator, Serializable {
	 private LinkedList<Farbe> players;
	private Farbe currentPlayer;

	public Farbe getCurrentPlayer() {
		return players.get(current);
	}

	public LinkedList<Farbe> getPlayers() {
		return players;
	}

	public int getCurrent() {
		return current;
	}

	int current=0;
	    public PlayerIterator( LinkedList<Farbe> player) {
			this.players=player;
		}
		@Override
		public boolean hasNext() {
			return players != null && current < players.size() - 1 && players.get(current + 1) != null;

		}
		@Override
		public Object Next() {
			current = ((current +1 )% players.size()) ;
			return players.get(current);
		}
 
}